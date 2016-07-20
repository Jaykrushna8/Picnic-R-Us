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


public class Masters extends HttpServlet {

    public static final String listUnitOfMeasure="UnitOfMeasure?action=listUnitOfMeasure";
    public static final String listMenu="Menu?action=listMenu";
    public static final String listMenuItem="MenuItem?action=listMenuItem";
    public static final String back="Home?action=Home";
    public static final String masters="/Masters.jsp";
    public Masters()
    {
     super();
    }
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String forward="";
       String action = request.getParameter("action");
       if (action.equalsIgnoreCase("listUnitOfMeasure"))
       {
         forward=listUnitOfMeasure;
         response.sendRedirect(forward);
       }
       if (action.equalsIgnoreCase("listMenu"))
       {
         forward=listMenu;
         response.sendRedirect(forward);
       }
       if (action.equalsIgnoreCase("listMenuItem"))
       {
         forward=listMenuItem;
         response.sendRedirect(forward);
       }
       else if (action.equalsIgnoreCase("back"))
       {
        forward=back;
        response.sendRedirect(forward);
       }
       else if(action.equalsIgnoreCase("masters"))
       {
         forward=masters;
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
