/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.pru.model.CustomerModel;
import com.pru.model.LoginModel;
import com.pru.util.DatabaseConnection;

public class CustomerDAO {
    private final Connection connection;

    public CustomerDAO() 
    {
        connection = DatabaseConnection.getConnection();
    }

    public void addCustomer(CustomerModel cust) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `customer`(`CustomerId`, `FirstName`, `MiddleName`, "
                            + "`LastName`, `AddressLine1`, `AddressLine2`, `AddressLine3`, `AddressLine4`, "
                            + "`EmailId`, `MobileNumber`) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, cust.getCutomerId());
            preparedStatement.setString(2, cust.getFirstName());
            preparedStatement.setString(3, cust.getMiddleName());
            preparedStatement.setString(4, cust.getLastName());
            preparedStatement.setString(5, cust.getAddressLine1());
            preparedStatement.setString(6, cust.getAddressLine2());
            preparedStatement.setString(7, cust.getAddressLine3());
            preparedStatement.setString(8, cust.getAddressLine4());
            preparedStatement.setString(10, cust.getMobileNumber());
            preparedStatement.setString(9, cust.getEmailId());
            preparedStatement.executeUpdate();
            LoginDAO daop=new LoginDAO();
            LoginModel loginModel=new LoginModel();
            loginModel.setId(0);
            loginModel.setEmployeeId(cust.getCutomerId());
            loginModel.setUserName(cust.getEmailId());
            loginModel.setPassword(cust.getPassword());
            loginModel.setLoginType(3);
            daop.saveLoginInfo(loginModel);
           } catch (SQLException e) {
        }
    }
    
    public void updateCustomer(CustomerModel cust)
   {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `customer` SET "
                            + " `FirstName`=?,`EmailId`=?, `MiddleName`=?, `LastName`=?, `AddressLine1`=?,"
                            + " `AddressLine2`=?, `AddressLine3`=?, `AddressLine4`=?, `MobileNumber`=? WHERE Id=?");
            // Parameters start with 1
            preparedStatement.setString(1, cust.getFirstName());
            preparedStatement.setString(3, cust.getMiddleName());
            preparedStatement.setString(4, cust.getLastName());
            preparedStatement.setString(5, cust.getAddressLine1());
            preparedStatement.setString(6, cust.getAddressLine2());
            preparedStatement.setString(7, cust.getAddressLine3());
            preparedStatement.setString(8, cust.getAddressLine4());
            preparedStatement.setString(9, cust.getMobileNumber());
            preparedStatement.setString(2, cust.getEmailId());
            preparedStatement.setInt(10, cust.getId());
            preparedStatement.executeUpdate();
            
           } catch (SQLException e) {
        }
 
    }
    
    public CustomerModel getCustomerById(String id)
     {
         CustomerModel cust = new CustomerModel();
              try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `customer` WHERE CustomerId='"+id+"'");
            while (rs.next()) {
                
                cust.setId(rs.getInt("Id"));
                cust.setCustomerId(rs.getString("CustomerId"));
                cust.setFirstName(rs.getString("FirstName"));
                cust.setMiddleName(rs.getString("MiddleName"));
                cust.setLastName(rs.getString("LastName"));
                cust.setAddressLine1(rs.getString("AddressLine1"));
                cust.setAddressLine2(rs.getString("AddressLine2"));
                cust.setAddressLine3(rs.getString("AddressLine3"));
                cust.setAddressLine4(rs.getString("AddressLine4"));
                cust.setEmailId(rs.getString("EmailId"));
                cust.setMobileNumber(rs.getString("MobileNumber"));
                
               }
        } catch (SQLException e) {
        }
        return cust;
     }
     
     public int getMaxId()
     {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(id) as id from customer");
            while (rs.next()) 
            {
                if(rs.getString("id")!=null)
                { 
                    id=rs.getInt("id");
                }
            }
         }catch(SQLException e){}
       return id;
     }
      public String getCustomerName(String CustomerId){
         String name=null;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer where CustomerId='"+CustomerId+"'");
            while (rs.next()) 
            {
                if(rs.getString("FirstName")!=null)
                {
                    name=rs.getString("FirstName")+" "+rs.getString("MiddleName")+" "+rs.getString("LastName");
                } 
                else 
                { 
                    name="demo Customer";
                }
            }
         }catch(SQLException e){}
       return name;
     }
}
