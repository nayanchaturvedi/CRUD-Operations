package com.example.erp.service;

import com.example.erp.bean.Bill;
import com.example.erp.dao.DomainDao;
import com.example.erp.dao.implementation.DomainDaoImpl;

public class DomainService {

    DomainDaoImpl domainDao = new DomainDaoImpl();
    public boolean createBill(Bill bill){ return domainDao.create(bill);}
    public boolean updateBill(Bill bill){ return domainDao.update(bill);}
    public Bill readBill(Bill bill){ return domainDao.read(bill);}
}
