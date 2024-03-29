package com.tredence.product_test;

import com.tredence.controller.ShopperProductListController;
import com.tredence.entity.ShopperPersonalizedProductList;
import com.tredence.service.ShopperProductListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.ConstraintViolationException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class ShopperProductListControllerTest {

    @Mock
    private ShopperProductListService shopperProductListService;

    @InjectMocks
    private ShopperProductListController shopperProductListController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddShopperProductLists_Success() {
        // Prepare test data
        ShopperPersonalizedProductList productList = new ShopperPersonalizedProductList();
        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).body("Shopper Product Lists added successfully");

        // Mock service method to do nothing (success case)
        doNothing().when(shopperProductListService).addShopperProductLists(Collections.singletonList(productList));

        // Call controller method
        ResponseEntity<String> actualResponse = shopperProductListController.addShopperProductLists(Collections.singletonList(productList));

        // Verify result
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testAddShopperProductLists_ValidationFailure() {
        // Prepare test data
        ShopperPersonalizedProductList productList = new ShopperPersonalizedProductList();

        // Mock service method to throw ConstraintViolationException (validation failure case)
        doThrow(ConstraintViolationException.class).when(shopperProductListService).addShopperProductLists(Collections.singletonList(productList));

        // Call controller method and verify that it throws ConstraintViolationException
        assertThrows(ConstraintViolationException.class, () -> {
            shopperProductListController.addShopperProductLists(Collections.singletonList(productList));
        });
    }
}
