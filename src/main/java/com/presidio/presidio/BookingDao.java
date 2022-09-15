package com.presidio.presidio;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional


public class BookingDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityManager em;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Booking> list() {
        Session session = sessionFactory.openSession();
        List<Booking> bookings=new ArrayList<Booking>();
        try
        {
            String sql_query="from booking";
            bookings = session.createQuery(sql_query).list();
            return bookings;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void save(Booking booking) {
        Session session = sessionFactory.openSession();
        if(booking != null)
        {
            Transaction t = session.beginTransaction();
            session.save(booking);
            t.commit();
            session.close();
        }
        else{
            System.out.println("Error");
            return;
        }

    }




}
