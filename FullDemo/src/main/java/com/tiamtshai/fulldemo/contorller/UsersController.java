package com.tiamtshai.fulldemo.contorller;

import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.LoginUser;
import com.tiamtshai.fulldemo.rowmapper.CustomerUsersRowMapper;
import com.tiamtshai.fulldemo.service.UserLoginService;
import com.tiamtshai.fulldemo.service.UserSignupService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UsersController {

    //設定ip位置直接跳轉首頁，並URL不顯示出index.html
    @RequestMapping("/")
    public ModelAndView toIndex() {
        return new ModelAndView("/index.html");
    }


    //前台消費者會員註冊
    //注入會員註冊Service層
    @Autowired
    private UserSignupService userSignupService;

    //註冊：限定只能以post方法（因為有密碼）
    @PostMapping("/signup_request")
    public String register(@ModelAttribute CustUsers custUsers) {

        // 回傳訊息給前端
        try {
            userSignupService.registerUser(custUsers);
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


    // 注入JDBC工具
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //消費者Login邏輯區
    @Autowired
    private UserLoginService userLoginService;

    //登入：限定只能以post方法（因為有密碼）
    @PostMapping("/login_request")
    public Map<String, Object> login(@ModelAttribute LoginUser loginUser, HttpSession session){
        // 調用 Service 層處理邏輯
        Map<String, Object> response = userLoginService.login(loginUser, session);
        return response;
    }

    //確認session狀態
    @GetMapping("/checkSession")
    public ResponseEntity<Map<String, Object>> checkSession(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Object custUser = session.getAttribute("custUser");
        if (custUser != null) {
            response.put("loggedIn", true);
            response.put("user", custUser); // 可返回必要的用戶資料
        } else {
            response.put("loggedIn", false);
        }
        return ResponseEntity.ok(response);
    }

}
