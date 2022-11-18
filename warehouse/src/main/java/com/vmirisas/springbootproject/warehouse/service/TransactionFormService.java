package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;

import java.util.List;

public interface TransactionFormService {

    List<TransactionForm> findAll();
    TransactionForm findById (Long theId);
    TransactionForm save(TransactionFormDTO theTransactionForm);
    void deleteById(Long theId);
    //Long getLastTransactionFormId();
    List<TransactionFormDTO> toDtoList(List<TransactionForm> forms);
    TransactionForm toEntity(TransactionFormDTO transactionFormDTO);
}
