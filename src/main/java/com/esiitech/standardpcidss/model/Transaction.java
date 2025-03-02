package com.esiitech.standardpcidss.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "monetico_transactions")
public class Transaction {

    @Id
    @Column(name = "ID_TRX")
    private String id;  // Utilisation de String pour stocker "TRX00X"
    @Column(name = "DATE_TRX")
    private String dateTransaction;
    @Column(name = "HEURE_TRX")
    private String heureTransaction;
    @Column(name = "ORIG_TRX")
    private String origine;
    @Column(name = "MOYEN")
    private String moyenPaiement;

    @Lob
    @Column(name = "NUMPAN")
    private String numPan;  // Chiffré en base de données

    @Lob
    @Column(name = "DATEFIN")
    private String dateFinValidite;  // Chiffré en base de données

    @Lob
    @Column(name = "CVX")
    private String cvx;  // Chiffré en base de données
    @Column(name = "MNT")
    private Double montant;
    @Column(name = "DEVISE")
    private String devise;
    @Column(name = "ID_BANK_AC")
    private String identifiantBanqueAcquereur;
    @Column(name = "ID_BANK_EM")
    private String identifiantBanqueEmetteur;
    @Column(name = "SCHEME")
    private String scheme;
    @Column(name = "TYPE_PRO")
    private String typeProduit;

    // ✅ Génération de l'ID avant insertion
    @PrePersist
    public void generateId() {
        this.id = "TRX00" + UUID.randomUUID().toString().substring(0, 2).toUpperCase();
    }

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

    public String getIdentifiantBanqueAcquereur() {
        return identifiantBanqueAcquereur;
    }

    public void setIdentifiantBanqueAcquereur(String identifiantBanqueAcquereur) {
        this.identifiantBanqueAcquereur = identifiantBanqueAcquereur;
    }

    public String getIdentifiantBanqueEmetteur() {
        return identifiantBanqueEmetteur;
    }

    public void setIdentifiantBanqueEmetteur(String identifiantBanqueEmetteur) {
        this.identifiantBanqueEmetteur = identifiantBanqueEmetteur;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }
}
