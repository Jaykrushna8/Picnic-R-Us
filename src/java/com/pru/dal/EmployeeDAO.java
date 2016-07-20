/*
  This class contains data access logic for Employee table.This can be considered 
  EJB for Employee model.
 */

package com.pru.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.pru.model.EmployeeModel;
import com.pru.model.LoginModel;
import com.pru.util.DatabaseConnection;

public class EmployeeDAO {
   private final Connection connection;

    public EmployeeDAO() 
    {
        connection = DatabaseConnection.getConnection();
    }

    public void addEmployee(EmployeeModel employee) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `employee`(`EmployeeId`,"
                            + " `FirstName`, `MiddleName`, `LastName`, `AddressLine1`,"
                            + " `AddressLine2`, `AddressLine3`, `AddressLine4`, `MobileNumber`,"
                            + " `EmaildId`, `DOB`, `EmployeeType`, `Salary`, `CreationDate`,"
                            + " `IpAddress`)"
                            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getMiddleName());
            preparedStatement.setString(4, employee.getLastName());
            preparedStatement.setString(5, employee.getAddressLine1());
            preparedStatement.setString(6, employee.getAddressLine2());
            preparedStatement.setString(7, employee.getAddressLine3());
            preparedStatement.setString(8, employee.getAddressLine4());
            preparedStatement.setString(9, employee.getMobileNumber());
            preparedStatement.setString(10, employee.getEmailId());
            preparedStatement.setDate(14,new java.sql.Date(employee.getCreationDate().getTime()));
            preparedStatement.setString(12, employee.getEmployeeType());
            preparedStatement.setInt(13, employee.getSalary());
            preparedStatement.setDate(11,new java.sql.Date(employee.getDob().getTime()));
            preparedStatement.setString(15, employee.getIpAddress());
            preparedStatement.executeUpdate();
            LoginDAO daop=new LoginDAO();
            LoginModel loginModel=new LoginModel();
            loginModel.setId(0);
            loginModel.setEmployeeId(employee.getEmployeeId());
            loginModel.setUserName(employee.getEmailId());
            loginModel.setPassword(employee.getPassword());
            loginModel.setLoginType(2);
            daop.saveLoginInfo(loginModel);
           } catch (SQLException e) {
        }
    }
    
    
    public void updateEmployee(EmployeeModel employee)
    {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `employee` SET "
                            + " `FirstName`=?,`IpAddress`=?, `MiddleName`=?, `LastName`=?, `AddressLine1`=?,"
                            + " `AddressLine2`=?, `AddressLine3`=?, `AddressLine4`=?, `MobileNumber`=?,"
                            + " `EmaildId`=?, `DOB`=?, `EmployeeType`=?, `Salary`=?, "
                            + " `CreationDate`=? WHERE Id=?");
            // Parameters start with 1
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(3, employee.getMiddleName());
            preparedStatement.setString(4, employee.getLastName());
            preparedStatement.setString(5, employee.getAddressLine1());
            preparedStatement.setString(6, employee.getAddressLine2());
            preparedStatement.setString(7, employee.getAddressLine3());
            preparedStatement.setString(8, employee.getAddressLine4());
            preparedStatement.setString(9, employee.getMobileNumber());
            preparedStatement.setString(10, employee.getEmailId());
            preparedStatement.setDate(14,new java.sql.Date(employee.getCreationDate().getTime()));
            preparedStatement.setString(12, employee.getEmployeeType());
            preparedStatement.setInt(13, employee.getSalary());
            preparedStatement.setDate(11,new java.sql.Date(employee.getDob().getTime()));
            preparedStatement.setString(2, employee.getIpAddress());
            preparedStatement.setInt(15, employee.getId());
            preparedStatement.executeUpdate();
            
           } catch (SQLException e) {
        }
 
    }
    
     public void deleteEmployee(int employeeid) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `employee` WHERE Id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, employeeid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public List<EmployeeModel> getAllEmployee() {
        List<EmployeeModel> employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `employee` WHERE 1");
            while (rs.next()) {
                EmployeeModel employee = new EmployeeModel();
                employee.setId(rs.getInt("Id"));
                employee.setEmployeeId(rs.getString("EmployeeId"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setMiddleName(rs.getString("MiddleName"));
                employee.setLastName(rs.getString("LastName"));
                employee.setAddressLine1(rs.getString("AddressLine1"));
                employee.setAddressLine2(rs.getString("AddressLine2"));
                employee.setAddressLine3(rs.getString("AddressLine3"));
                employee.setAddressLine4(rs.getString("AddressLine4"));
                employee.setDob(rs.getDate("DOB"));
                employee.setEmailId(rs.getString("EmaildId"));
                employee.setMobileNumber(rs.getString("MobileNumber"));
                employee.setSalary(rs.getInt("Salary"));
                employee.setIpAddress(rs.getString("IpAddress"));
                employee.setCreationDate(rs.getDate("CreationDate"));
                employee.setEmployeeType(rs.getString("EmployeeType"));
                employees.add(employee);
            }
        } catch (SQLException e) {
        }
        return employees;
     }
     
     public EmployeeModel getEmployeeById(int id)
     {
         EmployeeModel employee = new EmployeeModel();
              try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `employee` WHERE Id="+id);
            while (rs.next()) {
                
                employee.setId(rs.getInt("Id"));
                employee.setEmployeeId(rs.getString("EmployeeId"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setMiddleName(rs.getString("MiddleName"));
                employee.setLastName(rs.getString("LastName"));
                employee.setAddressLine1(rs.getString("AddressLine1"));
                employee.setAddressLine2(rs.getString("AddressLine2"));
                employee.setAddressLine3(rs.getString("AddressLine3"));
                employee.setAddressLine4(rs.getString("AddressLine4"));
                employee.setDob(rs.getDate("DOB"));
                employee.setEmailId(rs.getString("EmaildId"));
                employee.setMobileNumber(rs.getString("MobileNumber"));
                employee.setSalary(rs.getInt("Salary"));
                employee.setIpAddress(rs.getString("IpAddress"));
                employee.setCreationDate(rs.getDate("CreationDate"));
                employee.setEmployeeType(rs.getString("EmployeeType"));
               }
        } catch (SQLException e) {
        }
        return employee;
     }
     
     public int getMaxId()
     {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(id) as id from employee");
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
 
}
