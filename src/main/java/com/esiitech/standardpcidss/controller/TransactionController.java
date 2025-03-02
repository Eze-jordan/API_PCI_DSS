package com.esiitech.standardpcidss.controller;


import com.esiitech.standardpcidss.model.Transaction;
import com.esiitech.standardpcidss.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342") // Ton port frontend
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) throws Exception {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions() throws Exception {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/transactions")
    public String getTransactionsPage() {
        return "PCI_DSS"; // Le nom du fichier HTML sans l'extension .html
    }
}