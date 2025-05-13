package com.program.app.observer;

import com.program.app.observer.models.Order;

public interface OrderObserver {
    void update(Order order);
}
