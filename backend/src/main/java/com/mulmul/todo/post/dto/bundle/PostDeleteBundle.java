package com.mulmul.todo.post.dto.bundle;

public class PostDeleteBundle {
    private final Long id;

    public PostDeleteBundle(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
