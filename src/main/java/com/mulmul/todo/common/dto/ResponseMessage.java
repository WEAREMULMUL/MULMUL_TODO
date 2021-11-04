package com.mulmul.todo.common.dto;

import org.springframework.http.HttpStatus;

public enum ResponseMessage {
    POST_CREATE_SUCCESS(HttpStatus.CREATED, "게시물 생성"),
    POST_READ_SUCCESS(HttpStatus.OK, "게시물 조회 성공"),
    POST_READ_ALL_SUCCESS(HttpStatus.OK, "게시물 전체 조회 성공"),
    POST_UPDATE_SUCCESS(HttpStatus.OK, "게시물 수정 성공");

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
