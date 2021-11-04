package com.mulmul.todo.common.dto;

import org.springframework.http.HttpStatus;

public enum ResponseMessage {
    POST_CREATE_SUCCESS(HttpStatus.CREATED, "게시물 생성");

    private final HttpStatus status;
    private final String message;

    ResponseMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
