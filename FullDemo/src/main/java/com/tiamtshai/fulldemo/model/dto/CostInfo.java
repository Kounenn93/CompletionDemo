package com.tiamtshai.fulldemo.model.dto;

public class CostInfo{
    private int subTotal;
    private int discount;
    private int deliveryFee;
    private int totalAmount;

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "CostInfo{" +
                "subTotal=" + subTotal +
                ", discount=" + discount +
                ", deliveryFee=" + deliveryFee +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
