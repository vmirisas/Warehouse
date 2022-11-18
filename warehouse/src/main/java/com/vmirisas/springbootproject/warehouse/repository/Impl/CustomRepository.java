package com.vmirisas.springbootproject.warehouse.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.sql.SQLExpressions;
import com.vmirisas.springbootproject.warehouse.entity.QFormDetail;
import com.vmirisas.springbootproject.warehouse.entity.QProduct;
import com.vmirisas.springbootproject.warehouse.entity.QShelf;
import com.vmirisas.springbootproject.warehouse.entity.QTransactionForm;
import com.vmirisas.springbootproject.warehouse.entity.enums.FormType;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomRepository {

    private final QFormDetail qFormDetail = QFormDetail.formDetail;
    private final QTransactionForm qTransactionForm = QTransactionForm.transactionForm;
    private final QProduct qProduct = QProduct.product;
    private final QShelf qShelf = QShelf.shelf;


    public Integer getLatestQuantity(Date date, String productBarcode, String shelfCode) {
        BooleanBuilder pre = new BooleanBuilder();
        pre.and(SQLExpressions.date(qTransactionForm.date).loe(date));
        pre.and(qProduct.barcode.eq(productBarcode));
        if (shelfCode != null) pre.and(qShelf.shelfCode.eq(shelfCode));

        JPAQuery<?> query =  new JPAQuery<>();

        query.from(qFormDetail)
                .innerJoin(qTransactionForm)
                .innerJoin(qFormDetail.product, qProduct)
                .innerJoin(qFormDetail.shelf, qShelf);

        return query.select(normalizedQuantity().sum())
                .where(pre)
                .fetchFirst();
    }

    private NumberExpression<Integer> normalizedQuantity() {
        return new CaseBuilder()
                .when(qTransactionForm.type.eq(FormType.IMPORT))
                .then(qFormDetail.quantity).otherwise(qFormDetail.quantity.negate());
    }

}
