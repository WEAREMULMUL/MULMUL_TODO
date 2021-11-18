package com.mulmul.todo.error;

import com.mulmul.todo.error.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException() {
        return ResponseEntity.ok(
                ErrorResponseDto.of(ErrorMessage.INVALID_INPUT_VALUE)
        );
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException e) {
        return ResponseEntity.ok(
                ErrorResponseDto.of(e.getErrorMessage())
        );
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponseDto> handleException() {
        return ResponseEntity.ok(
                ErrorResponseDto.of(ErrorMessage.INTERNAL_SERVER_ERROR)
        );
    }
}
