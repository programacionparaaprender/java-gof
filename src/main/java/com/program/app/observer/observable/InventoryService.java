package com.program.app.observer.observable;

import org.springframework.stereotype.Service;

import com.program.app.observer.OrderObserver;
import com.program.app.observer.models.Order;

@Service
public class InventoryService implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Actualizando inventario para el pedido: " + order.getId());
    }
}
