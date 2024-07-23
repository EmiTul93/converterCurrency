package com.example.converterCurrency.Service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeRateResponse {

    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}

