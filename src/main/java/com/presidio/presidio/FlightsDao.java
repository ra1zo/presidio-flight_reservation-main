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


public class FlightsDao {
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

    public List<flights> list() {
        Session session = sessionFactory.openSession();
        List<flights> users=new ArrayList<flights>();
        try
        {
            String sql_query="from flights";
            users = session.createQuery(sql_query).list();
            return users;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void save(flights flights) {
        Session session = sessionFactory.openSession();
        if(flights != null)
        {
            Transaction t = session.beginTransaction();
            session.save(flights);
            t.commit();
            session.close();
        }
        else{
            System.out.println("Error");
            return;
        }

    }




    public void delete(String flightID) {
        Session session = sessionFactory.openSession();
        try {
            Transaction t = session.beginTransaction();
            Query delete_query = session.createQuery("DELETE FROM flights WHERE flight_id = :id");
            delete_query.setParameter("id", flightID);
            delete_query.executeUpdate();
            t.commit();

        } catch (Exception e) {
            System.out.println("exception");
            return;
        }
    }
}
