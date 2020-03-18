package com.currencyconversion.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CalculatedValue {

    private String currencyFrom;
    private String currencyTo;
    private String calculatedValue;

}
