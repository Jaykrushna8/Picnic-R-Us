/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.LoginDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
    
    HttpSession session;
    private static final long serialVersionUID = 1L;
    private static final String fail = "/Failure.jsp";
    private static final String success = "Home?action=Home";
    private static final String back="index.jsp";
    private static final String successEmployee = "Home?action=HomeEmployee";
    private static final String successCustomer = "Home?action=HomeCustomer";
    private static final String login="/Login.jsp";
    private static final String addCustomer="Customer?action=addCustomer";
    LoginDAO dao;
    
    public Login() {
        super();
        dao=new LoginDAO();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       String forward="";
       String action = request.getParameter("action");
       if (action.equalsIgnoreCase("Login")){
            forward=login;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
       }
       else if (action.equalsIgnoreCase("TryAgain"))
       {
            forward=login;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
       }
       else if (action.equalsIgnoreCase("Logout"))
       {
            forward=login;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
       }
       else if (action.equalsIgnoreCase("addCustomer"))
       {
            forward=addCustomer;
            response.sendRedirect(forward);
       }
       else if (action.equalsIgnoreCase("back"))
       {
            forward=back;
            response.sendRedirect(forward);
       }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String forward="";
       session=request.getSession();
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       int cs = dao.doLogin(username,password);
       int lt=dao.getLoginType(username);
       String employeeId=dao.getEmployeeId(username);
       if(cs == 5)
       {
           if(lt==1)
           {   
               session.setAttribute("username", employeeId);
               forward = success;
               response.sendRedirect(forward);

           }
           else if(lt==2)
           {
               session.setAttribute("username", employeeId);
               forward = successEmployee;
               response.sendRedirect(forward);
           }
           else if(lt==3)
           {  
               session.setAttribute("username", employeeId);
               forward = successCustomer;
               response.sendRedirect(forward);
           }
           else
           {
               session.setAttribute("username", employeeId);
               forward = fail;
               RequestDispatcher view = request.getRequestDispatcher(forward);
               view.forward(request, response);
           }
       }
       else
       {
           forward = fail;
           RequestDispatcher view = request.getRequestDispatcher(forward);
           view.forward(request, response);
       }
       
     }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
