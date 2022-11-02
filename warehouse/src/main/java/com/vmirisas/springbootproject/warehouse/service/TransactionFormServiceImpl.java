package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import com.vmirisas.springbootproject.warehouse.entity.TransactionForm;
import com.vmirisas.springbootproject.warehouse.repository.TransactionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionFormServiceImpl implements TransactionFormService{

    @Autowired
    private TransactionFormRepository transactionFormRepository;

    @Override
    public List<TransactionFormDTO> findAll() {
        List<TransactionForm> transactionFormList = transactionFormRepository.findAll();
        List<TransactionFormDTO> transactionFormDTOList = new ArrayList<>();

        for(TransactionForm form:transactionFormList) {
            transactionFormDTOList.add(new TransactionFormDTO(form));
        }

        return transactionFormDTOList;
    }

    @Override
    public TransactionFormDTO findById(Long theId) {
        Optional<TransactionForm> result = transactionFormRepository.findById(theId);

        TransactionFormDTO theTransactionForm;

        if(result.isPresent()) {
            theTransactionForm = new TransactionFormDTO(result.get());
        } else {
            throw new RuntimeException("Did not find transaction form id - " + theId);
        }

        return theTransactionForm;
    }

    @Override
    public void save(TransactionFormDTO theTransactionForm) {

        TransactionForm transactionForm = new TransactionForm(theTransactionForm);
        transactionForm.setTransactionFormId(theTransactionForm.getTransactionFormId());
        transactionForm.setType(theTransactionForm.getType());
        transactionForm.setDate(new Date());
        transactionForm.setDescription(theTransactionForm.getDescription());

        transactionFormRepository.save(transactionForm);
    }

    @Override
    public void deleteById(Long theId) {
        transactionFormRepository.deleteById(theId);
    }
}
