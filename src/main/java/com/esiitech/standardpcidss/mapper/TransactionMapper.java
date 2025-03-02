package com.esiitech.standardpcidss.mapper;

import com.esiitech.standardpcidss.dto.TransactionDTO;
import com.esiitech.standardpcidss.model.Transaction;
import com.esiitech.standardpcidss.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    @Autowired
    private CryptoService cryptoService;  // Injection du service Crypto

    // Méthode pour convertir une entité Transaction en DTO
    public TransactionDTO toDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        // Convertir l'ID en String si nécessaire
        dto.setId(transaction.getId()); // transaction.getId() est déjà un String
        dto.setDateTransaction(transaction.getDateTransaction());
        dto.setHeureTransaction(transaction.getHeureTransaction());
        dto.setOrigine(transaction.getOrigine());
        dto.setMoyenPaiement(transaction.getMoyenPaiement());

        try {
            dto.setNumPan(cryptoService.decrypt(transaction.getNumPan()));
            dto.setDateFinValidite(cryptoService.decrypt(transaction.getDateFinValidite()));
            dto.setCvx(cryptoService.decrypt(transaction.getCvx()));
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du déchiffrement des données sensibles", e);
        }

        dto.setMontant(transaction.getMontant());
        dto.setDevise(transaction.getDevise());
        return dto;
    }

    // Méthode pour convertir un DTO en entité Transaction
    public Transaction toEntity(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        // Assurez-vous que l'ID est bien un String
        transaction.setId(dto.getId()); // dto.getId() est déjà un String
        transaction.setDateTransaction(dto.getDateTransaction());
        transaction.setHeureTransaction(dto.getHeureTransaction());
        transaction.setOrigine(dto.getOrigine());
        transaction.setMoyenPaiement(dto.getMoyenPaiement());

        try {
            transaction.setNumPan(cryptoService.encrypt(dto.getNumPan()));
            transaction.setDateFinValidite(cryptoService.encrypt(dto.getDateFinValidite()));
            transaction.setCvx(cryptoService.encrypt(dto.getCvx()));
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du chiffrement des données sensibles", e);
        }

        transaction.setMontant(dto.getMontant());
        transaction.setDevise(dto.getDevise());
        return transaction;
    }
}
