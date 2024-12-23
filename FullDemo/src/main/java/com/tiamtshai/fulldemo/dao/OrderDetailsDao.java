package com.tiamtshai.fulldemo.dao;

import com.tiamtshai.fulldemo.model.dto.ShopCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDetailsDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void cartInserOrderDetails(int order_id,List<ShopCartItem> cart){

        String sql = "INSERT INTO order_details(order_id,item_id,item_name,item_pic_url,item_price,sugur_level,ice_level,order_count,item_subtotal) VALUES (:order_id, :item_id, :item_name,:item_pic_url, :item_price, :sugur_level, :ice_level, :order_count, :item_subtotal)";


        //獲取要插入的欄位，並寫入資料庫
        for (int i = 0; i < cart.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            ShopCartItem shopCartItem = cart.get(i);
            map.put("order_id",order_id); //記得order_id也要寫進資料庫
            map.put("item_id",shopCartItem.getItemId());
            map.put("item_name",shopCartItem.getItemName());
            map.put("item_pic_url",shopCartItem.getItemPicUrl());
            map.put("item_price",(shopCartItem.getSubtal()/shopCartItem.getItemCount()));
            map.put("sugur_level",shopCartItem.getSugarLevel());
            map.put("ice_level",shopCartItem.getIceLevel());
            map.put("order_count",shopCartItem.getItemCount());
            map.put("item_subtotal",shopCartItem.getSubtal());
            namedParameterJdbcTemplate.update(sql,map);
        }
    }
}
