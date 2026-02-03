package com.nbc.miniproject.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nbc.miniproject.dto.request.PatchProductRequestDto;
import com.nbc.miniproject.dto.request.PostProductRequestDto;
import com.nbc.miniproject.dto.response.ProductResponseDto;
import com.nbc.miniproject.dto.response.ProductDetailResponseDto;
import com.nbc.miniproject.dto.response.ProductListResponseDto;
import com.nbc.miniproject.dto.response.ResponseDto;
import com.nbc.miniproject.entity.Product;

import com.nbc.miniproject.repository.ProductRepository;
import com.nbc.miniproject.service.ProductService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    @Override
    @Transactional
    public ResponseEntity<? super ResponseDto> product(PostProductRequestDto dto) {

        if(productRepository.existsById(dto.getSku())) return ResponseDto.duplicateSku();
        if(productRepository.existsByProductName(dto.getProductName())) return ProductResponseDto.duplicateProductName();
        Product product = new Product(dto);
        productRepository.save(product);
        return ResponseDto.success();

    }

    @Override
    @Transactional
    public ResponseEntity<? super ProductDetailResponseDto> getProduct(String sku) {

        Product product = productRepository.findById(sku).orElse(null);
        if (product == null ) return ResponseDto.notExistProduct();
        return ProductDetailResponseDto.success(product);   

    }

    @Override
    @Transactional
    public ResponseEntity<? super ProductListResponseDto> getProductList() {

        List<Product> productList = productRepository.findAll();
        return ProductListResponseDto.success(productList);
    }

    @Override
    @Transactional
    public ResponseEntity<? super ResponseDto> deleteProduct(String sku) {
        
        boolean exists = productRepository.existsById(sku);
        if (!exists) return ProductResponseDto.notExistProduct();
        productRepository.deleteById(sku);
        return ResponseDto.success();
        
    }

    @Override
    @Transactional
    public ResponseEntity<? super ResponseDto> patchProduct(PatchProductRequestDto dto, String sku) {

        Product product = productRepository.findById(sku).orElse(null);
        if(product == null) return ProductResponseDto.notExistProduct(); 
        boolean isNewName = !product.getProductName().equals(dto.getProductName());
        if(isNewName && productRepository.existsByProductName(dto.getProductName())) return ProductResponseDto.duplicateProductName();
        product.patch(dto);
        return ResponseDto.success();
        
    }





  

    
    
}
