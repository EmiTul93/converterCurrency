package com.example.converterCurrency.Web;

import com.example.converterCurrency.Controller.CurrencyController;
import com.example.converterCurrency.DOT.CurrencyConversion;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/convert")
public class ConversionServlet extends HttpServlet {
    private CurrencyController controller = new CurrencyController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Leggi i parametri dalla richiesta
        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Esegui la conversione
        CurrencyConversion conversion = controller.convertCurrency(fromCurrency, toCurrency, amount);

        // Imposta il tipo di contenuto della risposta
        response.setContentType("application/json");

        // Scrivi la risposta
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        out.print(objectMapper.writeValueAsString(conversion));
        out.flush();
    }
}

