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
public class listEmployee extends HttpServlet {
    
     public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /* Ne fait rien d'autre qu'appeler une JSP */
        HttpSession session = request.getSession();
        if(session.getAttribute("isLog") == null ) response.sendRedirect("./index");
        DB.connect();

         try {
             request.setAttribute("employee", DB.getListEmployee());
         } catch (SQLException ex) {
             Logger.getLogger(listEmployee.class.getName()).log(Level.SEVERE, null, ex);
         }
        this.getServletContext().getRequestDispatcher( "/list.jsp" ).forward( request, response );
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
        if(action.compareTo("Delete") == 0) {
            try {
                DB.removeEmployee(Integer.parseInt(request.getParameter("selector")));
                doGet(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(listEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.compareTo("Details") == 0) {
            this.getServletContext().getRequestDispatcher( "/detailEmployee" ).forward( request, response );
        } else if (action.compareTo("Logout") == 0) {
            response.sendRedirect("./logout");
        } else {
            request.removeAttribute("selector");
            response.sendRedirect("./detailEmployee");
        }
        
    }
}
