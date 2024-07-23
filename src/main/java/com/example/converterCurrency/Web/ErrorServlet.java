package com.example.converterCurrency.Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Si è verificato un errore</h1>");
        response.getWriter().println("<p>Si è verificato un errore durante l'elaborazione della richiesta. Per favore, riprova più tardi.</p>");
        response.getWriter().println("</body></html>");
    }
}

