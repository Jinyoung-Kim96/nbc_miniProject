package com.nbc.miniproject.common;

public interface ResponseCode {
    // Http Status 200
    String SUCCESS = "SU";

    // Http Status 400
    String DUPLICATE_SKU = "DS";
    String DUPLICATE_PRODUCT_NAME = "DP";
    String NOT_EXISTED_PRODUCT = "NP";

    // Http Status 500
    String DATABASE_ERROR = "DBE";
}
