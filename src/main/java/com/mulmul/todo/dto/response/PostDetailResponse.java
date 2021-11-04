package com.mulmul.todo.dto.response;

import com.mulmul.todo.domain.vo.Status;

public class PostDetailResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String status;

    public PostDetailResponse(Long id, String title, String content, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status.name();
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

    public String getStatus() {
        return status;
    }
}
