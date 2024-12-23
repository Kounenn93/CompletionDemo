package com.tiamtshai.fulldemo.service;

import com.tiamtshai.fulldemo.dao.OrderDetailsDao;
import com.tiamtshai.fulldemo.dao.OrderMainDao;
import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.OrderRequest;
import com.tiamtshai.fulldemo.model.dto.ShopCartItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderMainDao orderMainDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    //驗證前端傳送過來的金額是否正確（目前均先假設無折扣及無運送費）
    public boolean validateSubTotal(OrderRequest orderRequest) {
        List<ShopCartItem> cart = orderRequest.getCart();

        int calculatedSubTotal = 0;
        for (int i = 0; i< cart.size(); i++) {
            ShopCartItem shopCartItem = cart.get(i);
            int itemCount = shopCartItem.getItemCount(); //取得購物車內第i筆的商品數量
            //取得第i筆商品的Id，而後進到資料庫取得資料庫的單價
            int itemId = shopCartItem.getItemId();
            //調用下方getItemPrice function取得資料庫內商品單價
            int itemPrice = getItemPrice(itemId);
            calculatedSubTotal += itemPrice * itemCount;
        }
        return calculatedSubTotal == orderRequest.getCostInfo().getSubTotal(); //如果正確返回true，否則false。
    }

    //取得資料庫內的商品單價
    private int getItemPrice(int itemId) {
        String sql = "SELECT item_price FROM item WHERE item_id = :itemId";
        Map<String, Object> params = new HashMap<>();
        params.put("itemId", itemId);
        return namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    public void insertOrder(OrderRequest orderRequest) {
        // 寫入訂單主表
        CustUsers custUser = (CustUsers) session.getAttribute("custUser");
        int orderId = orderMainDao.cartInsertOrderMain(orderRequest.getCart().get(0), orderRequest.getOrderInfo(), orderRequest.getCostInfo(), custUser);

        // 寫入訂單明細表
        orderDetailsDao.cartInserOrderDetails(orderId, orderRequest.getCart());
    }
}
