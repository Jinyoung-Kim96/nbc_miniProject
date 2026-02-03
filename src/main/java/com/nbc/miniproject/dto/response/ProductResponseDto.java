package com.nbc.miniproject.dto.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.common.ResponseCode;
import com.nbc.miniproject.common.ResponseMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto extends ResponseDto{

    public static ResponseEntity<ResponseDto> duplicateProductName(){
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_PRODUCT_NAME, ResponseMessage.DUPLICATE_PRODUCT_NAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }


    
}
