package com.mulmul.todo.dto.bundle;

import com.mulmul.todo.domain.vo.Status;

public class PostStatusChangeBundle {
    private final Long id;
    private final Status status;

    public PostStatusChangeBundle(Long id, String status) {
        this.id = id;
        this.status = Status.of(status);
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
