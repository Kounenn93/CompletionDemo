package com.tiamtshai.fulldemo.service;

import com.tiamtshai.fulldemo.dao.MenuDao;
import com.tiamtshai.fulldemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public List<Item> getItemsByShopId(int shopId){
        return menuDao.findItemByShopId(shopId);
    }
}
