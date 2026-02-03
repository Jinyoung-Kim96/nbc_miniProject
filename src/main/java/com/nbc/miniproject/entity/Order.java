package com.nbc.miniproject.entity;

import java.time.LocalDateTime;

import com.nbc.miniproject.dto.request.PostOrderRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    @Id 
    @Column(name = "order_id")
    private String orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku")
    private Product product; 



    @Column(name = "order_price")
    private int orderPrice; 

    @Column(name = "order_count")
    private int orderCount;      
    
    @Column(name = "total_price")
    private int totalPrice;
    

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    public Order (PostOrderRequestDto dto, Product product){
        this.orderId = dto.getOrderId();
        this.orderCount = dto.getOrderCount();
        this.product = product;
        this.orderPrice = product.getPrice();
        this.totalPrice = product.getPrice() * dto.getOrderCount();
        this.orderDate = LocalDateTime.now();
    }



}
