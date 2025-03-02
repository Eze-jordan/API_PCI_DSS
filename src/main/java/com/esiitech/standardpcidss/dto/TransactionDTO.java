package com.esiitech.standardpcidss.dto;

public class TransactionDTO {
    private String id;
    private String dateTransaction;
    private String heureTransaction;
    private String origine;
    private String moyenPaiement;
    private String numPan;
    private String dateFinValidite;
    private String cvx;
    private Double montant;
    private String devise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getHeureTransaction() {
        return heureTransaction;
    }

    public void setHeureTransaction(String heureTransaction) {
        this.heureTransaction = heureTransaction;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(String moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public String getNumPan() {
        return numPan;
    }

    public void setNumPan(String numPan) {
        this.numPan = numPan;
    }

    public String getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(String dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public String getCvx() {
        return cvx;
    }

    public void setCvx(String cvx) {
        this.cvx = cvx;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
}
