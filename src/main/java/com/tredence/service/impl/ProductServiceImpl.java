package com.tredence.service.impl;

import com.tredence.entity.Product;
import com.tredence.exception.ProductNotFoundException;
import com.tredence.repository.ProductRepository;
import com.tredence.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional
    public void addProducts(List<Product> products) {
        Optional<List<Product>> savedProducts = Optional.ofNullable(productRepository.saveAll(products));
        savedProducts.orElseThrow(() -> new ProductNotFoundException("Failed to save products"));
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(@NotBlank(message = "Category is required") String category,
                                                       @NotBlank(message = "Brand is required") String brand,
                                                       int limit,
                                                       String sortBy,
                                                       String orderBy,
                                                       int page) {
        // Implement logic to retrieve products by category and brand with sorting, pagination, etc.
        Optional<List<Product>> productList = Optional.ofNullable(productRepository.findAllByCategoryAndBrand(category, brand, PageRequest.of(page, limit)));
        return productList.orElseThrow(() -> new RuntimeException("No products found for the given category and brand"));
    }
}

