package com.tiamtshai.fulldemo.rowmapper;

import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.ShopInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class ShopInfoRowMapper implements RowMapper<ShopInfo> {
    @Override
    public ShopInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        ShopInfo shop = new ShopInfo();

        shop.setShopId(resultSet.getInt("shop_id"));
        shop.setShopMainName(resultSet.getString("shop_mainname"));
        shop.setShopBranchName(resultSet.getString("shop_branchname"));
        shop.setShopType(resultSet.getString("shop_type"));
        shop.setShopCity(resultSet.getString("shop_city"));
        shop.setShopDist(resultSet.getString("shop_dist"));
        shop.setShopAddress(resultSet.getString("shop_address"));
        shop.setShopLongitude(resultSet.getBigDecimal("shop_longitude"));
        shop.setShopLatitude(resultSet.getBigDecimal("shop_latitude"));
        shop.setShopPhone(resultSet.getString("shop_phone"));
        shop.setShopEmail(resultSet.getString("shop_email"));
        shop.setShopLogoUrl(resultSet.getString("shop_logourl"));
        shop.setShopCoverUrl(resultSet.getString("shop_coverurl"));
        shop.setOpeningHours(resultSet.getString("opening_hours"));
        shop.setRating(resultSet.getBigDecimal("rating"));
        shop.setTotalReviews(resultSet.getInt("total_reviews"));
        shop.setDeliveryFee(resultSet.getBigDecimal("delivery_fee"));
        shop.setShopStatus(resultSet.getString("shop_status"));
        shop.setCreatedAt(resultSet.getTimestamp("created_at").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        shop.setUpdatedAt(resultSet.getTimestamp("updated_at").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

        return shop;

    }
}
