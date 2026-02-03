package com.nbc.miniproject.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.common.ResponseCode;
import com.nbc.miniproject.common.ResponseMessage;

public class OrderResponseDto extends ResponseDto {
    public static ResponseEntity<ResponseDto> notExistOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_ORDER, ResponseMessage.NOT_EXISTED_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
