/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;

import java.util.Date;


public class OrderModel {
  
    private int orderId;
    private String customerId;
    private int numOfPerson;
    private Date picnicDate;
    private String picnicPlace;
    private int totalAmount;
    private boolean isApproved;
    private boolean isPayed;
    private String customerName;
    private String selmenu;
    
    public int getOrderId()
    {
        return orderId;
    }
    public void setOrderId(int orderId)
    {
      this.orderId=orderId;
    }
    public String getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(String customerId)
    {
      this.customerId=customerId;
    }
    public String getPicnicPlace()
    {
        return picnicPlace;
    }
    public void setPicnicPlace(String picnicPlace)
    {
      this.picnicPlace=picnicPlace;
    }
    public int getNumOfPerson()
    {
        return numOfPerson;
    }
    public void setNumOfPerson(int numOfOrder)
    {
      this.numOfPerson=numOfOrder;
    }
    public int getTotalAmount()
    {
        return totalAmount;
    }
    public void setTotalAmount(int totalAmount)
    {
      this.totalAmount=totalAmount;
    }
    public Date getPicnicDate()
    {
      return picnicDate;
    }
    public void setPicnicDate(Date picnicDate)
    {
      this.picnicDate=picnicDate;
    }
    public boolean getIsAproved()
    {
       return isApproved;
    }
    public void setIsApproved(boolean isApproved)
    {
        this.isApproved=isApproved;
    }
    public boolean getIsPayed()
    {
       return isPayed;
    }
    public void setIsPayed(boolean isPayed)
    {
        this.isPayed=isPayed;
    }
    public String getCustomerName()
    {
       return customerName;
    }
    public void setCustomerName(String customerName)
    {
      this.customerName=customerName;
    }
     public String getSelectedMenu()
    {
        return selmenu;
    }
    public void setSelectedMenu(String selmenu)
    {
      this.selmenu=selmenu;
    }
    
}
