package com.tiamtshai.fulldemo.rowmapper;

import com.tiamtshai.fulldemo.model.CustUsers;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUsersRowMapper implements RowMapper<CustUsers> {

    @Override
    public CustUsers mapRow(ResultSet resultSet, int i) throws SQLException {
        CustUsers custUsers = new CustUsers();

        custUsers.setCustuser_id(resultSet.getInt("custuser_id"));
        custUsers.setCustuser_name(resultSet.getString("custuser_name"));
        custUsers.setCustuser_email(resultSet.getString("custuser_email"));
        custUsers.setCustuser_phone(resultSet.getString("custuser_phone"));
        custUsers.setCustuser_password(resultSet.getString("custuser_password"));
        custUsers.setCustuser_city(resultSet.getString("custuser_city"));
        custUsers.setCustuser_dist(resultSet.getString("custuser_dist"));
        custUsers.setCustuser_address(resultSet.getString("custuser_address"));


        return custUsers;
    }
}
