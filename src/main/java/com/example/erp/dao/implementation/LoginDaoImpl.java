package com.example.erp.dao.implementation;

import com.example.erp.bean.LoginDetails;
import com.example.erp.dao.LoginDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean credentialsVerify(LoginDetails logindetails) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("from LoginDetails where email=:email and password=:password");
            query.setParameter("email", logindetails.getEmail());
            query.setParameter("password", logindetails.getPassword());
            for (final Object fetch : query.list()) {
                return true;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        finally {
            session.close();
        }
        return false;
    }
}
