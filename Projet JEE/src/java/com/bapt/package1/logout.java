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
public class logout extends HttpServlet {
    
     public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /* Ne fait rien d'autre qu'appeler une JSP */
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("./index");
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
        /*
         * Ici éventuellement des traitements divers, puis au lieu
         * d'appeler tout simplement un forwarding... 
         */

    }
}
