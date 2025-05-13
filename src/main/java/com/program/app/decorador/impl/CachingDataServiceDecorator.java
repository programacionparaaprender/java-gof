package com.program.app.decorador.impl;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.program.app.decorador.DataService;

@Service
@Primary
public class CachingDataServiceDecorator implements DataService {
    private final DataService dataService;
    private final CacheManager cacheManager;

    public CachingDataServiceDecorator(DataService dataService, CacheManager cacheManager) {
        this.dataService = dataService;
        this.cacheManager = cacheManager;
    }

    @Override
    public String fetchData() {
        String cachedData = cacheManager.getCache("dataCache").get("data", String.class);
        if (cachedData != null) {
            return cachedData;
        }
        
        String data = dataService.fetchData();
        cacheManager.getCache("dataCache").put("data", data);
        return data;
    }
}
