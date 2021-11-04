package com.mulmul.todo.dto.bundle;

public class PostCreateBundle {
    private final String title;
    private final String content;

    public PostCreateBundle(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
