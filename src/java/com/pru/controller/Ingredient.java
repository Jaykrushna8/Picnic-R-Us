 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.pru.model.IngredientModel;
import com.pru.dal.IngredientDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Ingredient extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/Ingredient.jsp";
    private static final String LIST_USER = "/IngredientList.jsp";
   
    private final IngredientDAO dao;
    
    public Ingredient() {
        super();
        dao = new IngredientDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteIngredient(id);
            forward = LIST_USER;
            request.setAttribute("Ingredient", dao.getAllIngredient());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            IngredientModel ingredient = dao.getIngredientById(id);
            request.setAttribute("Ingredient", ingredient);
        } else if (action.equalsIgnoreCase("listIngredient")){
            forward = LIST_USER;
            request.setAttribute("Ingredients", dao.getAllIngredient());
        } else {
            forward = INSERT_OR_EDIT;
           
        }
        
         RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        
    }

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward="";
        String empid;
        IngredientModel ingredient = new IngredientModel();
        try {
            System.out.println(request.getParameter("id"));
            if(request.getParameter("id").equals("0") || request.getParameter("id").equals(""))
        {
        ingredient.setId(0);
        int idm=dao.getMaxId();
        idm=idm+1;
        empid="pru"+idm;
        }
            else
            {
                ingredient.setId(Integer.parseInt(request.getParameter("id")));
            }
        ingredient.setName(request.getParameter("name"));
        ingredient.setDescription(request.getParameter("description"));
        ingredient.setPerUnitPrice(Integer.parseInt(request.getParameter("perUnitPrice")));
        ingredient.setUnitOfmeasureId(Integer.parseInt(request.getParameter("unitOfMeasureId")));
        //ingredient.setManuId(Integer.parseInt(request.getParameter("manuId")));
        } catch(NumberFormatException e) {
        }
        try{
          if(request.getParameter("id").equals("0")|| request.getParameter("id").equals(""))  
              dao.addIngredient(ingredient);
          else
              dao.updateIngredient(ingredient);

          response.sendRedirect("Ingredient?action=listIngredient");

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
