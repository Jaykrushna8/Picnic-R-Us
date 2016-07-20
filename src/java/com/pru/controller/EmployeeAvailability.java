/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.EmployeeAvlbDAO;
import com.pru.model.EmployeeAvlbModel;
import com.pru.model.CalendarModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
/**
 *
 * @author Pushpraj
 */
public class EmployeeAvailability extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/EmployeeAvailability.jsp";
    private static final String home = "Home?action=Home";
   
    private EmployeeAvlbDAO dao;
    
    public EmployeeAvailability() {
        super();
        dao = new EmployeeAvlbDAO();
    }
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward="";
        
        String action = request.getParameter("action");
       
         if (action.equalsIgnoreCase("avblEmployee"))
         {
            forward=INSERT_OR_EDIT;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
         }
         else if(action.equalsIgnoreCase("EmpCal"))
         {
             forward = "/CheckEmpAvail.jsp";
             RequestDispatcher view = request.getRequestDispatcher(forward);
             view.forward(request, response);
         }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String forward="";
        EmployeeAvlbModel employee = new EmployeeAvlbModel();
        try {
            
            employee.setId(0);
            employee.setEmployeeId(request.getParameter("employeeId"));
            employee.setMonth(request.getParameter("month"));
            String string = "2011-03-22";
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateFrom"));
            employee.setDateFrom(date1);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateTo"));
            employee.setDateTo(date2);
            employee.setPostedOn(new Date());
            employee.setOtherComment(request.getParameter("otherComment"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        try{
          dao.saveEmpAvblInfo(employee);
          forward=home;
          response.sendRedirect(forward);
        }catch(Exception ex)
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
