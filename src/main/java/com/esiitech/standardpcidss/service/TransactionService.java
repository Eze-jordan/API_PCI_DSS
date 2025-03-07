package com.esiitech.standardpcidss.service;
import com.esiitech.standardpcidss.model.Transaction;
import com.esiitech.standardpcidss.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public Transaction saveTransaction(Transaction transaction) throws Exception {
        transaction.setNumPan(CryptoService.encrypt(transaction.getNumPan()));
        transaction.setDateFinValidite(CryptoService.encrypt(transaction.getDateFinValidite()));
        transaction.setCvx(CryptoService.encrypt(transaction.getCvx()));
        return transactionRepository.save(transaction);
    }


    public List<Transaction> getAllTransactions() throws Exception {
        return transactionRepository.findAll().stream().map(transaction -> {
            try {
                transaction.setNumPan(maskPan(CryptoService.decrypt(transaction.getNumPan())));
                transaction.setDateFinValidite(CryptoService.decrypt(transaction.getDateFinValidite()));
                transaction.setCvx(CryptoService.decrypt(transaction.getCvx()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return transaction;
        }).collect(Collectors.toList());
    }

    private String maskPan(String pan) {
        return pan.substring(0, 6) + "  XX XXXX " + pan.substring(pan.length() - 4);
    }


}
