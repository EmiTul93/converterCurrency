package com.example.converterCurrency.Service;

import com.example.converterCurrency.DOT.CurrencyConversion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    @Value("https://api.exchangerate-api.com/v6") // URL dell'API
    private String apiUrl;

    @Value("0274a496e3518481e4c9b148") // Chiave API
    private String apiKey;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyConversion convertCurrency(String fromCurrency, String toCurrency, double amount) {
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.setFromCurrency(fromCurrency);
        conversion.setToCurrency(toCurrency);
        conversion.setAmount(amount);

        try {
            double rate = getExchangeRate(fromCurrency, toCurrency);
            conversion.setConvertedAmount(amount * rate);
        } catch (Exception e) {
            e.printStackTrace();
            // Gestisci l'errore
        }

        return conversion;
    }
    private double getExchangeRate(String fromCurrency, String toCurrency) {
        // Costruisci l'URL dell'API
        String url = String.format("%s/latest?base=%s&symbols=%s&apikey=%s", apiUrl, fromCurrency, toCurrency, apiKey);

        // Effettua la richiesta HTTP
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);

        // Estrai il tasso di cambio dalla risposta
        if (response != null && response.getRates() != null) {
            return response.getRates().get(toCurrency);
        } else {
            throw new RuntimeException("Unable to fetch exchange rate");
        }
    }
}
