package com.mulmul.todo.common.dto;

import org.springframework.hateoas.EntityModel;

import java.time.LocalDateTime;

public class ResponseDto<T> {
    private final int status;
    private final String message;
    private final LocalDateTime serverDateTime;
    private final EntityModel<T> data;

    private ResponseDto(ResponseMessage message, EntityModel<T> entityModel) {
        this.status = message.getStatus().value();
        this.message = message.name();
        this.serverDateTime = LocalDateTime.now();
        this.data = entityModel;
    }

    public static <T> ResponseDto<T> of(ResponseMessage message, EntityModel<T> model) {
        return new ResponseDto<>(message, model);
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

    public EntityModel<T> getData() {
        return data;
    }
}