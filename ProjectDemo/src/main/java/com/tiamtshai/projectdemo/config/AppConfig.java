package com.tiamtshai.projectdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

/*
@Configuration 是專門用來標註配置類的，其內部所有的 @Bean 方法會被 Spring 容器進行代理和管理，確保同一個 Bean 實例只會被創建一次（單例）。
雖然 @Component 加 @Bean 也能達到目的，但它並不是標準做法，會降低代碼的可讀性。
 */
