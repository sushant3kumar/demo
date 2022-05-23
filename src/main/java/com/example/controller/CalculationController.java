package com.example.controller;

import com.example.service.ApartmentService;
import com.example.service.CalculatorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalculationController {
    private final CalculatorService calculatorService;

    public int calculateFinalBill()
    {
        return calculatorService.calculateMonthlyBill();
    }
}
