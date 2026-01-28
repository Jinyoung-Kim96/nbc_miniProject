package com.nbc.miniproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbc.miniproject.dto.request.PatchProductRequestDto;
import com.nbc.miniproject.dto.request.PostProductRequestDto;
import com.nbc.miniproject.dto.response.ResponseDto;
import com.nbc.miniproject.dto.response.ProductDetailResponseDto;
import com.nbc.miniproject.dto.response.ProductListResponseDto;
import com.nbc.miniproject.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<? super ResponseDto> product(@RequestBody @Valid PostProductRequestDto requestBody) {
        ResponseEntity<? super ResponseDto> response = productService.product(requestBody);
        return response;
    }

    @GetMapping("/{sku}")
    public ResponseEntity<? super ProductDetailResponseDto> getProduct(@PathVariable("sku") String sku) {
        return productService.getProduct(sku);
    }

    @GetMapping("/list")
    public ResponseEntity<? super ProductListResponseDto> getProductList() {
        return productService.getProductList();
    }
    @DeleteMapping("/{sku}")
    public ResponseEntity<? super ResponseDto>deleteProduct(@PathVariable("sku") String sku){
        return productService.deleteProduct(sku);
    }

    @PatchMapping("/{sku}")
    public ResponseEntity<? super ResponseDto>patchProduct(
        @RequestBody @Valid PatchProductRequestDto dto,
        @PathVariable("sku") String sku
    ){
        return productService.patchProduct(dto, sku);
    }
    
    
}
