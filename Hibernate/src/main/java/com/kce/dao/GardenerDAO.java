package com.kce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kce.entity.Gardener;
import com.kce.util.HibernateUtil;

public class GardenerDAO {

   
    public Gardener findGardener(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Gardener.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

  
    public boolean insertGardener(Gardener g) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(g); 
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean deleteGardener(String id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Gardener g = session.get(Gardener.class, id);
            if (g == null) return false;

            tx = session.beginTransaction();
            session.remove(g); 
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
