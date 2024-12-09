package com.tiamtshai.fulldemo.service;

import com.tiamtshai.fulldemo.dao.UserSignupDao;
import com.tiamtshai.fulldemo.model.CustUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSignupService {

    //注入註冊Dao層
    @Autowired
    private UserSignupDao userSignupDao;

    //注入加密工具（必須要創建一個實現類，實現PasswordEncoder介面）
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(CustUsers custUsers) {
        // 密碼加密
        String hashedPassword = passwordEncoder.encode(custUsers.getCustuser_password());
        custUsers.setCustuser_password(hashedPassword);

        // 調用 DAO 層存儲數據
        userSignupDao.insertUser(custUsers);
    }
}
