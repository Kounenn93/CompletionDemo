package com.tiamtshai.fulldemo.service;

import com.tiamtshai.fulldemo.dao.UserLoginDao;
import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.model.LoginUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLoginService {
    @Autowired
    private UserLoginDao userLoginDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Map<String, Object> login(LoginUser loginUser, HttpSession session) {
        // 定義要返回的 Map 物件
        Map<String, Object> response = new HashMap<>();

        // 調用 DAO 層取得用戶資料
        List<CustUsers> custUsers = userLoginDao.findByUserName(loginUser.getUserName());

        if (!custUsers.isEmpty()) {
            CustUsers user = custUsers.get(0);
            String plainPassword = loginUser.getUserPassword();
            String hashedPassword = user.getCustuser_password();

            // 驗證密碼
            boolean isMatch = passwordEncoder.matches(plainPassword, hashedPassword);
            if (isMatch) {
                session.setAttribute("custUser", user);
                response.put("status", "success");
                response.put("message", "登入成功");
            } else {
                response.put("status", "error");
                response.put("message", "密碼錯誤");
            }
        } else {
            response.put("status", "error");
            response.put("message", "查無用戶資料，請先註冊！");
        }

        return response;
    }
}
