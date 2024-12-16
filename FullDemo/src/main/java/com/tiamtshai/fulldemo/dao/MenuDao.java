package com.tiamtshai.fulldemo.dao;

import com.tiamtshai.fulldemo.model.Item;
import com.tiamtshai.fulldemo.rowmapper.ItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MenuDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Item> findItemByShopId(int shopId){
        String sql = "SELECT * FROM item WHERE shop_id=:shopId AND (item_status = '上架' OR '停售')";
        Map<String , Object> map = new HashMap<>();
        map.put("shopId",shopId);

        return namedParameterJdbcTemplate.query(sql, map, new ItemRowMapper());
    }
}
