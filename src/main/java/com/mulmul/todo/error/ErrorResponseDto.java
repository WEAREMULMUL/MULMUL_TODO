package com.mulmul.todo.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    private final int status;
    private final String message;
    private final LocalDateTime serverDateTime;

    private ErrorResponseDto(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
        this.serverDateTime = LocalDateTime.now();
    }

    public static ErrorResponseDto of(ErrorMessage message) {
        return new ErrorResponseDto(message.getStatus(), message.getMessage());
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getServerDateTime() {
        return serverDateTime;
    }
}
