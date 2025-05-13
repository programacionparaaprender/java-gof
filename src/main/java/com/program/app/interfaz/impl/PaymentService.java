package com.program.app.interfaz.impl;

import org.springframework.stereotype.Service;

import com.program.app.interfaz.PaymentMethod;
import com.program.app.models.BankTransferPayment;
import com.program.app.models.CreditCardPayment;
import com.program.app.models.PayPalPayment;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PaymentService {
    public PaymentMethod createPaymentMethod(String type) {
        return switch (type.toLowerCase()) {
            case "creditcard" -> new CreditCardPayment();
            case "paypal" -> new PayPalPayment();
            case "banktransfer" -> new BankTransferPayment();
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }
}

