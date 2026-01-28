package com.nbc.miniproject.service.implement;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<? super ResponseDto> product(PostProductRequestDto dto) {
        try{
            
            if(productRepository.existsById(dto.getSku())) return ProductResponseDto.duplicateSku();
            if(productRepository.existsByProductName(dto.getProductName())) return ProductResponseDto.duplicateProductName();
            Product product = new Product(dto);
            productRepository.save(product);
            
        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super ProductDetailResponseDto> getProduct(String sku) {
        try{
            Optional<Product> optionalProduct = productRepository.findById(sku);
            if (optionalProduct.isEmpty()) return ProductResponseDto.notExistProduct();
            Product product = optionalProduct.get();
            return ProductDetailResponseDto.success(product);   
        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }

    @Override
    public ResponseEntity<? super ProductListResponseDto> getProductList() {
        try{
            List<Product> productList = productRepository.findAll();
            return ProductListResponseDto.success(productList);
        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super ResponseDto> deleteProduct(String sku) {
        try{
            boolean exists = productRepository.existsById(sku);
            if (!exists) return ProductResponseDto.notExistProduct();
            productRepository.deleteById(sku);
            return ResponseDto.success();
        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<? super ResponseDto> patchProduct(PatchProductRequestDto dto, String sku) {
        try{
            Product product = productRepository.findById(sku).orElse(null);
            if(product == null) return ProductResponseDto.notExistProduct(); 
            boolean isNewName = !product.getProductName().equals(dto.getProductName());
            if(isNewName && productRepository.existsByProductName(dto.getProductName())) return ProductResponseDto.duplicateProductName();
            product.patch(dto);
            return ResponseDto.success();
            
        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }


  

    
    
}
