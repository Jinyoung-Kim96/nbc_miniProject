package com.nbc.miniproject.dto.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.entity.Order;

import lombok.Getter;

@Getter
public class OrderDetailResponseDto extends ResponseDto {
    private String orderId;
    private String sku;
    private String productName;
    private int orderPrice;
    private int orderCount;
    private int totalPrice;
    private LocalDateTime orderDate;

    public OrderDetailResponseDto(Order order){
        super("SU", "Success");
        this.orderId = order.getOrderId();
        this.sku = order.getProduct().getSku();
        this.productName = order.getProduct().getProductName();
        this.orderPrice = order.getOrderPrice();
        this.orderCount = order.getOrderCount();
        this.totalPrice = order.getTotalPrice();
        this.orderDate = order.getOrderDate();

    }

    public static ResponseEntity<ResponseDto> success(Order order){
        OrderDetailResponseDto result = new OrderDetailResponseDto(order);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
