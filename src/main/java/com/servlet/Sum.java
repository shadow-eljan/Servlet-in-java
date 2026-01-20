package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Sum")
public class Sum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double num1 = Double.valueOf(req.getParameter("number1"));
        Double num2 = Double.valueOf(req.getParameter("number2"));

        double sum = num1 + num2;

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>SUM</title></head>");
        out.println("<body>");
        out.println("<h1>The sum is: " + sum + "!</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
