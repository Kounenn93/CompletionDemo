package com.tiamtshai.fulldemo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShopInfo {
    private int shopId;
    private String shopMainName;
    private String shopBranchName;
    private String shopType;
    private String shopCity;
    private String shopDist;
    private String shopAddress;
    private BigDecimal shopLongitude;
    private BigDecimal shopLatitude;
    private String shopPhone;
    private String shopEmail;
    private String shopLogoUrl;
    private String shopCoverUrl;
    private String openingHours;
    private BigDecimal rating;
    private int totalReviews;
    private BigDecimal deliveryFee;
    private String shopStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopMainName() {
        return shopMainName;
    }

    public void setShopMainName(String shopMainName) {
        this.shopMainName = shopMainName;
    }

    public String getShopBranchName() {
        return shopBranchName;
    }

    public void setShopBranchName(String shopBranchName) {
        this.shopBranchName = shopBranchName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopCity() {
        return shopCity;
    }

    public void setShopCity(String shopCity) {
        this.shopCity = shopCity;
    }

    public String getShopDist() {
        return shopDist;
    }

    public void setShopDist(String shopDist) {
        this.shopDist = shopDist;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public BigDecimal getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(BigDecimal shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    public BigDecimal getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(BigDecimal shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopLogoUrl() {
        return shopLogoUrl;
    }

    public void setShopLogoUrl(String shopLogoUrl) {
        this.shopLogoUrl = shopLogoUrl;
    }

    public String getShopCoverUrl() {
        return shopCoverUrl;
    }

    public void setShopCoverUrl(String shopCoverUrl) {
        this.shopCoverUrl = shopCoverUrl;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "shopId=" + shopId +
                ", shopMainName='" + shopMainName + '\'' +
                ", shopBranchName='" + shopBranchName + '\'' +
                ", shopType='" + shopType + '\'' +
                ", shopCity='" + shopCity + '\'' +
                ", shopDist='" + shopDist + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopLongitude='" + shopLongitude + '\'' +
                ", shopLatitude='" + shopLatitude + '\'' +
                ", shopPhone='" + shopPhone + '\'' +
                ", shopEmail='" + shopEmail + '\'' +
                ", shopLogoUrl='" + shopLogoUrl + '\'' +
                ", shopCoverUrl='" + shopCoverUrl + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", rating=" + rating +
                ", totalReviews=" + totalReviews +
                ", deliveryFee=" + deliveryFee +
                ", shopStatus='" + shopStatus + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
