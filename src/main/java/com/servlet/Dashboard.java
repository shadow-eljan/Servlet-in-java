package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("name") == null){
            resp.sendRedirect("login?msg=sessionExpired");
            return;
        }
        String username = (String) session.getAttribute("name");



        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1> Welcome to Dashboard");
        out.println("<h1> Welcome "+ username);
        out.println("<a href='logout'> Log Out</a>");
        System.out.println(username);
    }
}
