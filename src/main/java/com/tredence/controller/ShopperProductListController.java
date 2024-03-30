package com.tredence.controller;

import com.tredence.entity.ShopperPersonalizedProductList;
import com.tredence.service.ShopperProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shopper-product-list")
public class ShopperProductListController {

    private final ShopperProductListService shopperProductListService;

    @Autowired
    public ShopperProductListController(ShopperProductListService shopperProductListService) {
        this.shopperProductListService = shopperProductListService;
    }

 //POST http://localhost:8080/api/shopper-product-list/add

    @PostMapping("/add")
    public ResponseEntity<String> addShopperProductLists(@Valid @RequestBody List<ShopperPersonalizedProductList> shopperProductLists) {
        shopperProductListService.addShopperProductLists(shopperProductLists);
        return ResponseEntity.status(HttpStatus.CREATED).body("Shopper Product Lists added successfully");
    }

   //GET http://localhost:8080/api/shopper-product-list/get
    @GetMapping("/get")
    public ResponseEntity<List<ShopperPersonalizedProductList>> getShopperProductLists() {
        List<ShopperPersonalizedProductList> shopperProductLists = shopperProductListService.getAllShopperProductLists();
        return ResponseEntity.ok().body(shopperProductLists);
    }

}

