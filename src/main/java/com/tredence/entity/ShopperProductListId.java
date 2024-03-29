package com.tredence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Embeddable
public class ShopperProductListId implements Serializable {

    @Column(name = "shopper_id")
    @NotBlank(message = "Shopper ID is required")
    private String shopperId;

    @Column(name = "product_id")
    @NotBlank(message = "Product ID is required")
    private String productId;
}