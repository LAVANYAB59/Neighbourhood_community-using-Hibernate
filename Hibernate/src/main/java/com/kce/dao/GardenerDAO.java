package com.kce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kce.entity.Gardener;
import com.kce.util.HibernateUtil;

public class GardenerDAO {

    // Find Gardener by ID
    public Gardener findGardener(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Gardener.class, id); // simple get by primary key
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Insert Gardener
    public boolean insertGardener(Gardener g) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(g); // persist entity
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Delete Gardener
    public boolean deleteGardener(String id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Gardener g = session.get(Gardener.class, id);
            if (g == null) return false;

            tx = session.beginTransaction();
            session.remove(g); // delete entity
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}