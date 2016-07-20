/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.dal.UnitOfMeasureDAO;
import com.pru.model.UnitOfMeasureModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnitOfMeasure extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/UnitOfMeasure.jsp";
    private static final String LIST_USER = "/UnitOfMeasureList.jsp";
    private static final String back="Masters?action=back";
   
    private final UnitOfMeasureDAO dao;
    
    public UnitOfMeasure() {
        super();
        dao = new UnitOfMeasureDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteUnitOfMeasure(id);
            forward = LIST_USER;
            request.setAttribute("UnitOfMeasures", dao.getAllUnitOfMeasure());  
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            UnitOfMeasureModel unitofmeasure = dao.getUnitOfMeasureById(id);
            request.setAttribute("UnitOfMeasure", unitofmeasure);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("listUnitOfMeasure")){
            forward = LIST_USER;
            request.setAttribute("UnitOfMeasures", dao.getAllUnitOfMeasure());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("back"))
        {
            forward = back;
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
        UnitOfMeasureModel unitofmeasure = new UnitOfMeasureModel();
        try {
        if(request.getParameter("id").equals("0")||request.getParameter("id").equals(""))
        {
        unitofmeasure.setId(0);
        int idm=dao.getMaxId();
        idm=idm+1;
        empid="pru"+idm;
        }
            else
            {
                unitofmeasure.setId(Integer.parseInt(request.getParameter("id")));
            }
        unitofmeasure.setName(request.getParameter("name"));
        unitofmeasure.setDescription(request.getParameter("description"));
        unitofmeasure.setIcon(request.getParameter("icon"));
        } catch(NumberFormatException e) {
        }
        try{
          if(request.getParameter("id").equals("0")||request.getParameter("id").equals(""))
              dao.addUnitOfMeasure(unitofmeasure);
          else
              dao.updateUnitOfMeasure(unitofmeasure);

          response.sendRedirect("UnitOfMeasure?action=listUnitOfMeasure");

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
