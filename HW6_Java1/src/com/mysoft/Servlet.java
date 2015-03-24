package com.mysoft;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.*;


/**
 * Created by shcheki on 20.03.2015.
 */
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
     //   String age=request.getParameter("age");
     // response.getOutputStream().write(("Hello").getBytes());
      //  doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         request.setAttribute("Guests",DB.getGuests());
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("Guests.jsp").forward(request,response);
    }
}
