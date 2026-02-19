package com.kce.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.kce.entity.PlotTaskRow;
import com.kce.util.HibernateUtil;

public class PlotTaskDAO {

    public boolean insertPlotTaskRow(PlotTaskRow row) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(row); 
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<PlotTaskRow> findAllocationsByGardener(String gardenerID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM PlotTaskRow p WHERE p.gardener.gardenerID = :gardenerID AND p.serviceType = 'PLOT_ALLOCATION'",
                    PlotTaskRow.class)
                    .setParameter("gardenerID", gardenerID)
                    .list();
        }
    }

    public List<PlotTaskRow> findTasksByPlot(String plotNo, String seasonName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM PlotTaskRow p WHERE p.plotNo = :plotNo AND p.seasonName = :seasonName AND p.serviceType = 'MAINTENANCE_TASK'",
                    PlotTaskRow.class)
                    .setParameter("plotNo", plotNo)
                    .setParameter("seasonName", seasonName)
                    .list();
        }
    }

    
    public PlotTaskRow findOverlappingAllocation(String plotNo, java.sql.Date startDate, java.sql.Date endDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<PlotTaskRow> query = session.createQuery(
                "FROM PlotTaskRow p " +
                "WHERE p.plotNo = :plotNo " +
                "AND p.serviceType = 'PLOT_ALLOCATION' " +
                "AND p.allocationStartDate IS NOT NULL " +
                "AND p.allocationEndDate IS NOT NULL " +
                "AND ( " +
                "    (:startDate BETWEEN p.allocationStartDate AND p.allocationEndDate) " +
                "    OR (:endDate BETWEEN p.allocationStartDate AND p.allocationEndDate) " +
                "    OR (p.allocationStartDate BETWEEN :startDate AND :endDate) " +
                ")",
                PlotTaskRow.class
            );
            query.setParameter("plotNo", plotNo);
            query.setParameter("startDate", new java.util.Date(startDate.getTime()));
            query.setParameter("endDate", new java.util.Date(endDate.getTime()));
            return query.uniqueResult();
        }
    }
   
    public List<PlotTaskRow> findActiveAllocationsForGardener(String gardenerID, Date referenceDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM PlotTaskRow p WHERE p.gardener.gardenerID = :gardenerID AND p.serviceType = 'PLOT_ALLOCATION' " +
                            "AND p.allocationEndDate >= :refDate",
                    PlotTaskRow.class)
                    .setParameter("gardenerID", gardenerID)
                    .setParameter("refDate", referenceDate)
                    .list();
        }
    }

 
    public List<PlotTaskRow> findPendingTasksForGardener(String gardenerID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM PlotTaskRow p WHERE p.gardener.gardenerID = :gardenerID " +
                            "AND p.serviceType = 'MAINTENANCE_TASK' AND p.taskStatus = 'PENDING'",
                    PlotTaskRow.class)
                    .setParameter("gardenerID", gardenerID)
                    .list();
        }
    }

   
    public PlotTaskRow findRowByID(Long rowID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PlotTaskRow.class, rowID);
        }
    }

    public boolean updateTaskStatusAndNotes(Long rowID, String taskStatus, String taskNotes) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            PlotTaskRow row = session.get(PlotTaskRow.class, rowID);
            if (row == null) return false;
            tx = session.beginTransaction();
            row.setTaskStatus(taskStatus);
            row.setTaskNotes(taskNotes);
            session.merge(row);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
