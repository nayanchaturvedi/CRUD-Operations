package com.example.erp.dao;

import com.example.erp.bean.Bill;

public interface DomainDao {

    public boolean create(Bill bill);

    public boolean update(Bill bill);

    public Bill read(Bill bill);

    public void delete(Bill bill);
}
