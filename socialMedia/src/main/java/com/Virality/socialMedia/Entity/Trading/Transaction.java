package com.Virality.socialMedia.Entity.Trading;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer userId;
    private TypeofTransaction transactionType;
    private Double transactionAmount;
    private StatusTransaction transactionStatus;
    private Integer purchasedUserId;
    private Integer unitsPurchased;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getPurchasedUserId() {
        return purchasedUserId;
    }

    public void setPurchasedUserId(Integer purchasedUserId) {
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
