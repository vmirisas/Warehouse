package com.vmirisas.springbootproject.warehouse.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface TransactionFormRepositoryCustom {
    Long getLastTransactionFormId();

}
