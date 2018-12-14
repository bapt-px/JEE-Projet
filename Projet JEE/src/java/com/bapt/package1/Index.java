/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bapt.package1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Baptiste
 */
public class Index extends HttpServlet {
    
     public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /* Ne fait rien d'autre qu'appeler une JSP */
        DB.connect();
        this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /*
         * Ici éventuellement des traitements divers, puis au lieu
         * d'appeler tout simplement un forwarding... 
         */
        System.out.print("attribute : " + (String) request.getAttribute("login"));
        System.out.print("parameter : " + (String) request.getParameter("login"));
        request.setAttribute("loginError", "true");
        doGet(request, response);
    }
}
