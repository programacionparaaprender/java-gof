package com.program.app.decorador.impl;

import org.springframework.stereotype.Service;

import com.program.app.decorador.DataService;

@Service
public class BasicDataService implements DataService {
    @Override
    public String fetchData() {
        // Simular operación costosa
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data fetched at " + System.currentTimeMillis();
    }
}
