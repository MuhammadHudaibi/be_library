package com.library.demo.util;

import com.library.demo.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T>ResponseEntity<CommonResponse<T>> createResponse(HttpStatus status, String message, T data) {
        CommonResponse<T> commonResponse = CommonResponse.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status.value()).body(commonResponse);
    }
}
