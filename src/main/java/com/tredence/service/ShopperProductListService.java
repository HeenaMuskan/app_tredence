package com.tredence.service;


import com.tredence.entity.ShopperPersonalizedProductList;

import java.util.List;

public interface ShopperProductListService {

    void addShopperProductLists(List<ShopperPersonalizedProductList> shopperProductLists);

    List<ShopperPersonalizedProductList> getAllShopperProductLists();
}


