package com.tredence.repository;

import com.tredence.entity.ShopperPersonalizedProductList;
import com.tredence.entity.ShopperProductListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperPersonalizedProductListRepository extends JpaRepository<ShopperPersonalizedProductList, ShopperProductListId> {
    // You can add custom query methods if needed
}
