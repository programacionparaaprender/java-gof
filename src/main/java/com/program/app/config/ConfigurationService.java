package com.program.app.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private static ConfigurationService instance;
    private final Map<String, String> configs = new HashMap<>();

    private ConfigurationService() {
        // Cargar configuraciones iniciales
        configs.put("app.version", "1.0.0");
    }

    // Spring ya maneja esto como Singleton por defecto con @Service
    // Pero aquí mostramos la implementación clásica también
    public static synchronized ConfigurationService getInstance() {
        if (instance == null) {
            instance = new ConfigurationService();
        }
        return instance;
    }

    public String getConfig(String key) {
        return configs.get(key);
    }
}
