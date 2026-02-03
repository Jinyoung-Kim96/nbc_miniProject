package com.nbc.miniproject.service;

import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.dto.response.ResponseDto;

import com.nbc.miniproject.dto.response.ProductDetailResponseDto;
import com.nbc.miniproject.dto.response.ProductListResponseDto;
import com.nbc.miniproject.dto.request.PatchProductRequestDto;
import com.nbc.miniproject.dto.request.PostProductRequestDto;

public interface ProductService {
    ResponseEntity<? super ResponseDto> product(PostProductRequestDto dto);
    ResponseEntity<? super ProductDetailResponseDto> getProduct(String sku);  
    ResponseEntity<? super ProductListResponseDto> getProductList();
    ResponseEntity<? super ResponseDto> deleteProduct(String sku);
    ResponseEntity<? super ResponseDto> patchProduct(PatchProductRequestDto dto, String sku);


}
