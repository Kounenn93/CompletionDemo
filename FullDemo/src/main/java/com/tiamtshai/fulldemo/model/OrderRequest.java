package com.tiamtshai.fulldemo.model;

import com.tiamtshai.fulldemo.model.dto.CostInfo;
import com.tiamtshai.fulldemo.model.dto.OrderInfo;
import com.tiamtshai.fulldemo.model.dto.ShopCartItem;

import java.util.List;

public class OrderRequest {
    private List<ShopCartItem> cart;
    private OrderInfo orderInfo;
    private CostInfo costInfo;

    public List<ShopCartItem> getCart() {
        return cart;
    }

    public void setCart(List<ShopCartItem> cart) {
        this.cart = cart;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public CostInfo getCostInfo() {
        return costInfo;
    }

    public void setCostInfo(CostInfo costInfo) {
        this.costInfo = costInfo;
    }

}
