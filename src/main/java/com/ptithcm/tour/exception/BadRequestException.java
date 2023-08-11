package com.ptithcm.tour.exception;

public class BadRequestException extends RuntimeException {
    private String message;
    public BadRequestException() {}
    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
}
