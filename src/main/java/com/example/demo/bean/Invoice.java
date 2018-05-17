package com.example.demo.bean;

import java.util.Date;

// 发票
public class Invoice {
  private String computerId;
  private Date buyDate;
  private boolean isUseful;

  public Invoice(String computerId, Date buyDate, boolean isUseful) {
    this.computerId = computerId;
    this.buyDate = buyDate;
    this.isUseful = isUseful;
  }

  public String getComputerId() {
    return computerId;
  }

  public void setComputerId(String computerId) {
    this.computerId = computerId;
  }

  public Date getBuyDate() {
    return buyDate;
  }

  public void setBuyDate(Date buyDate) {
    this.buyDate = buyDate;
  }

  public boolean isUseful() {
    return isUseful;
  }

  public void setUseful(boolean useful) {
    isUseful = useful;
  }
}
