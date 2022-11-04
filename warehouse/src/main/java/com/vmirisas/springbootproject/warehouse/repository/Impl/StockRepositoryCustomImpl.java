package com.vmirisas.springbootproject.warehouse.repository.Impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.vmirisas.springbootproject.warehouse.entity.QStock;
import com.vmirisas.springbootproject.warehouse.entity.Stock;
import com.vmirisas.springbootproject.warehouse.repository.StockRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StockRepositoryCustomImpl implements StockRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    QStock qStock = QStock.stock;

    @Override
    public int getStockToExport(String barcode, String shelfCode) {
        JPAQuery<QStock> qStockJPAQuery = new JPAQuery<>(em);
        int quantity = qStockJPAQuery.select(qStock.quantity).from(qStock).where(qStock.product.barcode.eq(barcode).and(qStock.shelf.shelfCode.eq(shelfCode))).orderBy(qStock.stockId.desc()).fetchFirst();

        return quantity;
    }

    public Stock getStockExistence(String barcode, String shelfCode) {
        JPAQuery<QStock> qStockJPAQuery = new JPAQuery<>(em);
        Stock stock = qStockJPAQuery.select(qStock).from(qStock).where(qStock.product.barcode.eq(barcode).and(qStock.shelf.shelfCode.eq(shelfCode))).orderBy(qStock.stockId.desc()).fetchFirst();

        return stock;
    }
}
