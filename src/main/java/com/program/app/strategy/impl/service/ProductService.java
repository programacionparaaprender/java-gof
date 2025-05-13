package com.program.app.strategy.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.program.app.models.Product;
import com.program.app.strategy.SortingStrategy;

@Service
public class ProductService {
    private final SortingStrategy sortingStrategy;

    public ProductService(@Qualifier("priceSorting") SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public List<Product> getSortedProducts(List<Product> products) {
        return sortingStrategy.sort(products);
    }
}
