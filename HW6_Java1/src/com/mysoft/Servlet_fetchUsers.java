package com.mysoft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by shcheki on 24.03.2015.
 */
@WebServlet(name = "Servlet_fetchUsers")
public class Servlet_fetchUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("html_form.jsp").forward(request,response);
        PrintWriter out = response.getWriter();
        //   request.getRequestDispatcher("Guests.jsp").forward(request,response);
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
        response.sendRedirect("test");
    }
}



