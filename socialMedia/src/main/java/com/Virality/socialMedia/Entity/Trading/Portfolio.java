package com.Virality.socialMedia.Entity.Trading;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity(name = "Portfolio")
public class Portfolio {

    @Id
    private UUID userId;

    private List<UUID> purchasedUserIds;

    private Integer unitsPurchased;

    private Double pAndL;

    private Double purchasedPrice;

    private Double currentPrice;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<UUID> getPurchasedUserIds() {
        return purchasedUserIds;
    }

    public void setPurchasedUserIds(List<UUID> purchasedUserIds) {
        this.purchasedUserIds = purchasedUserIds;
    }

    public Integer getUnitsPurchased() {
        return unitsPurchased;
    }

    public void setUnitsPurchased(Integer unitsPurchased) {
        this.unitsPurchased = unitsPurchased;
    }

    public Double getpAndL() {
        return pAndL;
    }

    public void setpAndL(Double pAndL) {
        this.pAndL = pAndL;
    }

    public Double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
