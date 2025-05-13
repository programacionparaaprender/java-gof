package com.program.app.models;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.program.app.interfaz.PaymentMethod;

@Component
public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Processing credit card payment: " + amount);
    }
}

