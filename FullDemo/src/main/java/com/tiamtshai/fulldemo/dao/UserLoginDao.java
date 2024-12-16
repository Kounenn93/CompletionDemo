package com.tiamtshai.fulldemo.dao;

import com.tiamtshai.fulldemo.model.CustUsers;
import com.tiamtshai.fulldemo.rowmapper.CustomerUsersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserLoginDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<CustUsers> findByUserName(String userName) {
        String sql = "SELECT custuser_id, custuser_name, custuser_email, custuser_phone, custuser_password, " +
                "custuser_city, custuser_dist, custuser_address " +
                "FROM customer_users WHERE custuser_email = :userName OR custuser_phone = :userName";

        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);

        return namedParameterJdbcTemplate.query(sql, params, new CustomerUsersRowMapper());
    }
}
