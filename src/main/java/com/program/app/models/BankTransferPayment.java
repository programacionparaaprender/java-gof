package com.program.app.models;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.program.app.interfaz.PaymentMethod;


@Component
public class BankTransferPayment  implements PaymentMethod {
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Processing bank transfer payment: " + amount);
    }
}