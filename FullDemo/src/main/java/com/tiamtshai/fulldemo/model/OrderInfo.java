package com.tiamtshai.fulldemo.model;

import java.time.LocalDateTime;

public class OrderInfo {
    private int order_id;
    private int custuser_id;
    private int shop_id;
    private LocalDateTime order_time;
    private String order_status;
    private int subtotal;
    private int discount;
    private int delivery_fee;
    private int total_amount;
    private String pay_methood;
    private String order_name;
    private String order_phone;
    private String order_address;
    private String discount_code;
    private String remarks;
    private int detail_id;
    private int item_id;
    private String item_name;
    private String item_pic_url;
    private int item_price;
    private String sugur_level;
    private String ice_level;
    private int order_count;
    private int item_subtotal;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustuser_id() {
        return custuser_id;
    }

    public void setCustuser_id(int custuser_id) {
        this.custuser_id = custuser_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public LocalDateTime getOrder_time() {
        return order_time;
    }

    public void setOrder_time(LocalDateTime order_time) {
        this.order_time = order_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(int delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getPay_methood() {
        return pay_methood;
    }

    public void setPay_methood(String pay_methood) {
        this.pay_methood = pay_methood;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_pic_url() {
        return item_pic_url;
    }

    public void setItem_pic_url(String item_pic_url) {
        this.item_pic_url = item_pic_url;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public String getSugur_level() {
        return sugur_level;
    }

    public void setSugur_level(String sugur_level) {
        this.sugur_level = sugur_level;
    }

    public String getIce_level() {
        return ice_level;
    }

    public void setIce_level(String ice_level) {
        this.ice_level = ice_level;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public int getItem_subtotal() {
        return item_subtotal;
    }

    public void setItem_subtotal(int item_subtotal) {
        this.item_subtotal = item_subtotal;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "order_id=" + order_id +
                ", custuser_id=" + custuser_id +
                ", shop_id=" + shop_id +
                ", order_time=" + order_time +
                ", order_status='" + order_status + '\'' +
                ", subtotal=" + subtotal +
                ", discount=" + discount +
                ", delivery_fee=" + delivery_fee +
                ", total_amount=" + total_amount +
                ", pay_methood='" + pay_methood + '\'' +
                ", order_name='" + order_name + '\'' +
                ", order_phone='" + order_phone + '\'' +
                ", order_address='" + order_address + '\'' +
                ", discount_code='" + discount_code + '\'' +
                ", remarks='" + remarks + '\'' +
                ", detail_id=" + detail_id +
                ", item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_pic_url='" + item_pic_url + '\'' +
                ", item_price=" + item_price +
                ", sugur_level='" + sugur_level + '\'' +
                ", ice_level='" + ice_level + '\'' +
                ", order_count=" + order_count +
                ", item_subtotal=" + item_subtotal +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
