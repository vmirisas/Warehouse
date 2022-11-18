package com.vmirisas.springbootproject.warehouse.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.sql.SQLExpressions;
import com.vmirisas.springbootproject.warehouse.dto.StockDTO;
import com.vmirisas.springbootproject.warehouse.dto.search.StockSearch;
import com.vmirisas.springbootproject.warehouse.entity.QProduct;
import com.vmirisas.springbootproject.warehouse.entity.QShelf;
import com.vmirisas.springbootproject.warehouse.entity.QStock;
import com.vmirisas.springbootproject.warehouse.entity.Stock;
import com.vmirisas.springbootproject.warehouse.repository.StockRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class StockRepositoryCustomImpl implements StockRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    private final QStock qStock = QStock.stock;
    private final QShelf qShelf = QShelf.shelf;
    private final QProduct qProduct = QProduct.product;

//    @Override
//    public List<StockDTO> search(StockSearch searchArgs) {
//        return generalQuery(projection())
//                .where(predicate(searchArgs))
//                .fetch();
//    }

    @Override
    public List<StockDTO> search(StockSearch searchArgs) {
        return selectQuery(projection())
                .where(predicate(searchArgs))
                .fetch();
    }


    private Predicate predicate(StockSearch search) {
        BooleanBuilder pre = new BooleanBuilder();

        if (search.getBarcode() != null) {
            pre.and(qProduct.barcode.eq(search.getBarcode()));
        }
        if (search.getDate() != null) {
            pre.and(SQLExpressions.date(qStock.date).loe(search.getDate()));
        }

        return pre;
    }

    @Override
    public int getStockToExport(String barcode, String shelfCode) {
        JPAQuery<QStock> qStockJPAQuery = new JPAQuery<>(em);
        int quantity = qStockJPAQuery.select(qStock.quantity).from(qStock).where(qStock.product.barcode.eq(barcode).and(qStock.shelf.shelfCode.eq(shelfCode))).orderBy(qStock.stockId.desc()).fetchFirst();

        return quantity;
    }
    @Override
    public Stock getStockExistence(String barcode, String shelfCode) {
        JPAQuery<QStock> qStockJPAQuery = new JPAQuery<>(em);
        Stock stock = qStockJPAQuery.select(qStock).from(qStock).where(qStock.product.barcode.eq(barcode).and(qStock.shelf.shelfCode.eq(shelfCode))).orderBy(qStock.stockId.desc()).fetchFirst();

        return stock;
    }
    @Override
    public Stock getStockFromBarcodeAndDate (String barcode, Date date) {
        JPAQuery<QStock> qStockJPAQuery = new JPAQuery<>(em);
        Stock stock = qStockJPAQuery.select(qStock).from(qStock).where(qStock.product.barcode.eq(barcode).and(qStock.date.lt(date))).orderBy(qStock.date.desc()).fetchFirst();
        return stock;
    }

    private <U> JPAQuery<U> generalQuery(Expression<U> select) {
        JPAQuery<U> query = new JPAQuery<>(em);
        return query.select(select).from(qStock)
                .leftJoin(qStock.product, qProduct)
//                .leftJoin(qProduct).on(qStock.product.productId.eq(qProduct.productId))
                .leftJoin(qStock.shelf, qShelf);
    }

    private <U> JPAQuery<U> selectQuery(Expression<U> select) {
        JPAQuery<U> query = new JPAQuery<>(em);
        QStock s = new QStock("s");
        QShelf sh = new QShelf("sh");
        QProduct p = new QProduct("p");
        query.select(select).from(qStock)
                .innerJoin(qStock.shelf, qShelf)
                .innerJoin(qStock.product, qProduct)
                .where(qStock.date.eq(
                        JPAExpressions.select(s.date.max()).from(s)
                                .innerJoin(s.shelf, sh)
                                .innerJoin(s.product, p)
                                .where(sh.shelfCode.eq(qShelf.shelfCode).and(p.barcode.eq(qProduct.barcode)))
                        )
                );
        return query;
    }

    private FactoryExpression<StockDTO> projection() {
        return Projections.bean(StockDTO.class,
                qStock.stockId,

                qProduct.barcode.as("barcode"),

                qShelf.shelfCode.as("shelfCode"),

                qStock.quantity,
                qStock.date
        );
    }

}
