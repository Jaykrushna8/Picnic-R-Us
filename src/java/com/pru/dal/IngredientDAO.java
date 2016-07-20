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

import com.pru.model.IngredientModel;
import com.pru.util.DatabaseConnection;

public class IngredientDAO {
    private final Connection connection;
    
    public IngredientDAO() 
    {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addIngredient(IngredientModel Ingredient) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `ingredient`(`Name`,"
                            + " `Description`, `PerUnitPrice`, `UnitOfMeasureId`)"
                            + " VALUES (?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, Ingredient.getName());
            preparedStatement.setString(2, Ingredient.getDescription());
            preparedStatement.setInt(3, Ingredient.getPerUnitPrice());
            preparedStatement.setInt(4, Ingredient.getUnitOfMeasureId());
            preparedStatement.executeUpdate();
            
           } catch (SQLException e) {
        }
    }
    
    public void updateIngredient(IngredientModel ingredient)
    {
        
    }
    
     public void deleteIngredient(int Id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `ingredient` WHERE Id=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }
     public List<IngredientModel> getAllIngredient() {
        List<IngredientModel> Ingredients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `ingredient` WHERE 1");
            while (rs.next()) {
                IngredientModel ingredient = new IngredientModel();
                ingredient.setId(rs.getInt("Id"));
                ingredient.setName(rs.getString("Name"));
                ingredient.setDescription(rs.getString("Description"));
                ingredient.setPerUnitPrice(rs.getInt("PerUnitPrice"));
                ingredient.setUnitOfmeasureId(rs.getInt("UnitOfMeasureId"));
                Ingredients.add(ingredient);
            }
        } catch (SQLException e) {
        }
        return Ingredients;
     }
     
     public IngredientModel getIngredientById(int id)
     {
         IngredientModel ingredient = new IngredientModel();
              try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `ingredient` WHERE Id="+id);
            while (rs.next()) {
                
                ingredient.setId(rs.getInt("Id"));
                ingredient.setName(rs.getString("Name"));
                ingredient.setDescription(rs.getString("Description"));
                ingredient.setPerUnitPrice(rs.getInt("PerUnitPrice"));
                ingredient.setUnitOfmeasureId(rs.getInt("UnitOfMeasureId"));
                }
        } catch (SQLException e) {
        }
        return ingredient;
     }
     
     public int getMaxId()
     {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(Id) as Id from ingredient");
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
