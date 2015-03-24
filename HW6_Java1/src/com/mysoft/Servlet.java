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
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         request.setAttribute("Guests",DB.getGuests());
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("Guests.jsp").forward(request,response);
        // Retrieve the value of the query parameter "username" (from text field)
        String firstname = request.getParameter("firstname");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (firstname == null) {
            out.println("<p>First name: MISSING</p>");
        } else {
            out.println("<p>First name: " + firstname + "</p>");
        }
        String lastname = request.getParameter("lastname");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (lastname == null) {
            out.println("<p>Last name: MISSING</p>");
        } else {
            out.println("<p>Last name: " + lastname + "</p>");
        }
        String useremail = request.getParameter("useremail");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (useremail == null) {
            out.println("<p>User email: MISSING</p>");
        } else {
            out.println("<p>User email: " + useremail + "</p>");
        }
        String textComment = request.getParameter("textComment");
        if (textComment == null) {
            out.println("<p>Text comment: MISSING</p>");
        } else {
            out.println("<p>Text comment: " + textComment + "</p>");
        }
        out.close();
        request.setAttribute("Guests",DB.setGuests(firstname,lastname, useremail, textComment));
        request.getRequestDispatcher("Guests.jsp").forward(request,response);

    }
}
