// ProductControllerTest.java

package com.tredence.product_test; // Update the package declaration

import com.tredence.entity.Product;
import com.tredence.repository.ProductRepository;
import com.tredence.service.ProductService;
import com.tredence.controller.ProductController; // Import ProductController
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProductControllerTest { // Rename the class to ProductControllerTest

    @Mock
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController; // Change the class to test ProductController

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProducts() {
        // Prepare test data
        List<Product> products = new ArrayList<>();
        // Add some products to the list

        // Mock the behavior of productService.addProducts()
        doNothing().when(productService).addProducts(products);

        // Call the controller method
        ResponseEntity<String> response = productController.addProducts(products);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Products added successfully", response.getBody());
        verify(productService, times(1)).addProducts(products);
    }
    @Test
    void testGetProductsByCategoryAndBrand() {
        // Prepare test data
        String category = "Test Category";
        String brand = "Test Brand";
        int limit = 10;
        String sortBy = "testSort";
        String orderBy = "asc";
        int page = 0;

        // Mock service method
        List<Product> expectedProducts = Collections.singletonList(new Product());
        when(productService.getProductsByCategoryAndBrand(category, brand, limit, sortBy, orderBy, page))
                .thenReturn(expectedProducts);

        // Call controller method
        List<Product> actualProducts = productController.getProductsByCategoryAndBrand(category, brand, limit, sortBy, orderBy, page);

        // Verify result
        assertEquals(expectedProducts, actualProducts);
    }
}



