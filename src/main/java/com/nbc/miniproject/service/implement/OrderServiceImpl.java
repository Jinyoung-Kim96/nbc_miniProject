package com.nbc.miniproject.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nbc.miniproject.dto.request.PostOrderRequestDto;
import com.nbc.miniproject.dto.response.OrderDetailResponseDto;
import com.nbc.miniproject.dto.response.OrderResponseDto;
import com.nbc.miniproject.dto.response.ResponseDto;
import com.nbc.miniproject.entity.Order;
import com.nbc.miniproject.entity.Product;
import com.nbc.miniproject.repository.OrderRepository;
import com.nbc.miniproject.repository.ProductRepository;
import com.nbc.miniproject.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public ResponseEntity<? super ResponseDto> order(PostOrderRequestDto dto) {

        Product product = productRepository.findById(dto.getSku()).orElse(null);
        if (product == null) return ResponseDto.notExistProduct();
        Order order = new Order(dto, product);
        orderRepository.save(order);

        return ResponseDto.success();
    }

    @Override
    @Transactional
    public ResponseEntity<? super OrderDetailResponseDto> getOrder(String orderId) {

        Order order = orderRepository.findById(orderId).orElse(null);
        if(order == null ) return OrderResponseDto.notExistOrder();
        return OrderDetailResponseDto.success(order);

    }

}
