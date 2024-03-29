package com.tredence.controller;

// ProductController.java
import com.tredence.entity.Product;
import com.tredence.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {
    @Autowired
    private ProductService productService;

  //POST http://localhost:8080/api/products/add
    @PostMapping("/add")
    public ResponseEntity<String> addProducts(@Valid @RequestBody List<Product> products) {
        productService.addProducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).body("Products added successfully");
    }

    //GET http://localhost:8080/api/products?category=Babies&brand=Babyom&limit=10
    @GetMapping
    public List<Product> getProductsByCategoryAndBrand(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "orderBy", defaultValue = "asc") String orderBy,
            @RequestParam(value = "page", defaultValue = "0") int page) {
        return productService.getProductsByCategoryAndBrand(category, brand, limit, sortBy, orderBy, page);
    }

}


