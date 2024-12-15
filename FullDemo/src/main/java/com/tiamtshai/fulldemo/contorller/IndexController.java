package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.ShopInfo;
import com.tiamtshai.fulldemo.rowmapper.ShopInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/shops")
    public ResponseEntity<List<ShopInfo>> getRecommendShops() {

        String sql = "( SELECT * FROM shop_info WHERE shop_type = '飲料' LIMIT 6) UNION ALL (SELECT * FROM shop_info WHERE shop_type = '食物' LIMIT 6)";

        //namedParameterJdbcTemplate.query方法，返回的為List型別的值，故盡量不要使用ArrayList，不然還要再進行強轉，較為麻煩。
        List<ShopInfo> shopList =namedParameterJdbcTemplate.query(sql, new ShopInfoRowMapper() );

        return ResponseEntity.ok(shopList);
    }

}
