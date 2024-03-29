package com.tredence.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "shopper_personalized_product_list")
public class ShopperPersonalizedProductList {

    @EmbeddedId
    private ShopperProductListId id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @NotNull(message = "Product is required")
    private Product product;

    @Column(name = "relevancy_score")
    private Double relevancyScore;
}



