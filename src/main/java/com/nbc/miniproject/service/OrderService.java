package com.nbc.miniproject.service;

import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.dto.request.PostOrderRequestDto;
import com.nbc.miniproject.dto.response.OrderDetailResponseDto;
import com.nbc.miniproject.dto.response.ResponseDto;

public interface OrderService {
        ResponseEntity<? super ResponseDto> order(PostOrderRequestDto dto);
        ResponseEntity<? super OrderDetailResponseDto> getOrder(String orderId);
}
