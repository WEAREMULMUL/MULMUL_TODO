package com.mulmul.todo.post.dto.request;

import javax.validation.constraints.Pattern;

public class PostUpdateRequest {
    @Pattern(regexp = "^.{1,25}$", message = "제목은 1 ~ 25자 이어야 합니다.")
    private String title;
    private String content;

    protected PostUpdateRequest() {
    }

    public PostUpdateRequest(String title, String content) {
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
