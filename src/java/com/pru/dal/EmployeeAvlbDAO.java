/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.dal;

import com.pru.model.EmployeeAvlbModel;
import com.pru.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


/**
 *
 * @author Pushpraj
 */
public class EmployeeAvlbDAO {
    private Connection connection;

    public EmployeeAvlbDAO() {
        connection = DatabaseConnection.getConnection();
    }
  public void saveEmpAvblInfo(EmployeeAvlbModel emp)
    {
        try{
          PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `employeeavailability`(`EmployeeId`, `Month`, `DateFrom`, `DateTo`, `OtherComment`, `PostedOn`)"
                            + " VALUES (?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, emp.getEmployeeId());
            preparedStatement.setString(2, emp.getMonth());
            preparedStatement.setDate(3, new java.sql.Date(emp.getDateFrom().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(emp.getDateTo().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(emp.getPostedOn().getTime()));
            preparedStatement.setString(5,emp.getOtherComment());
            preparedStatement.executeUpdate();
           
      }catch(SQLException ex)
      {
      
      }
    }
  
  public List<EmployeeAvlbModel> GetAvailableEmp()
    {
        List<EmployeeAvlbModel> employees=new ArrayList<EmployeeAvlbModel>();
        try{
                      Statement statement = connection.createStatement();
                      String proc = "{call my_proc()}";
                      CallableStatement cs = connection.prepareCall(proc);
                      boolean cc= cs.execute();
                      ResultSet reee = cs.getResultSet();
            ResultSet rs = cs.executeQuery("select * from tbl");
            while (rs.next()) {
                EmployeeAvlbModel employee = new EmployeeAvlbModel();
                employee.setNumAvail(rs.getInt("NumofEmpAvail"));
                employee.setDateAvail(rs.getDate("DateAvail"));
                employees.add(employee);
               }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
