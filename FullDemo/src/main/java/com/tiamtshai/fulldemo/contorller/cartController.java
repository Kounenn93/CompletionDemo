package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.Item;
import com.tiamtshai.fulldemo.model.OrderRequest;
import com.tiamtshai.fulldemo.model.dto.CostInfo;
import com.tiamtshai.fulldemo.model.dto.OrderInfo;
import com.tiamtshai.fulldemo.model.dto.ShopCartItem;
import com.tiamtshai.fulldemo.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopcart")
public class cartController {

    @Autowired
    private HttpSession session;

    @Autowired
    private CartService cartService;

    @PostMapping("/ordersubmit")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            // Validate subtotal
            if (cartService.validateSubTotal(orderRequest)) {
                cartService.insertOrder(orderRequest);
                return ResponseEntity.ok("成功建立訂單！");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("訂單無法成立，請稍後再試；或請聯繫客服人員。");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
//    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
//        // 從 request 中取得資料
//        List<ShopCartItem> cart = orderRequest.getCart();
//        OrderInfo orderInfo = orderRequest.getOrderInfo();
//        CostInfo costInfo = orderRequest.getCostInfo();
//
//        //驗證前端金額是否正確（目前均先假設無折扣及無運送費）
//        int subTotal = 0;
//        for (int i = 0; i < cart.size(); i++) {
//            ShopCartItem shopCartItem = cart.get(i);
//            int itemCount = shopCartItem.getItemCount(); //取得購物車內第i筆的商品數量
//            //取得第i筆商品的Id，而後進到資料庫取得資料庫的單價
//            int itemId = shopCartItem.getItemId();
//            String sql = "SELECT item_price FROM item WHERE item_id= :itemId";
//            Map<String, Object> params = new HashMap<>();
//            params.put("itemId",itemId);
//            Integer itemPrice = namedParameterJdbcTemplate.queryForObject(sql,params,Integer.class); //只要查單一數據時，可以使用queryForObject方法，最後一個參數放要查詢資料的型別，可以省去創RowMapper的手續
//            //計算小計金額
//            subTotal += (itemPrice * itemCount);
//        }
//        if(subTotal == costInfo.getSubTotal()){
//
//            System.out.println("true");
//            cartInsertOrderMain(cart.get(0), orderInfo, costInfo);
//            cartInserOrderDetails(cart);
//            return ResponseEntity.ok("成功建立訂單！");
////            System.out.println("order_id:"+getOrder_id());
//
//        }else {
//            System.out.println(false);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("訂單無法成立，請稍後再試；或請聯繫客服人員。");
//            System.out.println(subTotal);
//            System.out.println(costInfo.getSubTotal());
//        }


        // 模擬處理邏輯 (如存入資料庫)
//        System.out.println(session.getAttribute("custUser")); //上面先注入Session，從Session得知是是哪個用戶送單的
//        System.out.println("Shopcart: " + cart);
//        System.out.println("Order Info: " + orderInfo); //訂購人的信息不一定等於用戶註冊的訊息，用戶在送單時可能會修改地址、電話等。
//        System.out.println("Cost Info: " + costInfo);

        // 回傳成功訊息
//        return ResponseEntity.ok("Order received successfully!");
//    }

    //購物車寫進資料庫訂單主表
//    void cartInsertOrderMain(ShopCartItem shopCartItem, OrderInfo orderInfo, CostInfo costInfo){
//        //寫進order_main
//        Map<String, Object> map = new HashMap<>();
//        //獲取本次連線會員的id
//        CustUsers custUser=(CustUsers)session.getAttribute("custUser");
//        map.put("custuser_id",custUser.getCustuser_id());
//        //用map裝各個要插入的數值
//        map.put("shop_id",shopCartItem.getShopId());
//        map.put("subtotal", costInfo.getSubTotal());
//        map.put("discount", costInfo.getDiscount());
//        map.put("delivery_fee", costInfo.getDeliveryFee());
//        map.put("total_amount", costInfo.getTotalAmount());
//        map.put("order_name", orderInfo.getOrderName());
//        map.put("order_phone", orderInfo.getOrderPhone());
//        map.put("order_address", orderInfo.getOrderAddress());
//        map.put("discount_code", orderInfo.getDiscountCode());
//        String sql = "INSERT INTO orders_main(custuser_id, shop_id, subtotal, discount, delivery_fee, total_amount, order_name, order_phone, order_address, discount_code) VALUES (:custuser_id, :shop_id, :subtotal, :discount, :delivery_fee, :total_amount, :order_name, :order_phone, :order_address, :discount_code)";
//        namedParameterJdbcTemplate.update(sql,map);
//    }
//
//    //獲取order_id
//    int getOrder_id(){
//        String sql = "SELECT LAST_INSERT_ID() AS order_id";
//        Integer order_id = namedParameterJdbcTemplate.queryForObject(sql,new HashMap<>(),Integer.class);
//        return order_id;
//    }

    //購物車寫進資料庫訂單詳細表
//    void cartInserOrderDetails(List<ShopCartItem> cart){
//
//        String sql = "INSERT INTO order_details(order_id,item_id,item_name,item_pic_url,item_price,sugur_level,ice_level,order_count,item_subtotal) VALUES (:order_id, :item_id, :item_name,:item_pic_url, :item_price, :sugur_level, :ice_level, :order_count, :item_subtotal)";
//
//        //獲取order_id
//        int order_id = getOrder_id();
//
//        //獲取要插入的欄位，並寫入資料庫
//        for (int i = 0; i < cart.size(); i++) {
//            Map<String, Object> map = new HashMap<>();
//            ShopCartItem shopCartItem = cart.get(i);
//            map.put("order_id",order_id); //記得order_id也要寫進資料庫
//            map.put("item_id",shopCartItem.getItemId());
//            map.put("item_name",shopCartItem.getItemName());
//            map.put("item_pic_url",shopCartItem.getItemPicUrl());
//            map.put("item_price",(shopCartItem.getSubtal()/shopCartItem.getItemCount()));
//            map.put("sugur_level",shopCartItem.getSugarLevel());
//            map.put("ice_level",shopCartItem.getIceLevel());
//            map.put("order_count",shopCartItem.getItemCount());
//            map.put("item_subtotal",shopCartItem.getSubtal());
//            namedParameterJdbcTemplate.update(sql,map);
//        }
//    }

}
