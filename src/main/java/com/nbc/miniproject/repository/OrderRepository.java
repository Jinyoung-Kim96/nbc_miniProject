package com.nbc.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nbc.miniproject.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{
    
}
