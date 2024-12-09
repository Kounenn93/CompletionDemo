//package com.tiamtshai.fulldemo.dao;
//
//import com.tiamtshai.fulldemo.model.CustUsers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class UserLoginDao {
//
//    // 注入JDBC工具
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public void readtUser(CustUsers custUsers){
//        // SQL 語句
//        String sql = "SELECT custuser_name, custuser_email, custuser_phone, custuser_password, custuser_city, custuser_dist, custuser_address FROM customer_users WHERE custuser_email = "";
//        Map<String, Object> map = new HashMap<>();
//        map.put("custuserName", custUsers.getCustuser_name());
//        map.put("custuserEmail", custUsers.getCustuser_email());
//        map.put("custuserPhone", custUsers.getCustuser_phone());
//        map.put("custuserPassword", custUsers.getCustuser_password());
//        map.put("custuserCity", custUsers.getCustuser_city());
//        map.put("custuserDist", custUsers.getCustuser_dist());
//        map.put("custuserAddress", custUsers.getCustuser_address());
//
//        namedParameterJdbcTemplate.update(sql, map);
//    }
//}
