package com.example.security.exception;

import org.springframework.security.core.AuthenticationException;

public class RefreshTokenException extends AuthenticationException {
    public RefreshTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
