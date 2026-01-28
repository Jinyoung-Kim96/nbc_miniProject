package com.nbc.miniproject.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.entity.Product;

import lombok.Getter;

@Getter
public class ProductDetailResponseDto extends ResponseDto{
    private String sku;
    private String productName;
    private int price;
    private String description;

    public ProductDetailResponseDto(Product product) {
        super("SU", "Success");
        this.sku = product.getSku();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }

    public static ResponseEntity<ResponseDto> success(Product product){
        ProductDetailResponseDto result = new ProductDetailResponseDto(product);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
