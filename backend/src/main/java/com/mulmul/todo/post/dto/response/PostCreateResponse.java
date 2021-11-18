package com.mulmul.todo.post.dto.response;

import com.mulmul.todo.post.domain.vo.Status;

public class PostCreateResponse {
    private final Long id;
    private final String content;
    private final String status;

    public PostCreateResponse(Long id, String content, Status status) {
        this.id = id;
        this.content = content;
        this.status = status.name();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }
}
