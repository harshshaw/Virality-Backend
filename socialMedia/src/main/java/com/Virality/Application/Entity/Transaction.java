package com.Virality.Application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID userId;
    private TypeofTransaction transactionType;
    private Double transactionAmount;
    private StatusTransaction transactionStatus;
    private UUID purchasedUserId;
    private Integer unitsPurchased;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public TypeofTransaction getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TypeofTransaction transactionType) {
        this.transactionType = transactionType;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public StatusTransaction getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(StatusTransaction transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public UUID getPurchasedUserId() {
        return purchasedUserId;
    }

    public void setPurchasedUserId(UUID purchasedUserId) {
        this.purchasedUserId = purchasedUserId;
    }

    public Integer getUnitsPurchased() {
        return unitsPurchased;
    }

    public void setUnitsPurchased(Integer unitsPurchased) {
        this.unitsPurchased = unitsPurchased;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
