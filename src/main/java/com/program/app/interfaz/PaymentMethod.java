package com.program.app.interfaz;

import java.math.BigDecimal;

public interface PaymentMethod {
    void processPayment(BigDecimal amount);
}
