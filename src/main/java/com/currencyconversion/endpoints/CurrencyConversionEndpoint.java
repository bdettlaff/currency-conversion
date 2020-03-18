package com.currencyconversion.endpoints;

import com.currencyconversion.model.CalculatedValue;
import com.currencyconversion.model.Currency;
import com.currencyconversion.services.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyConversionEndpoint {

    private CurrencyConversionService currencyConversionService;

    @Autowired
    public CurrencyConversionEndpoint(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/convert/plntoisk/{value}")
    public CalculatedValue convertPlnToIsk(@PathVariable String value){
        return (this.currencyConversionService.convertPlnToIsk(value));
    }


















}
