/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.ManuDAO;
import com.pru.model.ManuModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Menu extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/AddUpdateMenu.jsp";
    private static final String LIST_USER = "/MenuList.jsp";
    private static final String back="Masters?action=back";
   
    private final ManuDAO dao;
    
    public Menu() {
        super();
        dao = new ManuDAO();
    }
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deleteMenu")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteManu(id);
            forward = LIST_USER;
            request.setAttribute("Menus", dao.getAllMenu());  
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("editMenu")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            ManuModel menu = dao.getMenuById(id);
            request.setAttribute("Menu", menu);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("listMenu")){
            forward = LIST_USER;
            request.setAttribute("Menus", dao.getAllMenu());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("back"))
        {
            forward = back;
            response.sendRedirect(forward);
            
        }else {
            forward = INSERT_OR_EDIT;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
         
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        ManuModel menu = new ManuModel();
        try {
        if(request.getParameter("id").equals("0")||request.getParameter("id").equals(""))
        {
        menu.setId(0);
        }
            else
            {
                menu.setId(Integer.parseInt(request.getParameter("id")));
            }
        menu.setName(request.getParameter("name"));
        menu.setDescription(request.getParameter("description"));
        menu.setPerHeadCost(Integer.parseInt(request.getParameter("perHeadCost")));
        } catch(NumberFormatException e) {
        }
        try{
          if(request.getParameter("id").equals("0")||request.getParameter("id").equals(""))
              dao.addMenu(menu);
          else
              dao.updateMenu(menu);

          response.sendRedirect("Menu?action=listMenu");

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
