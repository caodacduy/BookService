package com.example.BookService.exception;

import com.example.BookService.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
        ApiResponse apiResponse=new ApiResponse<>();
        ErrorCode errorCode =exception.getErrorCode();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException exception){
        String enumKey= Objects.requireNonNull(exception.getFieldError()).getDefaultMessage();

        ErrorCode errorCode;
        try{
            errorCode=ErrorCode.valueOf(enumKey);
        }catch (IllegalArgumentException e){
            errorCode=ErrorCode.INVALID_KEY;
        }
        ApiResponse apiResponse=ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
