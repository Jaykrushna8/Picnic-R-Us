/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.dal;


import com.pru.model.OrderModel;
import com.pru.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookOrderDAO {
    
    private final Connection connection;

    public BookOrderDAO() 
    {
        connection = DatabaseConnection.getConnection();
    }
    
public void InsertSelectedMenu(OrderModel om)
{
    try
    {
        int ttlcost =0 ;
    String[] sel = om.getSelectedMenu().split(",");
    for(int i=0;i<sel.length;i++)
    {
        String[] menudet = sel[i].split("_");
    PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `orderdetails`(`OrderId`, `MenuId`, `Cost`, `NumberofOrder`) VALUES (?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setInt(1, getMaxOrderId()+1);
            preparedStatement.setString(2, menudet[0]);
            preparedStatement.setInt(3, getCostTotal(menudet[0],menudet[1]));
            preparedStatement.setString(4, menudet[1]);
            preparedStatement.executeUpdate();
            ttlcost += getCostTotal(menudet[0],menudet[1]);
    }
    PreparedStatement preparedStatement2 = connection
                    .prepareStatement("INSERT INTO `mainorder`(`CustomerId`, `NumOfPerson`, `PicnicDate`, `PicnicPlace`, `TotalAmount`, `IsApproved`, `IsPayed`) VALUES (?,?,?,?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement2.setString(1, om.getCustomerId());
            preparedStatement2.setInt(2, om.getNumOfPerson());
            preparedStatement2.setDate(3, new java.sql.Date(om.getPicnicDate().getTime()));
            preparedStatement2.setString(4, om.getPicnicPlace());
            preparedStatement2.setInt(5, ttlcost);
            preparedStatement2.setBoolean(6, false);
            preparedStatement2.setBoolean(7, false);
            preparedStatement2.executeUpdate();
    }
    catch (SQLException e) {
    }
}

private int getMaxOrderId()
     {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT IFNull(max(`OrderId`),0) as `OrderId` FROM `mainorder`");
            while (rs.next()) 
            {
                    id=rs.getInt("OrderId");
            }
         }catch(SQLException e){}
       return id;
     }
   
private int getCostTotal(String menuid,String numofperson)
     {
         int id=0;
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT `PerHeadCost` FROM `manu` WHERE `Id`='"+menuid+"'");
            while (rs.next()) 
            {
                    id=(rs.getInt("PerHeadCost")*Integer.parseInt(numofperson));
            }
         }catch(SQLException | NumberFormatException e){}
       return id;
     }


public List<OrderModel> getAllOrders(String id) {
        List<OrderModel> odrs = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `mainorder` WHERE `CustomerId`='"+ id+"'");
            while (rs.next()) {
                OrderModel ordr = new OrderModel();
                ordr.setOrderId((rs.getInt("OrderId")));
                ordr.setNumOfPerson(rs.getInt("NumOfPerson"));
                ordr.setPicnicDate(rs.getDate("PicnicDate"));
                ordr.setPicnicPlace(rs.getString("PicnicPlace"));
                ordr.setTotalAmount(rs.getInt("TotalAmount"));
                odrs.add(ordr);
            }
        } catch (SQLException e) {
        }
        return odrs;
     }
}