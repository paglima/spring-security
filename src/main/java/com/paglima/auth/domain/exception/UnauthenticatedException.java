package com.paglima.auth.domain.exception;

import javax.servlet.ServletException;

public class UnauthenticatedException extends ServletException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}
