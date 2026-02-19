package com.kce.service;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kce.entity.Gardener;
import com.kce.entity.PlotTaskRow;
import com.kce.util.HibernateUtil;

public class GardenService {

    public void registerGardener(Gardener gardener) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(gardener);

        tx.commit();
        session.close();
        System.out.println("GARDENER REGISTERED");
    }

    public Gardener getGardener(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Gardener g = session.get(Gardener.class, id);
        session.close();
        return g;
    }

    public List<Gardener> getAllGardeners() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Gardener> list = session.createQuery("from Gardener", Gardener.class).list();
        session.close();
        return list;
    }

    public void updateGardener(Gardener gardener) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(gardener);

        tx.commit();
        session.close();
        System.out.println("GARDENER UPDATED");
    }

    public void deleteGardener(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Gardener g = session.get(Gardener.class, id);
        if (g != null) {
            session.remove(g);
            System.out.println("GARDENER DELETED");
        } else {
            System.out.println("Gardener Not Found");
        }

        tx.commit();
        session.close();
    }

        public void allocatePlot(Gardener gardener, String plotNo, String season,String start, String end) {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            PlotTaskRow task = new PlotTaskRow();

            task.setGardener(gardener);
            task.setPlotNo(plotNo);
            task.setSeasonName(season);
            task.setAllocationStartDate(Date.valueOf(start));
            task.setAllocationEndDate(Date.valueOf(end));

            session.persist(task);

            tx.commit();
            session.close();

            System.out.println("Plot Allocated Successfully!");
            
            
        }
    }
