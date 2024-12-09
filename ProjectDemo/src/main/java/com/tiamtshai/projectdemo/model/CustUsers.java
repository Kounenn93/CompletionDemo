package com.tiamtshai.projectdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustUsers {
    private String custuser_name;
    private String custuser_email;
    private String custuser_phone;
    private String custuser_password;
    private String custuser_city;
    private String custuser_dist;
    private String custuser_address;

    public String getCustuser_name() {
        return custuser_name;
    }

    public void setCustuser_name(String custuser_name) {
        this.custuser_name = custuser_name;
    }

    public String getCustuser_email() {
        return custuser_email;
    }

    public void setCustuser_email(String custuser_email) {
        this.custuser_email = custuser_email;
    }

    public String getCustuser_phone() {
        return custuser_phone;
    }

    public void setCustuser_phone(String custuser_phone) {
        this.custuser_phone = custuser_phone;
    }

    public String getCustuser_password() {
        return custuser_password;
    }

    public void setCustuser_password(String custuser_password) {
        this.custuser_password = custuser_password;
    }

    public String getCustuser_city() {
        return custuser_city;
    }

    public void setCustuser_city(String custuser_city) {
        this.custuser_city = custuser_city;
    }

    public String getCustuser_dist() {
        return custuser_dist;
    }

    public void setCustuser_dist(String custuser_dist) {
        this.custuser_dist = custuser_dist;
    }

    public String getCustuser_address() {
        return custuser_address;
    }

    public void setCustuser_address(String custuser_address) {
        this.custuser_address = custuser_address;
    }
}
