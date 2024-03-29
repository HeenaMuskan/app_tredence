package com.tredence.service;

import com.tredence.entity.Product;

import java.util.List;

public interface ProductService {

    void addProducts(List<Product> products);

    List<Product> getProductsByCategoryAndBrand(String category, String brand, int limit, String sortBy, String orderBy, int page);
}
