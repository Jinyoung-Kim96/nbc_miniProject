package com.nbc.miniproject.common;

public interface ResponseMessage {
    
    // Http Status 200
    String SUCCESS = "Success.";

    // Http Status 400
    String DUPLICATE_SKU = "Duplicate sku.";
    String DUPLICATE_PRODUCT_NAME = "Duplicate product name.";
    String NOT_EXISTED_PRODUCT = "Not Existed Product.";
    String NOT_EXISTED_ORDER = "Not Existed Order";

    // Http Status 500
    String DATABASE_ERROR = "Database error.";
}
