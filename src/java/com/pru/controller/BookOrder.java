/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.BookOrderDAO;
import com.pru.dal.ManuDAO;
import com.pru.model.OrderModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author R.B.Shah
 */
public class BookOrder extends HttpServlet {

     private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/AddOrder.jsp";
   private static final String list="/ListOrder.jsp";
   private static final String home="Home?action=homeCustomer";
   
    private BookOrderDAO dao;
    private ManuDAO menudao;
    
    public BookOrder() {
        super();
        dao = new BookOrderDAO();
        menudao = new ManuDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("bkodr")){
            forward = INSERT_OR_EDIT;
            String id =request.getParameter("id");
            request.setAttribute("MenuList", menudao.getAllMenu());
            request.setAttribute("CustId", id);
            RequestDispatcher view=request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("lstodr"))
        {
        forward = list;
            request.setAttribute("CustId", request.getParameter("id"));
            request.setAttribute("ListOrder", dao.getAllOrders(request.getParameter("id")));
            RequestDispatcher view=request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward="";
        String custid;
        OrderModel order = new OrderModel();
        try {
            
        order.setCustomerId(request.getParameter("CustId"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date picdate = dateFormat.parse(request.getParameter("picdate"));
        order.setPicnicDate(picdate);
        order.setPicnicPlace(request.getParameter("picvenue"));
        order.setNumOfPerson(Integer.parseInt(request.getParameter("picmembers")));
        order.setSelectedMenu(request.getParameter("selectedmenu"));
        
        } catch(Exception e) {
            e.printStackTrace();
        }
        try{
           dao.InsertSelectedMenu(order);
              forward=home;
              response.sendRedirect(forward);
          
        }
          catch(Exception ex)
        {
         forward=INSERT_OR_EDIT;
         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
        }     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
