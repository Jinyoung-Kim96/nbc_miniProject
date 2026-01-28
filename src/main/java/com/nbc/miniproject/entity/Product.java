package com.nbc.miniproject.entity;

import com.nbc.miniproject.dto.request.PatchProductRequestDto;
import com.nbc.miniproject.dto.request.PostProductRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    
    @Id 
    private String sku;

    @Column(name="product_name", nullable=false)
    private String productName;

    @Column(nullable=false)
    private Integer price;

    private String description;

    public Product(PostProductRequestDto dto) {
        this.sku = dto.getSku();
        this.productName = dto.getProductName();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
    }

    public void patch(PatchProductRequestDto dto){
        this.productName = dto.getProductName();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
    }

}
