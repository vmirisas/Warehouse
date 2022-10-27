package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;

import java.util.List;

public interface TransactionFormService {

    List<TransactionFormDTO> findAll();
    TransactionFormDTO findById (Long theId);
    void save(TransactionFormDTO theTransactionForm);
    void deleteById(Long theId);
}
