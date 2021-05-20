package com.example.erp.dao;

import com.example.erp.bean.LoginDetails;
public interface LoginDao {
    boolean credentialsVerify(LoginDetails logindetails);
}
