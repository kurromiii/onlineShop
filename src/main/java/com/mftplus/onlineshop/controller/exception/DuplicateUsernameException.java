package com.mftplus.onlineshop.controller.exception;

public class DuplicateUsernameException extends Exception {
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
