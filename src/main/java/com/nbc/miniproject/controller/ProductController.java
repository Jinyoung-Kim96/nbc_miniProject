package com.nbc.miniproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbc.miniproject.dto.request.PatchProductRequestDto;
import com.nbc.miniproject.dto.request.PostProductRequestDto;
import com.nbc.miniproject.dto.response.ResponseDto;
import com.nbc.miniproject.dto.response.ProductDetailResponseDto;
import com.nbc.miniproject.dto.response.ProductListResponseDto;
import com.nbc.miniproject.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name="Product API")
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 생성")
    @PostMapping
    public ResponseEntity<? super ResponseDto> product(@RequestBody @Valid PostProductRequestDto requestBody) {
        ResponseEntity<? super ResponseDto> response = productService.product(requestBody);
        return response;
    }

    @Operation(summary = "상품 단건 조회")
    @GetMapping("/{sku}")
    public ResponseEntity<? super ProductDetailResponseDto> getProduct(@PathVariable("sku") String sku) {
        return productService.getProduct(sku);
    }

    @Operation(summary = "상품 목록 조회")
    @GetMapping("/list")
    public ResponseEntity<? super ProductListResponseDto> getProductList() {
        return productService.getProductList();
    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/{sku}")
    public ResponseEntity<? super ResponseDto>deleteProduct(@PathVariable("sku") String sku){
        return productService.deleteProduct(sku);
    }

    @Operation(summary = "상품 수정")
    @PatchMapping("/{sku}")
    public ResponseEntity<? super ResponseDto>patchProduct(
        @RequestBody @Valid PatchProductRequestDto dto,
        @PathVariable("sku") String sku
    ){
        return productService.patchProduct(dto, sku);
    }
    
    
}
