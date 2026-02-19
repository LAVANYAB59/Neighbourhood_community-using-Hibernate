package com.kce.entity;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "PLOT_TASK_TBL")
public class PlotTaskRow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plot_task_seq")
    @SequenceGenerator(name = "plot_task_seq", sequenceName = "PLOT_TASK_SEQ", allocationSize = 1)
    @Column(name = "ROW_ID")
    private Long rowId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GARDENER_ID", nullable = false)
    private Gardener gardener;

    @Column(name = "SERVICE_TYPE")
    private String serviceType;

    @Column(name = "PLOT_NO")
    private String plotNo;

    @Column(name = "SEASON_NAME")
    private String seasonName;

    @Column(name = "ALLOCATION_START_DATE")
    private Date allocationStartDate;

    @Column(name = "ALLOCATION_END_DATE")
    private Date allocationEndDate;

    @Column(name = "TASK_DATE")
    private Date taskDate;

    @Column(name = "TASK_TYPE")
    private String taskType;

    @Column(name = "TASK_NOTES")
    private String taskNotes;

    @Column(name = "TASK_STATUS")
    private String taskStatus;

    // ------------------ Getters and Setters ------------------
    public Long getRowId() { return rowId; }
    public void setRowId(Long rowId) { this.rowId = rowId; }

    public Gardener getGardener() { return gardener; }
    public void setGardener(Gardener gardener) { this.gardener = gardener; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getPlotNo() { return plotNo; }
    public void setPlotNo(String plotNo) { this.plotNo = plotNo; }

    public String getSeasonName() { return seasonName; }
    public void setSeasonName(String seasonName) { this.seasonName = seasonName; }

    public Date getAllocationStartDate() { return allocationStartDate; }
    public void setAllocationStartDate(Date allocationStartDate) { this.allocationStartDate = allocationStartDate; }

    public Date getAllocationEndDate() { return allocationEndDate; }
    public void setAllocationEndDate(Date allocationEndDate) { this.allocationEndDate = allocationEndDate; }

    public Date getTaskDate() { return taskDate; }
    public void setTaskDate(Date taskDate) { this.taskDate = taskDate; }

    public String getTaskType() { return taskType; }
    public void setTaskType(String taskType) { this.taskType = taskType; }

    public String getTaskNotes() { return taskNotes; }
    public void setTaskNotes(String taskNotes) { this.taskNotes = taskNotes; }

    public String getTaskStatus() { return taskStatus; }
    public void setTaskStatus(String taskStatus) { this.taskStatus = taskStatus; }

    @Override
    public String toString() {
        return "\n----------------------------------\n" +
               "PlotTaskRow ID: " + rowId + "\n" +
               "Gardener ID: " + (gardener != null ? gardener.getGardenerID() : "N/A") + "\n" +
               "Services: " + serviceType + "\n" +
               "Plot No: " + plotNo + "\n" +
               "Season: " + seasonName + "\n" +
               "Start Date: " + allocationStartDate + "\n" +
               "End Date: " + allocationEndDate + "\n" +
               "Task Date: " + taskDate + "\n" +
               "Task Type: " + taskType + "\n" +
               "Task Notes: " + taskNotes + "\n" +
               "Task Status: " + taskStatus + "\n" +
               "----------------------------------";
    }
}