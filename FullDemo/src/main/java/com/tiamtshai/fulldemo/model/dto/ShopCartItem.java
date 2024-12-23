package com.tiamtshai.fulldemo.model.dto;

public class ShopCartItem {
    private int shopId;
    private String itemPicUrl;
    private int itemId;
    private String itemName;
    private String sugarLevel;
    private String iceLevel;
    private int itemCount;
    private int subtal;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(String sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public String getIceLevel() {
        return iceLevel;
    }

    public void setIceLevel(String iceLevel) {
        this.iceLevel = iceLevel;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getSubtal() {
        return subtal;
    }

    public void setSubtal(int subtal) {
        this.subtal = subtal;
    }

    @Override
    public String toString() {
        return "ShopCartItem{" +
                "shopId=" + shopId +
                ", itemPicUrl='" + itemPicUrl + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sugarLevel='" + sugarLevel + '\'' +
                ", iceLevel='" + iceLevel + '\'' +
                ", itemCount=" + itemCount +
                ", subtal=" + subtal +
                '}';
    }
}
