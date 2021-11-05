package com.mulmul.todo.post.dto.request;

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
