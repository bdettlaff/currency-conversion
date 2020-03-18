package com.currencyconversion.services;

import com.currencyconversion.model.CalculatedValue;
import com.currencyconversion.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConversionService {

    private RestTemplate restTemplate;

    @Autowired
    public CurrencyConversionService(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }

    public CalculatedValue convertPlnToIsk(String value){
        Currency currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/isk/", Currency.class);

        CalculatedValue calculatedValue = CalculatedValue.builder()
                .currencyFrom(currency.getCurrency())
                .currencyTo("polski złoty")
                .calculatedValue(convertValue(value,currency.getRates().get(0).getMid()))
                .build();
        System.out.println(calculatedValue);
        return calculatedValue;
    }

    private String convertValue(String value,String rate) {
        Double result = Double.valueOf(value) * Double.valueOf(rate);
        return result.toString();
    }

}

