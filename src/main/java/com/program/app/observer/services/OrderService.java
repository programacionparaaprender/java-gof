package com.program.app.observer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.program.app.observer.OrderObserver;
import com.program.app.observer.models.Order;

@Service
public class OrderService {
    private final List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void placeOrder(Order order) {
        // Lógica para colocar el pedido
        
        // Notificar a los observadores
        observers.forEach(observer -> observer.update(order));
    }
}
