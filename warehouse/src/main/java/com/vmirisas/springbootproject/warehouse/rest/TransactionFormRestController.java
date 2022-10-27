package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import com.vmirisas.springbootproject.warehouse.service.TransactionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionFormRestController {

    @Autowired
    private TransactionFormService transactionFormService;

    @GetMapping("/transactionForm")
    public List<TransactionFormDTO> findAll() {
        return transactionFormService.findAll();
    }

    @GetMapping("/transactionForm/{transactionFormId}")
    public TransactionFormDTO getTransactionForm(@PathVariable Long transactionFormId) {

        TransactionFormDTO theTransactionForm = transactionFormService.findById(transactionFormId);

        if(theTransactionForm == null) {
            throw new RuntimeException("Transaction Form id not found - " + transactionFormId);
        }

        return theTransactionForm;
    }

    @PostMapping("/transactionForm")
    public TransactionFormDTO addTransactionForm(@RequestBody TransactionFormDTO theTransactionForm) {
        // also just in case the pass an ID in JSON ... set id to null

        theTransactionForm.setTransactionFormId(0L);

        transactionFormService.save(theTransactionForm);

        return theTransactionForm;
    }

    @PutMapping("/transactionForm")
    public TransactionFormDTO updateTransactionForm(@RequestBody TransactionFormDTO theTransactionForm) {

        transactionFormService.save(theTransactionForm);

        return theTransactionForm;
    }

    @DeleteMapping("/transactionForm/{transactionFormId}")
    public String deleteTransactionForm(@PathVariable Long transactionFormId) {

        TransactionFormDTO tempTransactionForm = transactionFormService.findById(transactionFormId);

        if (tempTransactionForm == null) {

            throw new RuntimeException("Transaction Form id not found - " + transactionFormId);
        }

        transactionFormService.deleteById(transactionFormId);

        return "Deleted Transaction Form id - " + transactionFormId;
    }
}
