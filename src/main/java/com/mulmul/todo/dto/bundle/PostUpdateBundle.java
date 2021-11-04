package com.mulmul.todo.dto.bundle;

public class PostUpdateBundle {
    private final Long id;
    private final String title;
    private final String content;

    public PostUpdateBundle(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
