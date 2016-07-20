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

import java.util.ArrayList;
import java.util.List;

import com.pru.model.UnitOfMeasureModel;
import com.pru.util.DatabaseConnection;
/**
 *
 * @author Dpm
 */
public class UnitOfMeasureDAO {
    private final Connection connection;
    
    public UnitOfMeasureDAO() 
    {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addUnitOfMeasure(UnitOfMeasureModel UnitOfMeasure) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `unitofmeasure`(`Name`,"
                            + " `Description`, `Icon`)"
                            + " VALUES (?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, UnitOfMeasure.getName());
            preparedStatement.setString(2, UnitOfMeasure.getDescription());
            preparedStatement.setString(3, UnitOfMeasure.getIcon());
            
            preparedStatement.executeUpdate();
           } catch (SQLException e) {
        }
    }
    
    public void updateUnitOfMeasure(UnitOfMeasureModel UnitOfMeasure)
    {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `unitofmeasure` SET "
                            + " `Name`=?,`Description`=?, `Icon`=? WHERE Id=?");
            // Parameters start with 1
            preparedStatement.setString(1, UnitOfMeasure.getName());
            preparedStatement.setString(2, UnitOfMeasure.getDescription());
            preparedStatement.setString(3, UnitOfMeasure.getIcon());
            preparedStatement.setInt(4, UnitOfMeasure.getId());
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex)
        {
        }
    }
    
     public void deleteUnitOfMeasure(int Id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `unitofmeasure` WHERE Id=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }
     public List<UnitOfMeasureModel> getAllUnitOfMeasure() {
        List<UnitOfMeasureModel> UnitOfMeasures = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `unitofmeasure` WHERE 1");
            while (rs.next()) {
                UnitOfMeasureModel UnitOfMeasure = new UnitOfMeasureModel();
                UnitOfMeasure.setId(rs.getInt("Id"));
                UnitOfMeasure.setName(rs.getString("Name"));
                UnitOfMeasure.setDescription(rs.getString("Description"));
                UnitOfMeasure.setIcon(rs.getString("Icon"));
                UnitOfMeasures.add(UnitOfMeasure);
            }
        } catch (SQLException e) {
        }
        return UnitOfMeasures;
     }
     
     public UnitOfMeasureModel getUnitOfMeasureById(int id)
     {
         UnitOfMeasureModel UnitOfMeasure = new UnitOfMeasureModel();
              try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `unitofmeasure` WHERE Id="+id);
            while (rs.next()) {
                
                UnitOfMeasure.setId(rs.getInt("Id"));
                UnitOfMeasure.setName(rs.getString("Name"));
                UnitOfMeasure.setDescription(rs.getString("Description"));
                UnitOfMeasure.setIcon(rs.getString("Icon"));
                }
        } catch (SQLException e) {
        }
        return UnitOfMeasure;
     }
     
     public int getMaxId()
     {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(Id) as Id from unitofmeasure");
            while (rs.next()) 
            {
                if(rs.getString("Id")!=null)
                { 
                    id=rs.getInt("Id");
                }
            }
         }catch(SQLException e){}
       return id;
     }
}
