package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.html");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");

        String email = req.getParameter("email");
        if (name == null || name.trim().isEmpty()) {
            resp.sendRedirect("login.html?error=invalid");
            return;
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("name", name);
        session.setAttribute("email", email);

// Session timeout: 60 seconds
        session.setMaxInactiveInterval(60);
        resp.sendRedirect("dashboard");


//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//
//        if (name.equalsIgnoreCase("admin")) {
//            HttpSession session = req.getSession(true);
//            session.setAttribute("name", name);
//            session.setMaxInactiveInterval(60);
//            resp.sendRedirect("dashboard");
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        req.setAttribute("user", username);
//        String password = req.getParameter("password");
//        req.setAttribute("password", password);
//
//        if(username.equals("admin") && password.equals("1234")) {
//            resp.sendRedirect("dashboard.html");
//        } else {
//            resp.sendRedirect("error.html");
//        }

//        RequestDispatcher rd = req.getRequestDispatcher("dashboard");
//        rd.forward(req, resp);

    }
}
