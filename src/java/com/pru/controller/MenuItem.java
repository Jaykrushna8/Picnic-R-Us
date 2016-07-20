/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.ManuItemDAO;
import com.pru.model.ManuItemModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MenuItem extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/AddUpdateMenuItem.jsp";
    private static final String LIST_USER = "/MenuItemList.jsp";
    private static final String UPDATE_MENU = "/UpdateMenuItem.jsp";
    private static final String back="Masters?action=back";
   
    private final ManuItemDAO dao;
    
    public MenuItem() {
        super();
        dao = new ManuItemDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deleteMenuItem")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteManuItem(id);
            forward = LIST_USER;
            request.setAttribute("MenuItems", dao.getAllMenuItem());  
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("editMenuItem")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            ManuItemModel menu = dao.getMenuItemById(id);
            request.setAttribute("MenuItem", menu);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response); 
        } else if (action.equalsIgnoreCase("updateMenuItem")){
            forward = UPDATE_MENU;
            int id = Integer.parseInt(request.getParameter("id"));
            ManuItemModel menu = dao.getMenuItemById(id);
            request.setAttribute("MenuItem", menu);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("listMenuItem")){
            forward = LIST_USER;
            request.setAttribute("MenuItems", dao.getAllMenuItem());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("Update")){
            int id = Integer.parseInt(request.getParameter("menuitemid"));
            int menuid = Integer.parseInt(request.getParameter("ddlMenu"));
            dao.updateSingleMenuItem(menuid, id);
            forward = LIST_USER;
            request.setAttribute("MenuItems", dao.getAllMenuItem());
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
        ManuItemModel menu = new ManuItemModel();
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
        if(menu.getId()==0)
        {
            menu.setMenuId(0);
        }
        else
        {
        menu.setMenuId(Integer.parseInt(request.getParameter("menuId")));
        }
        menu.setMenuItemType(request.getParameter("menuItemType"));
        menu.setPerHeadCost(Integer.parseInt(request.getParameter("perHeadCost")));
        } catch(NumberFormatException e) {
        }
        try{
          if(request.getParameter("id").equals("0")||request.getParameter("id").equals(""))
              dao.addMenuItem(menu);
          else
              dao.updateMenuItem(menu);

          response.sendRedirect("MenuItem?action=listMenuItem");

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
