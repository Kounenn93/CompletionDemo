package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.Item;
import com.tiamtshai.fulldemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{shopId}")
    public ResponseEntity<List<Item>> getItemsByShopId(@PathVariable int shopId) {
        List<Item> items = menuService.getItemsByShopId(shopId);
        if (items.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(items);
        }
        return ResponseEntity.ok(items);
    }


}
