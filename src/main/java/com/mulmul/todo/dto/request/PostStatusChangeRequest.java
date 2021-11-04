package com.mulmul.todo.dto.request;

import javax.validation.constraints.NotBlank;

public class PostStatusChangeRequest {
    private String status;

    protected PostStatusChangeRequest() {
    }

    public PostStatusChangeRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
