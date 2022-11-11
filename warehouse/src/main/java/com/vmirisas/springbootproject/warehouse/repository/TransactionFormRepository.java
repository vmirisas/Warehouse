package com.vmirisas.springbootproject.warehouse.repository;

import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionFormRepository extends JpaRepository<TransactionForm, Long>, TransactionFormRepositoryCustom {

    Long getLastTransactionFormId();
}
