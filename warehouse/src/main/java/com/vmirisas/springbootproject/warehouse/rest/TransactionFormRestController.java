package com.vmirisas.springbootproject.warehouse.rest;

import com.vmirisas.springbootproject.warehouse.dto.TransactionFormDTO;
import com.vmirisas.springbootproject.warehouse.service.TransactionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
public class TransactionFormRestController {

    @Autowired
    private TransactionFormService transactionFormService;

    @GetMapping("")
    public List<TransactionFormDTO> findAll() {
        return this.transactionFormService.toDtoList(this.transactionFormService.findAll());
    }

    @GetMapping("/{transactionFormId}")
    public TransactionFormDTO getTransactionForm(@PathVariable Long transactionFormId) {
        return new TransactionFormDTO(this.transactionFormService.findById(transactionFormId));
    }

    @PostMapping("")
    public TransactionFormDTO addTransactionForm(@RequestBody TransactionFormDTO theTransactionForm) {
        // also just in case the pass an ID in JSON ... set id to null
        theTransactionForm.setTransactionFormId(null);
        return new TransactionFormDTO(this.transactionFormService.save(theTransactionForm));
    }

    @PutMapping("")
    public TransactionFormDTO updateTransactionForm(@RequestBody TransactionFormDTO theTransactionForm) {
        return new TransactionFormDTO(this.transactionFormService.save(theTransactionForm));
    }

    @DeleteMapping("/{transactionFormId}")
    public String deleteTransactionForm(@PathVariable Long transactionFormId) {
        transactionFormService.deleteById(transactionFormId);
        return "Deleted Transaction Form with id  '" + transactionFormId + "'";
    }
}
