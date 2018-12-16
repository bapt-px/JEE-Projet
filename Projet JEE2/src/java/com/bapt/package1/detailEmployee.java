/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bapt.package1;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Baptiste
 */
public class detailEmployee extends HttpServlet {
    
     public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /* Ne fait rien d'autre qu'appeler une JSP */
        
        HttpSession session = request.getSession();
        if(session.getAttribute("isLog") == null ) response.sendRedirect("./index");
         DB.connect();
         
         try {
             if(request.getParameter("selector") == null)  request.setAttribute("e", new Employee());
             else request.setAttribute("e", DB.getEmployee(Integer.parseInt(request.getParameter("selector"))));
         } catch (SQLException ex) {
             Logger.getLogger(detailEmployee.class.getName()).log(Level.SEVERE, null, ex);
         }
        this.getServletContext().getRequestDispatcher( "/detailEmployee.jsp" ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /*
         * Ici éventuellement des traitements divers, puis au lieu
         * d'appeler tout simplement un forwarding... 
         */

        HttpSession session = request.getSession();
        if(session.getAttribute("isLog") == null ) response.sendRedirect("./index");
        
        DB.connect();

        String action = (String) request.getParameter("action");
        if(action.compareTo("Save") == 0) {
            System.out.println("id : " + Integer.parseInt(request.getParameter("selector")));
            try {
                DB.updateEmployee(request.getParameter("name"),
                request.getParameter("firstName"),
                request.getParameter("telehome"),
                request.getParameter("telMob"),
                request.getParameter("telPro"),
                request.getParameter("adress"),
                request.getParameter("postalCode"),
                request.getParameter("city"),
                request.getParameter("email"),
                Integer.parseInt(request.getParameter("selector")));
                response.sendRedirect("./list");

            } catch (SQLException ex) {
                Logger.getLogger(listEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(action.compareTo("Add User") == 0) {
            try {
                DB.addEmployee(request.getParameter("name"),
                        request.getParameter("firstName"),
                        request.getParameter("telehome"),
                        request.getParameter("telMob"),
                        request.getParameter("telPro"),
                        request.getParameter("adress"),
                        request.getParameter("postalCode"),
                        request.getParameter("city"),
                        request.getParameter("email"));
                response.sendRedirect("./list");

            } catch (SQLException ex) {
                Logger.getLogger(detailEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if(request.getParameter("selector") == null)  request.setAttribute("e", new Employee());
                else request.setAttribute("e", DB.getEmployee(Integer.parseInt(request.getParameter("selector"))));
           } catch (SQLException ex) {
               Logger.getLogger(detailEmployee.class.getName()).log(Level.SEVERE, null, ex);
           }
              this.getServletContext().getRequestDispatcher( "/detailEmployee.jsp" ).forward( request, response );
           }
    }
}
