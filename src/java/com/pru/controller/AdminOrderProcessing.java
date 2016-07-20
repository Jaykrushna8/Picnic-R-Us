/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.OrderAdminDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminOrderProcessing extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String listNeworder = "/NewOrders.jsp";
    private static final String listApprovedOrder = "/ApprovedOrders.jsp";
    private static final String back="Masters?action=back";
   
    private final OrderAdminDAO dao;
    
    public AdminOrderProcessing() {
        super();
        dao = new OrderAdminDAO();
    }
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward="";
        String action = request.getParameter("action");
       if (action.equalsIgnoreCase("newOrders")){
            forward = listNeworder;
            request.setAttribute("Orders", dao.getAllOrders(false));
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("approvedOrders")){
            forward = listApprovedOrder;
            request.setAttribute("Orders", dao.getAllOrders(true));
            request.setAttribute("FinalOrders", dao.getAllFinalOrders(true));
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("approveOrder")){
            forward = listApprovedOrder;
            int id = Integer.parseInt(request.getParameter("id"));
            dao.doApproveOrder(id);
            request.setAttribute("Orders", dao.getAllOrders(true));
            request.setAttribute("FinalOrders", dao.getAllFinalOrders(true));
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if (action.equalsIgnoreCase("doPayment")){
            forward = listApprovedOrder;
            int id = Integer.parseInt(request.getParameter("id"));
            dao.doPaymentOfOrder(id);
            request.setAttribute("Orders", dao.getAllOrders(true));
            request.setAttribute("FinalOrders", dao.getAllFinalOrders(true));
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("back"))
        {
            forward = back;
            response.sendRedirect(forward);
        }
               
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
