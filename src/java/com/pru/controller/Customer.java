/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.CustomerDAO;
import com.pru.dal.ManuDAO;
import com.pru.dal.ManuItemDAO;
import com.pru.model.CustomerModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Customer extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/CustomerRegistration.jsp";
    private static final String login="Login?action=Login";
    private static final String home="Home?action=homeCustomer";
    private static final String menus="/Menus.jsp";
    private static final String items="/Items.jsp";
    private static final String back="Login?action=back";
   
    private final CustomerDAO dao;
    private final ManuDAO mdao;
    private final ManuItemDAO midao;
    
    public Customer() {
        super();
        dao = new CustomerDAO();
        mdao=new ManuDAO();
        midao=new ManuItemDAO();
    }
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("editCustomer")){
            forward = INSERT_OR_EDIT;
            String id =request.getParameter("id");
            CustomerModel cust = dao.getCustomerById(id);
            request.setAttribute("customer", cust);
            RequestDispatcher view=request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if (action.equalsIgnoreCase("menus")){
            forward = menus;
            request.setAttribute("Menus", mdao.getAllMenu());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if (action.equalsIgnoreCase("menuItems")){
            forward = items;
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("MenuItems", midao.getAllMenuItem(id));
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("addCustomer")){
            forward = INSERT_OR_EDIT;
            RequestDispatcher view=request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("home"))
        {
          forward = home;
          response.sendRedirect(forward);
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
        
        String forward="";
        String custid;
        CustomerModel cust = new CustomerModel();
        try {
        if(request.getParameter("id").equals("0")|| request.getParameter("id").equals(""))
        {
        int idm=dao.getMaxId();
        idm=idm+1;
        custid="pru_c"+idm;
        cust.setCustomerId(custid);
        cust.setPassword(request.getParameter("password"));
        }
        else
        {
            cust.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        cust.setFirstName(request.getParameter("firstName"));
        cust.setLastName(request.getParameter("lastName"));
        cust.setAddressLine1(request.getParameter("addressLine1"));
        cust.setAddressLine2(request.getParameter("addressLine2"));
        cust.setAddressLine3(request.getParameter("addressLine3"));
        cust.setAddressLine4(request.getParameter("addressLine4"));
        cust.setMobileNumber(request.getParameter("mobileNumber"));
        cust.setMiddleName(request.getParameter("middleName"));
        cust.setEmailId(request.getParameter("emailId"));
        
        } catch(NumberFormatException e) {
        }
        try{
          if(request.getParameter("id").equals("0") || request.getParameter("id").equals(""))
          {  
              dao.addCustomer(cust);
              forward=login;
              response.sendRedirect(forward);
          }
          else
          {
              dao.updateCustomer(cust);
              forward=home;
              response.sendRedirect(forward);
          }
        }catch(IOException ex)
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
