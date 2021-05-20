package com.example.erp.service;

import com.example.erp.bean.LoginDetails;
import com.example.erp.dao.LoginDao;
import com.example.erp.dao.implementation.LoginDaoImpl;

public class loginService {
    LoginDao loginDao = new LoginDaoImpl();

    public boolean verifyCredentials(LoginDetails logindetails) {
        return loginDao.credentialsVerify(logindetails);
    }
}
