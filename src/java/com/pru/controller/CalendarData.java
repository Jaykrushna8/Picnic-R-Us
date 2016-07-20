/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pru.controller;

import com.google.gson.Gson;
import com.pru.dal.EmployeeAvlbDAO;
import com.pru.model.CalendarModel;
import com.pru.model.EmployeeAvlbModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalendarData extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        List l = new ArrayList();

        EmployeeAvlbDAO c = new EmployeeAvlbDAO();
        List<EmployeeAvlbModel> getData = c.GetAvailableEmp();
        for(int i=0;i<getData.size();i++)
        {
        CalendarModel cal = new CalendarModel();
        cal.setStart(getData.get(i).getDateAvail().toString());
        cal.setEnd(getData.get(i).getDateAvail().toString());
        cal.setTitle(String.valueOf(getData.get(i).getNumAvail()));
        l.add(cal);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(l));
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
