package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Feedback")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String message = req.getParameter("message");

        if(name == null || name.trim().isEmpty()) name = "Guest";
        if(message == null || message.trim().isEmpty()) message = "Guest";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>" +
                "<head><title>Feedback Result</title></head>" +
                "<body>" +
                "<h2> Thank you for your feedback, " + name + "</h2>" +
                "<strong>Your message: </strong>" + message +
                "<hr/>" +
                "<a href='feedback.html'>Go Back</a>" +
                "</body>" +
                "</html>");
    }
}
