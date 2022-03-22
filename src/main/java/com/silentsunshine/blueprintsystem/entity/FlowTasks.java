package com.silentsunshine.blueprintsystem.entity;


public class FlowTasks {

  private long id;
  private String title;
  private String desc;
  private long blueprintId;
  private long formId;
  private long flowchartId;
  private long maintainPermission;
  private long statisticsPermission;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public long getBlueprintId() {
    return blueprintId;
  }

  public void setBlueprintId(long blueprintId) {
    this.blueprintId = blueprintId;
  }


  public long getFormId() {
    return formId;
  }

  public void setFormId(long formId) {
    this.formId = formId;
  }


  public long getFlowchartId() {
    return flowchartId;
  }

  public void setFlowchartId(long flowchartId) {
    this.flowchartId = flowchartId;
  }


  public long getMaintainPermission() {
    return maintainPermission;
  }

  public void setMaintainPermission(long maintainPermission) {
    this.maintainPermission = maintainPermission;
  }


  public long getStatisticsPermission() {
    return statisticsPermission;
  }

  public void setStatisticsPermission(long statisticsPermission) {
    this.statisticsPermission = statisticsPermission;
  }

}
