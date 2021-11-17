package com.mulmul.todo.post.dto.request;

import javax.validation.constraints.Pattern;

public class PostCreateRequest {
    private String content;

    protected PostCreateRequest() {
    }

    public PostCreateRequest( String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
