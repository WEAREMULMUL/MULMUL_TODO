package com.mulmul.todo.post.dto.bundle;

public class PostCreateBundle {
    private final String content;

    public PostCreateBundle(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
