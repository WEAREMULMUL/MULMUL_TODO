package com.mulmul.todo.post.dto.request;

import javax.validation.constraints.Pattern;

public class PostUpdateRequest {
    private String content;

    protected PostUpdateRequest() {
    }

    public PostUpdateRequest( String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
