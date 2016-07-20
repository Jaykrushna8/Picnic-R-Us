/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pru.dal;

import com.pru.model.LoginModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pru.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Pushpraj
 */
public class LoginDAO {

    private final Connection connection;

    public LoginDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public int doLogin(String username, String password) {
        try {
            LoginModel user = new LoginModel();
            PreparedStatement pre = connection.prepareStatement("select * from login where userName=?");
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setEmployeeId(rs.getString("employeeId"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setEmployeeStatus(rs.getBoolean("isActive"));
                    user.setLoginType(rs.getInt("LoginType"));
                }
                if (!user.getEmployeeStatus()) {
                    return 2; // user blocked
                }
                if (password.equals(user.getPassword())) {
                    return 5; //login successfull
                } else {
                    return 3; // invalid password
                }
            } else {
                return 1;  //invalid username
            }
        } catch (SQLException ex) {
            return 4; // undefined error
        }

    }
   public void saveLoginInfo(LoginModel user)
    {
        try{
          PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `login`(`UserName`, `Password`,LoginType, `EmployeeId`, `IsActive`)"
                            + " VALUES (?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(4, user.getEmployeeId());
            preparedStatement.setBoolean(5, true);
            preparedStatement.setInt(3,user.getLoginType());
            preparedStatement.executeUpdate();
           
      }catch(SQLException ex)
      {
      
      }
    }
    
    public int getLoginType(String username)
    {
        try{
            LoginModel user = new LoginModel();
            PreparedStatement pre = connection.prepareStatement("select * from login where userName=?");
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setEmployeeId(rs.getString("employeeId"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setEmployeeStatus(rs.getBoolean("isActive"));
                    user.setLoginType(rs.getInt("LoginType"));
                }
                return user.getLoginType();
            }
            else
            {
                return 4;
            }
        }catch(SQLException ex)
        {
            return 4;
        }
     
    }
     public String getEmployeeId(String username)
    {
        try{
            LoginModel user = new LoginModel();
            PreparedStatement pre = connection.prepareStatement("select * from login where userName=?");
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setEmployeeId(rs.getString("employeeId"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setEmployeeStatus(rs.getBoolean("isActive"));
                    user.setLoginType(rs.getInt("LoginType"));
                }
                return user.getEmployeeId();
            }
            else
            {
                return "pru001";
            }
        }catch(SQLException ex)
        {
            return "pru001";
        }
     
    }
}
