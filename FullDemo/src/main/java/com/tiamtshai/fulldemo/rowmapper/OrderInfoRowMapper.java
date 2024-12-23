package com.tiamtshai.fulldemo.rowmapper;

import com.tiamtshai.fulldemo.model.Item;
import com.tiamtshai.fulldemo.model.OrderInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderInfoRowMapper implements RowMapper<OrderInfo> {

    @Override
    public OrderInfo mapRow(ResultSet rs, int i) throws SQLException {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrder_id(rs.getInt("order_id"));
        orderInfo.setCustuser_id(rs.getInt("custuser_id"));
        orderInfo.setShop_id(rs.getInt("shop_id"));
        orderInfo.setOrder_time(rs.getTimestamp("order_time").toLocalDateTime());
        orderInfo.setOrder_status(rs.getString("order_status"));
        orderInfo.setSubtotal(rs.getInt("subtotal"));
        orderInfo.setDiscount(rs.getInt("discount"));
        orderInfo.setDelivery_fee(rs.getInt("delivery_fee"));
        orderInfo.setTotal_amount(rs.getInt("total_amount"));
        orderInfo.setPay_methood(rs.getString("pay_methood"));
        orderInfo.setOrder_name(rs.getString("order_name"));
        orderInfo.setOrder_phone(rs.getString("order_phone"));
        orderInfo.setOrder_address(rs.getString("order_address"));
        orderInfo.setDiscount_code(rs.getString("discount_code"));
        orderInfo.setRemarks(rs.getString("remarks"));
        orderInfo.setDetail_id(rs.getInt("detail_id"));
        orderInfo.setItem_id(rs.getInt("item_id"));
        orderInfo.setItem_name(rs.getString("item_name"));
        orderInfo.setItem_pic_url(rs.getString("item_pic_url"));
        orderInfo.setItem_price(rs.getInt("item_price"));
        orderInfo.setSugur_level(rs.getString("sugur_level"));
        orderInfo.setIce_level(rs.getString("ice_level"));
        orderInfo.setOrder_count(rs.getInt("order_count"));
        orderInfo.setItem_subtotal(rs.getInt("item_subtotal"));
        orderInfo.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        orderInfo.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
        return orderInfo;
    }

}
