package com.mulmul.todo.error.exception;

import com.mulmul.todo.error.ErrorMessage;

public class NotExitsPostException extends BusinessException {
    public NotExitsPostException() {
        super(ErrorMessage.NOT_EXITS_POST);
    }
}
