package com.program.app.observer.models;

import lombok.Data;

@Data
public class Order {
    private String id;
    private double amount;
    private String customerEmail;
    
    public Order(String id, double amount, String customerEmail) {
        this.id = id;
        this.amount = amount;
        this.customerEmail = customerEmail;
    }
  
}