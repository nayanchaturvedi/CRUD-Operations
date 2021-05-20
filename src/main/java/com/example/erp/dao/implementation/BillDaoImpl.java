package com.example.erp.dao.implementation;

import com.example.erp.bean.Bill;
import com.example.erp.dao.BillDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class BillDaoImpl implements BillDao {

    @Override
    public boolean create(Bill bill) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Integer id = (Integer) session.save(bill);
            System.out.println("Bill created with id:" + id);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }

    @Override
    public boolean update(Bill bill) {
        return true;
    }

    @Override
    public Bill read(Bill bill) {

       try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("select description,amount,date,status from Bill where bill_id=:bill_id");
            query.setParameter("bill_id", bill.getBill_id());

            for (final Object fetch : query.list()) {
                return (Bill) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public void delete(Bill bill) {
    }
}
