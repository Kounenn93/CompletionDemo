package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.CustUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UsersController {

    //設定ip位置直接跳轉首頁，並URL不顯示出index.html
    @RequestMapping("/")
    public ModelAndView toIndex() {
        return new ModelAndView("/index.html");
    }

    //前台消費者會員註冊邏輯
    // 注入JDBC寫入工具
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //注入加密工具
    @Autowired
    private PasswordEncoder passwordEncoder;

    //限定註冊只能以post方法（因為有密碼）
    @PostMapping("/signup_request")
    public String register(@ModelAttribute CustUsers custUsers) {

        String hsPWd = passwordEncoder.encode(custUsers.getCustuser_password());
        // 密碼加密

        // SQL 語句
        String sql = "INSERT INTO customer_users(custuser_name, custuser_email, custuser_phone, custuser_password, custuser_city, custuser_dist, custuser_address) VALUES (:custuserName, :custuserEmail, :custuserPhone, :custuserPassword, :custuserCity, :custuserDist, :custuserAddress)";
        Map<String, Object> map = new HashMap<>();
        map.put("custuserName", custUsers.getCustuser_name());
        map.put("custuserEmail", custUsers.getCustuser_email());
        map.put("custuserPhone", custUsers.getCustuser_phone());
        map.put("custuserPassword", hsPWd);
        map.put("custuserCity", custUsers.getCustuser_city());
        map.put("custuserDist", custUsers.getCustuser_dist());
        map.put("custuserAddress", custUsers.getCustuser_address());

        // 插入資料庫
        try {
            namedParameterJdbcTemplate.update(sql, map);
            return "<h1>註冊成功！！</h1>";
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            // 檢查例外訊息以確定是哪個欄位衝突
            String errorMessage = e.getMessage();
            if (errorMessage.contains("for key 'customer_users.custuser_email'")) {
                return "<h1 style='color: red;'>註冊失敗：此信箱已被註冊。</h1>";
            } else if (errorMessage.contains("for key 'customer_users.custuser_phone'")) {
                return "<h1 style='color: red;'>註冊失敗：此電話號碼已被註冊。</h1>";
            } else {
                return "<h1 style='color: red;'>註冊失敗：發生未知錯誤，請稍後再試或請洽客服人員。</h1>";
            }
        } catch (Exception e) {
            // 捕捉其他非預期錯誤
            return "<h1 style='color: red;'>註冊失敗：系統錯誤，請稍後再試或請洽客服人員。</h1>";
        }
    }
}
