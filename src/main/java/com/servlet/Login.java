package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        req.setAttribute("user", username);
        String password = req.getParameter("password");
        req.setAttribute("password", password);

        if(username.equals("admin") && password.equals("1234")) {
            resp.sendRedirect("dashboard.html");
        } else {
            resp.sendRedirect("error.html");
        }

//        RequestDispatcher rd = req.getRequestDispatcher("dashboard");
//        rd.forward(req, resp);
    }
}
