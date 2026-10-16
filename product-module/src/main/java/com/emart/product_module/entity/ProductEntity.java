package com.emart.product_module.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name="products")
@AllArgsConstructor
@NoArgsConstructor 
@Data 
@Builder 
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private String imageUrl;
    private String brand;
    private Double discount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void createdAt() {
        this.createdAt=LocalDateTime.now();
    }

    public void updatedAt() {
        this.updatedAt=LocalDateTime.now();
    }

}
