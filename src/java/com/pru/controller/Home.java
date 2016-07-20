/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Home extends HttpServlet {
    
    HttpSession session;
    private static final long serialVersionUID = 1L;
    private static final String listEmployee = "Employee?action=listEmployee";
    private static final String avblEmployee = "EmployeeAvailability?action=avblEmployee";
    private static final String home="Home.jsp";
    private static final String homeEmployee="HomeEmployee.jsp";
    private static final String homeCustomer="HomeCustomer.jsp";
    private static final String masters="Masters?action=masters";
    private static final String back="Login?action=Logout";

    
    public Home() {
        super();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String forward="";
        
        String action = request.getParameter("action");
       
         if (action.equalsIgnoreCase("listEmployee"))
         {
            forward=listEmployee;
            response.sendRedirect(forward);
         }
         else if (action.equalsIgnoreCase("avblEmployee"))
         {
            forward=avblEmployee;
            response.sendRedirect(forward);
         }
         else if (action.equalsIgnoreCase("masters"))
         {
            forward=masters;
            response.sendRedirect(forward);
         }
         else if (action.equalsIgnoreCase("Logout"))
         {
            session=request.getSession();
            session.setAttribute("username", null);
            forward=back;
            response.sendRedirect(forward);
         }
         else if(action.equalsIgnoreCase("Home"))
         {
           forward=home;
           RequestDispatcher view = request.getRequestDispatcher(forward);
           view.forward(request, response);
         }
         else if(action.equalsIgnoreCase("HomeEmployee"))
         {
           forward=homeEmployee;
           RequestDispatcher view = request.getRequestDispatcher(forward);
           view.forward(request, response);
         }
         else if(action.equalsIgnoreCase("HomeCustomer"))
         {
           forward=homeCustomer;
           RequestDispatcher view = request.getRequestDispatcher(forward);
           view.forward(request, response);
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
