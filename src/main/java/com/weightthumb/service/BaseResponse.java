package com.weightthumb.service;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
public abstract class BaseResponse {
    private String resultCode;
    private String resultMessage;
    private Object result;
}
