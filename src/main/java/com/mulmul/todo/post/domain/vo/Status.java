package com.mulmul.todo.post.domain.vo;

import com.mulmul.todo.error.exception.PostStatusException;

import java.util.Arrays;

public enum Status {
    COMPLETED("완료"),
    PROCEEDING("진행중");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public static Status of(String inputStatus) {
        return Arrays.stream(Status.values())
                .filter(s -> inputStatus.equals(s.status))
                .findAny()
                .orElseThrow(PostStatusException::new);
    }
}
