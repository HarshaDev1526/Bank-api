package com.union.exception;

public class DMICreditServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DMICreditServiceException(String msg) {
        super(msg);
    }
}