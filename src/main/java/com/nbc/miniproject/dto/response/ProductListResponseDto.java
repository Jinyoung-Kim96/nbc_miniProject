package com.nbc.miniproject.dto.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.entity.Product;

import lombok.Getter;

@Getter
public class ProductListResponseDto extends ResponseDto{
    private List<Product> productList;

    public ProductListResponseDto(List<Product> productList) {
        super("SU", "Success");
        this.productList = productList;
    }

        public static ResponseEntity<ProductListResponseDto> success(List<Product> productList) {
        return ResponseEntity.status(HttpStatus.OK).body(new ProductListResponseDto(productList));
    }
}
