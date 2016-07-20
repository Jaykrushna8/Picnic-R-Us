/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;
import java.util.Date;

/**
 *
 * @author Pushpraj
 */
public class EmployeeAvlbModel {
    
    private int id;
    private String employeeId;
    private String month;
    private Date dateFrom;
    private Date dateTo;
    private Date dateAvail;
    private int NumAvail;
    private Date postedOn;
    private String OtherComment;
    
    public int getId()
    {
     return id;
    }
    public void setId(int id)
    {
     this.id=id;
    }
    public String getEmployeeId()
    {
     return employeeId;
    }
    public void setEmployeeId(String employeeId)
    {
      this.employeeId=employeeId;
    }
    public String getMonth()
    {
     return month;
    }
    public void setMonth(String month)
    {
      this.month=month;
    }
    public String getOtherComment()
    {
     return OtherComment;
    }
    public void setOtherComment(String otherComment)
    {
      this.OtherComment=otherComment;
    }
    public Date getDateFrom()
    {
      return dateFrom;
    }
    public void setDateFrom(Date dateFrom)
    {
      this.dateFrom=dateFrom;
    }
    public Date getDateTo()
    {
      return dateTo;
    }
    public void setDateTo(Date dateTo)
    {
      this.dateTo=dateTo;
    }
    public Date getDateAvail()
    {
      return dateAvail;
    }
    public void setDateAvail(Date dateavail)
    {
      this.dateAvail=dateavail;
    }
    public int getNumAvail()
    {
     return NumAvail;
    }
    public void setNumAvail(int numavail)
    {
     this.NumAvail=numavail;
    }
    public Date getPostedOn()
    {
      return postedOn;
    }
    public void setPostedOn(Date postedOn)
    {
      this.postedOn=postedOn;
    }
    
 }
