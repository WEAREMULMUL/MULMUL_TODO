package com.mulmul.todo.post.dto.bundle;

public class PostUpdateBundle {
    private final Long id;
    private final String content;

    public PostUpdateBundle(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
