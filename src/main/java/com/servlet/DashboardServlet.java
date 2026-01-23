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
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("name") == null) {
            resp.sendRedirect("login.html?error=expired");
            return;
        }

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Dashboard</h2>");
        resp.getWriter().println("<p>Name: " + session.getAttribute("name") +
                "</p>");

        resp.getWriter().println("<p>Email: " + session.getAttribute("email")
                + "</p>");
        resp.getWriter().println("<br>");
        resp.getWriter().println("<a href='profile.html'>Edit Profile</a><br><br>");
        resp.getWriter().println("<a href='logout'>Logout</a>");



//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//
//        if (session == null || session.getAttribute("name") == null) {
//            resp.sendRedirect("login?msg=sessionExpired");
//            return;
//        }
//        String username = (String) session.getAttribute("name");
//
//
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        out.println("<h1> Welcome to Dashboard");
//        out.println("<h1> Welcome " + username);
//        out.println("<a href='logout'> Log Out</a>");
//        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
