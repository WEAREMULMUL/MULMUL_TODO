package com.mulmul.todo.error.exception;

import com.mulmul.todo.error.ErrorMessage;

public class PostStatusException extends BusinessException {
    public PostStatusException() {
        super(ErrorMessage.INVALID_STATUS_INPUT);
    }
}
