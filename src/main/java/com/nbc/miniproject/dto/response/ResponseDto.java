package com.nbc.miniproject.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nbc.miniproject.common.ResponseCode;
import com.nbc.miniproject.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    
    private String code;
    private String message;

    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto result = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    public static ResponseEntity<ResponseDto> success(){
        ResponseDto result = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> duplicateSku(){
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_SKU, ResponseMessage.DUPLICATE_SKU);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistProduct(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_PRODUCT, ResponseMessage.NOT_EXISTED_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
