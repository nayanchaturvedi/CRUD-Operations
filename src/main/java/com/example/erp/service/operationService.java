package com.example.erp.service;

import com.example.erp.bean.Bill;
import com.example.erp.dao.BillDao;
import com.example.erp.dao.implementation.BillDaoImpl;

public class operationService {
    BillDao billDao = new BillDaoImpl();
    public boolean createBill(Bill bill){ return billDao.create(bill);}
    public boolean updateBill(Bill bill){ return billDao.update(bill);}
    public Bill readBill(Bill bill){ return billDao.read(bill);}

}
