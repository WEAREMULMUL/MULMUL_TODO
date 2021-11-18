package com.mulmul.todo.post.dto.response;

public class PostDeleteResponse {
    private final Long id;

    public PostDeleteResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
