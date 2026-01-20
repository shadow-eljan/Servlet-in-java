package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 22b1f9529106a61bfa01a6ea091454da33aa8537
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
<<<<<<< HEAD
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
=======
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = (String) req.getAttribute("user");

        out.println("Welcome to dashboard"+ name);
        out.close();
>>>>>>> 22b1f9529106a61bfa01a6ea091454da33aa8537
    }
}
