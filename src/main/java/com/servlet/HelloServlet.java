package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>" +
                "<head>" +
                "<title> Hello World </title>" +
                "</head>" +
                "<body>" +
                "<h1>Hello from Servlet</h1>" +
                "<p>This is done in Servlet</p>" +
                "</body>" +
                "</html>");
        out.close();
    }
}
