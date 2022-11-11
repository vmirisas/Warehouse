package com.vmirisas.springbootproject.warehouse.repository.Impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.vmirisas.springbootproject.warehouse.entity.QTransactionForm;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import com.vmirisas.springbootproject.warehouse.repository.TransactionFormRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TransactionFormRepositoryCustomImpl implements TransactionFormRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    QTransactionForm qTransactionForm = QTransactionForm.transactionForm;

    @Override
    public Long getLastTransactionFormId() {
        JPAQuery<QTransactionForm> qTransactionFormJPAQuery = new JPAQuery<>(em);
        TransactionForm transactionForm = qTransactionFormJPAQuery.select(qTransactionForm).from(qTransactionForm).orderBy(qTransactionForm.transactionFormId.desc()).fetchFirst();
        Long transactionFormId = transactionForm.getTransactionFormId();
        return transactionFormId;
    }
}
