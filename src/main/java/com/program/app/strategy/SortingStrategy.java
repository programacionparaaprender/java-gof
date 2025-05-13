package com.program.app.strategy;

import java.util.List;

import com.program.app.models.Product;

public interface SortingStrategy {
    List<Product> sort(List<Product> products);
}
