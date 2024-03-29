package com.tredence.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @NotBlank(message = "Product ID is required")
    private String productId;

    @Column(name = "category", nullable = false)
    @NotBlank(message = "Category is required")
    private String category;

    @Column(name = "brand", nullable = false)
    @NotBlank(message = "Brand is required")
    private String brand;
}



