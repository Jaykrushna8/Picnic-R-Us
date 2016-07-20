/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.dal;

import com.pru.model.ManuItemModel;
import com.pru.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManuItemDAO {
     private final Connection connection;
    
    public ManuItemDAO()
    {
        connection = DatabaseConnection.getConnection();
    }
    public void addMenuItem(ManuItemModel ingredient) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `manuitem`(`Name`, `Description`, `MenuId`, `MenuItemType`,"
                            + " `PerHeadCost`)"
                            + " VALUES (?,?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setString(2, ingredient.getDescription());
            preparedStatement.setInt(5, ingredient.getPerHeadCost());
            preparedStatement.setInt(3, 0);
            preparedStatement.setString(4, ingredient.getMenuItemType());
            preparedStatement.executeUpdate();
             } catch (SQLException e) {
        }
    }
    
    public void updateSingleMenuItem(int menuid,int id)
    {
         try{
          PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `manuitem` SET "                  
                                         + " `MenuId`=? WHERE Id=?");
          
                                         preparedStatement.setInt(1, menuid);
                                         preparedStatement.setInt(2, id);
                                         preparedStatement.executeUpdate();
         }
         catch (SQLException e){
             
         }
    }
    
    public void updateMenuItem(ManuItemModel menu){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `manuitem` SET "
                            + " `Name`=?,`Description`=?,`MenuId`=?,`MenuItemType`=?,"
                            + "`PerHeadCost`=? WHERE Id=?");
            // Parameters start with 1
            preparedStatement.setString(1, menu.getName());
            preparedStatement.setString(2, menu.getDescription());
            preparedStatement.setInt(5, menu.getPerHeadCost());
            preparedStatement.setInt(3,menu.getMenuId());
            preparedStatement.setString(4,menu.getMenuItemType());
            preparedStatement.setInt(6,menu.getId());
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex)
        {
        }
    }
    
     public void deleteManuItem(int Id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `manuitem` WHERE Id=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }
     public List<ManuItemModel> getAllMenuItem() {
        List<ManuItemModel> menus = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `manuitem` WHERE 1");
            while (rs.next()) {
                ManuItemModel menu = new ManuItemModel();
                menu.setId(rs.getInt("Id"));
                menu.setName(rs.getString("Name"));
                menu.setDescription(rs.getString("Description"));
                menu.setMenuId(Integer.parseInt(rs.getString("MenuId")));
                menu.setMenuItemType(rs.getString("MenuItemType"));
                menu.setPerHeadCost(rs.getInt("PerHeadCost"));
                menus.add(menu);
            }
        } catch (SQLException e) {
        }
        return menus;
     }
     public List<ManuItemModel> getAllMenuItem(int id) {
        List<ManuItemModel> menus = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `manuitem` WHERE MenuId="+id);
            while (rs.next()) {
                ManuItemModel menu = new ManuItemModel();
                menu.setId(rs.getInt("Id"));
                menu.setName(rs.getString("Name"));
                menu.setDescription(rs.getString("Description"));
                menu.setMenuId(Integer.parseInt(rs.getString("MenuId")));
                menu.setMenuItemType(rs.getString("MenuItemType"));
                menu.setPerHeadCost(rs.getInt("PerHeadCost"));
                menus.add(menu);
            }
        } catch (SQLException e) {
        }
        return menus;
     }
     
     public ManuItemModel getMenuItemById(int id){
         ManuItemModel menu = new ManuItemModel();
              try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `manuitem` WHERE Id="+id);
            while (rs.next()) {
                
                menu.setId(rs.getInt("Id"));
                menu.setName(rs.getString("Name"));
                menu.setDescription(rs.getString("Description"));
                menu.setMenuId(Integer.parseInt(rs.getString("MenuId")));
                menu.setMenuItemType(rs.getString("MenuItemType"));
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
            ResultSet rs = statement.executeQuery("select max(Id) as Id from manuitem");
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
