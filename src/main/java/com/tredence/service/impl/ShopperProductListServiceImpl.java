package com.tredence.service.impl;

import com.tredence.entity.ShopperPersonalizedProductList;
import com.tredence.entity.ShopperProductListId;
import com.tredence.repository.ShopperPersonalizedProductListRepository;
import com.tredence.service.ShopperProductListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopperProductListServiceImpl implements ShopperProductListService {

    private static final Logger logger = LoggerFactory.getLogger(ShopperProductListServiceImpl.class);

    private  ShopperPersonalizedProductListRepository shopperPersonalizedProductListRepository;

    @Autowired
    public ShopperProductListServiceImpl(ShopperPersonalizedProductListRepository shopperProductListRepository) {
        this.shopperPersonalizedProductListRepository = shopperProductListRepository;
    }

    @Override
    @Transactional
    public void addShopperProductLists(List<ShopperPersonalizedProductList> shopperProductLists) {
        try {
            shopperPersonalizedProductListRepository.saveAll(shopperProductLists);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add shopper product lists", e);
        }
    }

    public void saveShopperPersonalizedProductList(ShopperProductListId id, Double relevancyScore) {
        ShopperPersonalizedProductList shopperPersonalizedProductList = new ShopperPersonalizedProductList();
        shopperPersonalizedProductList.setId(id);
        shopperPersonalizedProductList.setRelevancyScore(relevancyScore);
        shopperPersonalizedProductListRepository.save(shopperPersonalizedProductList);
    }
    }

