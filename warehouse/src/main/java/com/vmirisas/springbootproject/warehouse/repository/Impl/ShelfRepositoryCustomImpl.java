package com.vmirisas.springbootproject.warehouse.repository.Impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.vmirisas.springbootproject.warehouse.entity.QShelf;
import com.vmirisas.springbootproject.warehouse.entity.Shelf;
import com.vmirisas.springbootproject.warehouse.repository.ShelfRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ShelfRepositoryCustomImpl implements ShelfRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    QShelf qShelf = QShelf.shelf;
    @Override
    public Shelf findShelfByCode(String shelfCode) {
        JPAQuery<QShelf> qShelfJPAQuery = new JPAQuery<>(em);
        Shelf shelf = qShelfJPAQuery.select(qShelf).from(qShelf).where(qShelf.shelfCode.eq(shelfCode)).fetchFirst();
        return shelf;
    }
}
