package com.one9.exception;

public class CustomerException extends Exception{
    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }
}
