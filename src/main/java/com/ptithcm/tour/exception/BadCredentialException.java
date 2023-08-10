package com.ptithcm.tour.exception;

public class BadCredentialException extends RuntimeException {
    private String message;

    public BadCredentialException() {
    }

    public BadCredentialException(String message) {
        super(message);
        this.message = message;
    }
}
