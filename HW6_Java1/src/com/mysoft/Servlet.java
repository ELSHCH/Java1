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
         request.setAttribute("News",DB.getNews());
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("com.mysoft.News.jsp").forward(request,response);
        // Retrieve the value of the query parameter "username" (from text field)
        String textNews = request.getParameter("textNews");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (textNews == null) {
            out.println("<p>Заголовок: MISSING</p>");
        } else {
            out.println("<p>Заголовок: " + textNews + "</p>");
        }
        String numNews = request.getParameter("numNews");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (numNews == null) {
            out.println("<p>Номер новости: MISSING</p>");
        } else {
            out.println("<p>Номер новости: " + numNews + "</p>");
        }
        String title = request.getParameter("title");
        if (title == null) {
            out.println("<p>Номер новости: MISSING</p>");
        } else {
            out.println("<p>Номер новости: " + title + "</p>");
        }
    }
}
