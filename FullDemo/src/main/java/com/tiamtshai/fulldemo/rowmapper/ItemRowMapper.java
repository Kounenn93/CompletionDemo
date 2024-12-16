package com.tiamtshai.fulldemo.rowmapper;

import com.tiamtshai.fulldemo.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int i) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("item_id"));
        item.setItemCategory(rs.getString("item_category"));
        item.setItemName(rs.getString("item_name"));
        item.setItemPrice(rs.getInt("item_price"));
        item.setItemPicUrl(rs.getString("item_picurl"));
        item.setItemDescription(rs.getString("item_description"));
        item.setItemStatus(rs.getString("item_status"));
        item.setShopId(rs.getInt("shop_id"));
        return item;
    }
}
