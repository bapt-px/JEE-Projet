/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bapt.package1;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.io.IOException;
import java.sql.SQLException;
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
public class Index extends HttpServlet {
    
     public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /* Ne fait rien d'autre qu'appeler une JSP */
        HttpSession session = request.getSession();
        if(session.getAttribute("isLog") != null ) response.sendRedirect("./list");
        else {
        DB.connect();
       
        this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
        }
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /*
         * Ici éventuellement des traitements divers, puis au lieu
         * d'appeler tout simplement un forwarding... 
         */
        HttpSession session = request.getSession();
        System.out.print("attribute : " + (String) request.getAttribute("login"));
        System.out.print("parameter : " + (String) request.getParameter("login"));
        try {
            if(DB.login((String) request.getParameter("login"), (String) request.getParameter("password"))) {
                 request.setAttribute("loginError", "false");
                 session.setAttribute("isLog", true);
                 response.sendRedirect("./list");
                 
            } else {
                 request.setAttribute("loginError", "true");
                 doGet(request, response);
            }
        } catch (SQLException ex) {
        Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
