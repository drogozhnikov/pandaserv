package com.pandaserv.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PandaException extends RuntimeException {

    private final String message;
    private final HttpStatus status;

    public PandaException(String message, HttpStatus status) {
        super();
        this.status = status;
        this.message = message;
    }

    public PandaException(HttpStatus status) {
        super();
        this.status = status;
        this.message = "";
    }
}
