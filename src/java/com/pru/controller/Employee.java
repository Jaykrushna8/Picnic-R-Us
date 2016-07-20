/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.EmployeeDAO;
import com.pru.model.EmployeeModel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Employee extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/AddUpdateEmployee.jsp";
    private static final String LIST_USER = "/EmployeeList.jsp";
    private static final String home="Home?action=Home";
   
    private final EmployeeDAO dao;
    
    public Employee() {
        super();
        dao = new EmployeeDAO();
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteEmployee(id);
            forward = LIST_USER;
            request.setAttribute("employees", dao.getAllEmployee()); 
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } 
        else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeModel employee = dao.getEmployeeById(id);
            request.setAttribute("employee", employee);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if (action.equalsIgnoreCase("listEmployee")){
            forward = LIST_USER;
            request.setAttribute("employees", dao.getAllEmployee());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("home"))
        {
          forward=home;
          response.sendRedirect(forward);
        }
        else {
            forward = INSERT_OR_EDIT;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }

       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String empid;
        EmployeeModel employee = new EmployeeModel();
        try {
            String s=request.getParameter("id");
        if(request.getParameter("id").equals("0") || request.getParameter("id").equals(""))
        {
        int idm=dao.getMaxId();
        idm=idm+1;
        empid="pru"+idm;
        employee.setEmployeeId(empid);
        employee.setPassword(request.getParameter("password"));
        }
        else
        {
            employee.setId(Integer.parseInt(request.getParameter("id")));
        }
        
        employee.setFirstName(request.getParameter("firstName"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setAddressLine1(request.getParameter("addressLine1"));
        employee.setAddressLine2(request.getParameter("addressLine2"));
        employee.setAddressLine3(request.getParameter("addressLine3"));
        employee.setAddressLine4(request.getParameter("addressLine4"));
        employee.setMobileNumber(request.getParameter("mobileNumber"));
        employee.setEmployeeType(request.getParameter("employeeType"));
        employee.setMiddleName(request.getParameter("middleName"));
        employee.setEmailId(request.getParameter("emailId"));
        employee.setIpAddress(InetAddress.getLocalHost().toString());
        employee.setCreationDate(new Date());
        employee.setSalary(Integer.parseInt(request.getParameter("salary")));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = dateFormat.parse(request.getParameter("dob"));
        employee.setDob(dob);
        
        } catch(NumberFormatException | UnknownHostException | ParseException e) {
        }
        try{
          if(request.getParameter("id").equals("0")|| request.getParameter("id").equals(""))  
              dao.addEmployee(employee);
          else
              dao.updateEmployee(employee);

          response.sendRedirect("Employee?action=listEmployee");

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
