package com.mulmul.todo.domain.vo;

import java.util.Arrays;

public enum Status {
    COMPLETED("완료"),
    PROCEEDING("진행중");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public static Status of(String status) {
        return Arrays.stream(Status.values())
                .filter(s -> s.status.equals(s))
                .findAny()
                .orElseThrow(() -> new RuntimeException("상태값이 이상하다.")); // TODO
    }
}
