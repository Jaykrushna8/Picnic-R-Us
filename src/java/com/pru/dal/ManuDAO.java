/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.dal;

import com.pru.model.ManuModel;
import com.pru.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pushpraj
 */
public class ManuDAO {
    private final Connection connection;
    
    public ManuDAO() 
    {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addMenu(ManuModel ingredient) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `manu`(`Name`,"
                            + " `Description`, `PerHeadCost`)"
                            + " VALUES (?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setString(2, ingredient.getDescription());
            preparedStatement.setInt(3, ingredient.getPerHeadCost());
            preparedStatement.executeUpdate();
            } catch (SQLException e) {
        }
    }
    
    public void updateMenu(ManuModel menu){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `manu` SET "
                            + " `Name`=?,`Description`=?, `PerHeadCost`=? WHERE Id=?");
            // Parameters start with 1
            preparedStatement.setString(1, menu.getName());
            preparedStatement.setString(2, menu.getDescription());
            preparedStatement.setInt(3, menu.getPerHeadCost());
            preparedStatement.setInt(4,menu.getId());
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex)
        {
        }
    }
    
     public void deleteManu(int Id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `manu` WHERE Id=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }
     public List<ManuModel> getAllMenu() {
        List<ManuModel> menus = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `manu` WHERE 1");
            while (rs.next()) {
                ManuModel menu = new ManuModel();
                menu.setId(rs.getInt("Id"));
                menu.setName(rs.getString("Name"));
                menu.setDescription(rs.getString("Description"));
                menu.setPerHeadCost(rs.getInt("PerHeadCost"));
                menus.add(menu);
            }
        } catch (SQLException e) {
        }
        return menus;
     }
     
     public ManuModel getMenuById(int id){
         ManuModel menu = new ManuModel();
              try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `manu` WHERE Id="+id);
            while (rs.next()) {
                
                menu.setId(rs.getInt("Id"));
                menu.setName(rs.getString("Name"));
                menu.setDescription(rs.getString("Description"));
                menu.setPerHeadCost(rs.getInt("PerHeadCost"));
               
                }
        } catch (SQLException e) {
        }
        return menu;
     }
     
     public int getMaxId() {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(Id) as Id from manu");
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
