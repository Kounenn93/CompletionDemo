package com.tiamtshai.fulldemo.dao;

import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.dto.CostInfo;
import com.tiamtshai.fulldemo.model.dto.OrderInfo;
import com.tiamtshai.fulldemo.model.dto.ShopCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderMainDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int cartInsertOrderMain(ShopCartItem shopCartItem, OrderInfo orderInfo, CostInfo costInfo, CustUsers custUser){
        //寫進order_main
        Map<String, Object> map = new HashMap<>();

        //用map裝各個要插入的數值
        map.put("custuser_id", custUser.getCustuser_id());
        map.put("shop_id",shopCartItem.getShopId());
        map.put("subtotal", costInfo.getSubTotal());
        map.put("discount", costInfo.getDiscount());
        map.put("delivery_fee", costInfo.getDeliveryFee());
        map.put("total_amount", costInfo.getTotalAmount());
        map.put("order_name", orderInfo.getOrderName());
        map.put("order_phone", orderInfo.getOrderPhone());
        map.put("order_address", orderInfo.getOrderAddress());
        map.put("discount_code", orderInfo.getDiscountCode());
        String sql = "INSERT INTO orders_main(custuser_id, shop_id, subtotal, discount, delivery_fee, total_amount, order_name, order_phone, order_address, discount_code) VALUES (:custuser_id, :shop_id, :subtotal, :discount, :delivery_fee, :total_amount, :order_name, :order_phone, :order_address, :discount_code)";
        namedParameterJdbcTemplate.update(sql,map);

        String lastIdSql = "SELECT LAST_INSERT_ID()";
        return namedParameterJdbcTemplate.queryForObject(lastIdSql, new HashMap<>(), Integer.class);
    }


}
