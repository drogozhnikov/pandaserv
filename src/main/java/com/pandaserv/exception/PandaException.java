package com.pandaserv.exception;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

@Getter
public class PandaException extends RuntimeException {

    private final String message;
    private final HttpStatus status;
    private Exception cause;

    public PandaException(String message, HttpStatus status) {
        super();
        this.status = status;
        this.message = message;
    }

    public PandaException(String message, Exception cause, HttpStatus status) {
        super();
        this.cause = cause;
        this.status = status;
        this.message = message;
    }

    public PandaException(Exception cause, HttpStatus status) {
        super();
        this.status = status;
        this.cause = cause;
        this.message = StringUtils.EMPTY;
    }
}
