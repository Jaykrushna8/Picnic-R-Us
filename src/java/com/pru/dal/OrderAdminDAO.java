/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.dal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.pru.model.OrderModel;
import com.pru.util.DatabaseConnection;
import java.sql.PreparedStatement;

public class OrderAdminDAO {
    private final Connection connection;
    private final CustomerDAO dao;
    
    public OrderAdminDAO() 
    {
        connection = DatabaseConnection.getConnection();
        dao=new CustomerDAO();
    }
    public List<OrderModel> getAllOrders(boolean isApproved) {
        List<OrderModel> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `mainorder` WHERE isApproved="+isApproved+"  AND isPayed=false");
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderId(rs.getInt("OrderId"));
                order.setCustomerId(rs.getString("CustomerId"));
                order.setNumOfPerson(rs.getInt("NumOfPerson"));
                order.setPicnicPlace(rs.getString("PicnicPlace"));
                order.setPicnicDate(rs.getDate("PicnicDate"));
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setCustomerName(dao.getCustomerName(order.getCustomerId()));
                order.setIsApproved(Boolean.parseBoolean(rs.getString("IsApproved")));
                order.setIsPayed(Boolean.parseBoolean(rs.getString("IsPayed")));
                orders.add(order);
            }
        } catch (SQLException e) {
        }
        return orders;
     }
    public List<OrderModel> getAllFinalOrders(boolean isPayed) {
        List<OrderModel> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `mainorder` WHERE isPayed="+isPayed);
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderId(rs.getInt("OrderId"));
                order.setCustomerId(rs.getString("CustomerId"));
                order.setNumOfPerson(rs.getInt("NumOfPerson"));
                order.setPicnicPlace(rs.getString("PicnicPlace"));
                order.setPicnicDate(rs.getDate("PicnicDate"));
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setCustomerName(dao.getCustomerName(order.getCustomerId()));
                order.setIsApproved(Boolean.parseBoolean(rs.getString("IsApproved")));
                order.setIsPayed(Boolean.parseBoolean(rs.getString("IsPayed")));
                orders.add(order);
            }
        } catch (SQLException e) {
        }
        return orders;
     }
    public void doApproveOrder(int id)
    {
     try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update `mainorder` set IsApproved=true where OrderId=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    
    }
    public void doPaymentOfOrder(int id)
    {
    try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update  `mainorder` set IsPayed=true where OrderId=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }
}

