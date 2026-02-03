package com.nbc.miniproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostOrderRequestDto {
    
    @NotBlank
    private String orderId;

    @NotBlank
    private String sku;

    
    private int orderCount;
}
