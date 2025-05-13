package com.program.app.decorador.impl;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.program.app.decorador.DataService;

@Service
@Primary
public class CachingDataServiceDecorator implements DataService {
    private final BasicDataService basicDataService;
    private final CacheManager cacheManager;

    public CachingDataServiceDecorator(BasicDataService basicDataService, 
                                     CacheManager cacheManager) {
        this.basicDataService = basicDataService;
        this.cacheManager = cacheManager;
    }

    @Override
    public String fetchData() {
        Cache cache = cacheManager.getCache("dataCache");
        String cachedData = cache != null ? cache.get("data", String.class) : null;
        
        if (cachedData != null) {
            return cachedData;
        }
        
        String freshData = basicDataService.fetchData();
        if (cache != null) {
            cache.put("data", freshData);
        }
        return freshData;
    }
}