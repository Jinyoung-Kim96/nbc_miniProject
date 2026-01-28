package com.nbc.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nbc.miniproject.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
    boolean existsByProductName(String productName);
}
