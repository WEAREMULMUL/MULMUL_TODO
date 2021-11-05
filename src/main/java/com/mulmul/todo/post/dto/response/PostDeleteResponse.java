package com.mulmul.todo.post.dto.response;

public class PostDeleteResponse {
    private final Long id;
    private final String title;

    public PostDeleteResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
