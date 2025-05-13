package com.program.app.strategy.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.program.app.models.Product;
import com.program.app.strategy.SortingStrategy;

@Service
@Qualifier("priceSorting")
public class PriceSortingStrategy implements SortingStrategy {
    @Override
    public List<Product> sort(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }
}
