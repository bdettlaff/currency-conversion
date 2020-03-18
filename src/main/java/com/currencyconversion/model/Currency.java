package com.currencyconversion.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Currency {
    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;
}
