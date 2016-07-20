/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;


public class LoginModel {
    private int id;
    private String userName;
    private String password;
    private String employeeId;
    private int LoginType;
    private boolean isActive;
    
    public int getId()
    {
     return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    
    public int getLoginType()
    {
     return LoginType;
    }
    public void setLoginType(int LoginType)
    {
        this.LoginType=LoginType;
    }
    public String getUserName()
    {
     return userName;
    }
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public String getPassword()
    {
     return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getEmployeeId()
    {
     return employeeId;
    }
    public void setEmployeeId(String employeeId)
    {
        this.employeeId=employeeId;
    }
    public boolean getEmployeeStatus()
    {
        return isActive;
    }
    public void setEmployeeStatus(boolean isActive)
    {
     this.isActive=isActive;
    }
}
