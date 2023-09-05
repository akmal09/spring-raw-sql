package com.raw.springsql.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//dengan adanya ini tidak perlu ada setter getter dan constructor lagi
@Data
@Builder
@AllArgsConstructor

public class ResponseObject {
    private int code;
    private String message;
    private boolean status;
}