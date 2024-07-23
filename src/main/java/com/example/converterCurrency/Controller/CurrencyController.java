package com.example.converterCurrency.Controller;


import com.example.converterCurrency.DOT.CurrencyConversion;
import com.example.converterCurrency.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class CurrencyController {
   @Autowired
   CurrencyService currencyService;

    @PostMapping("/convert")
    public CurrencyConversion convertCurrency(@RequestParam String fromCurrency,
                                              @RequestParam String toCurrency,
                                              @RequestParam double amount) {
        return currencyService.convertCurrency(fromCurrency, toCurrency, amount);
    }
}


