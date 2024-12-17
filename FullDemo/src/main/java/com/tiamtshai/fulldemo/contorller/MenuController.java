package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.Item;
import com.tiamtshai.fulldemo.model.ShopInfo;
import com.tiamtshai.fulldemo.rowmapper.ShopInfoRowMapper;
import com.tiamtshai.fulldemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/{shopId}")
    public ResponseEntity<List<Item>> getItemsByShopId(@PathVariable int shopId) {
        List<Item> items = menuService.getItemsByShopId(shopId);
        if (items.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
        }
        return ResponseEntity.ok(items);
    }

    @GetMapping("/shopinfo")
    public ResponseEntity<List<ShopInfo>> getRecommendShops(@RequestParam int shopId) {
        String sql = "SELECT * FROM shop_info WHERE shop_id = :shopId";

        // 定義參數，將 shopId 的值綁定到 SQL 查詢中
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("shopId", shopId);

        // 執行查詢
        List<ShopInfo> shop = namedParameterJdbcTemplate.query(sql, params, new ShopInfoRowMapper());

        return ResponseEntity.ok(shop);
    }
}
