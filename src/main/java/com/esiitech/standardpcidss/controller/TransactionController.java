package com.esiitech.standardpcidss.controller;

import com.esiitech.standardpcidss.model.Transaction;
import com.esiitech.standardpcidss.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342") // Autorise les requêtes du frontend
@RequestMapping("/transactions")
@Tag(name = "Transactions", description = "API pour gérer les transactions monétiques sécurisées")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Créer une nouvelle transaction", description = "Permet d'ajouter une transaction avec des données chiffrées")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) throws Exception {
        return transactionService.saveTransaction(transaction);
    }

    @Operation(summary = "Obtenir toutes les transactions", description = "Récupère la liste de toutes les transactions enregistrées")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des transactions récupérée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping
    public List<Transaction> getTransactions() throws Exception {
        return transactionService.getAllTransactions();
    }

}
