package com.mulmul.todo.error.exception;

import com.mulmul.todo.error.ErrorMessage;

public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage message) {
        super(message.getMessage());
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
