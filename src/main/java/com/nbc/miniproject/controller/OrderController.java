package com.nbc.miniproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbc.miniproject.dto.request.PostOrderRequestDto;
import com.nbc.miniproject.dto.response.ResponseDto;
import com.nbc.miniproject.dto.response.OrderDetailResponseDto;
import com.nbc.miniproject.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<? super ResponseDto> order(@RequestBody @Valid PostOrderRequestDto requestBody){
        ResponseEntity<? super ResponseDto> response = orderService.order(requestBody);
        return response;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<? super OrderDetailResponseDto> getOrder(@PathVariable("orderId") String orderId){
        return orderService.getOrder(orderId);
    }
    
}
