package com.weightthumb.common.advice;

import com.weightthumb.common.advice.exception.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice()
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NestedRuntimeException.class)
    public ErrorResult ex(NestedRuntimeException e) {
        return new ErrorResult("잘못된 요청 값 입니다.");
    }
}
