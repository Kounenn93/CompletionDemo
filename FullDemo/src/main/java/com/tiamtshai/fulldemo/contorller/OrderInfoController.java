package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.OrderInfo;
import com.tiamtshai.fulldemo.rowmapper.OrderInfoRowMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderinfo")
public class OrderInfoController {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    HttpSession session;

    @GetMapping("/getOrderInfo")
    public ResponseEntity<List<OrderInfo>> getOrderInfo(){
        Map<String, Object> map = new HashMap<>();


        String sql = "SELECT  om.*, od.* FROM order_details od LEFT JOIN orders_main om ON od.order_id = om.order_id WHERE od.order_id = (SELECT order_id FROM orders_main WHERE custuser_id = :custuser_id ORDER BY order_id DESC LIMIT 1) ";

        CustUsers custUser = (CustUsers) session.getAttribute("custUser");
        map.put("custuser_id",custUser.getCustuser_id());

        List<OrderInfo> orderInfoList = namedParameterJdbcTemplate.query(sql,map,new OrderInfoRowMapper());


        return ResponseEntity.ok(orderInfoList);
    }
}
