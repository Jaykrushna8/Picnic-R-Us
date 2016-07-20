/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.model;


public class CustomerModel {
   private int id;
    private String customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String mobileMumber;
    private String emailId;
    private String password;
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
      this.id=id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
      this.firstName=firstName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
      this.password=password;
    }
    public String getMiddleName()
    {
        return middleName;
    }
    public void setMiddleName(String middleName)
    {
      this.middleName=middleName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
      this.lastName=lastName;
    }
    public String getAddressLine1()
    {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1)
    {
      this.addressLine1=addressLine1;
    }
    public String getAddressLine2()
    {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2)
    {
      this.addressLine2=addressLine2;
    }
    public String getAddressLine3()
    {
        return addressLine3;
    }
    public void setAddressLine3(String addressLine3)
    {
      this.addressLine3=addressLine3;
    }
    public String getAddressLine4()
    {
        return addressLine4;
    }
    public void setAddressLine4(String addressLine4)
    {
      this.addressLine4=addressLine4;
    }
    public String getMobileNumber()
    {
        return mobileMumber;
    }
    public void setMobileNumber(String mobileNumber)
    {
      this.mobileMumber=mobileNumber;
    }
    
    public String getCutomerId()
    {
        return customerId;
    }
    public void setCustomerId(String customerId)
    {
      this.customerId=customerId;
    }

    public String getEmailId()
    {
        return emailId;
    }
    public void setEmailId(String emailId)
    {
      this.emailId=emailId;
    }

}
