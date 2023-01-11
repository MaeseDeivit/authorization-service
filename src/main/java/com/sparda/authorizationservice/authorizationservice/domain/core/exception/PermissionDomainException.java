package com.sparda.authorizationservice.authorizationservice.domain.core.exception;


import com.sparda.authorizationservice.common.domain.core.exception.DomainException;

public class PermissionDomainException extends DomainException {
    public PermissionDomainException(String message) {
        super(message);
    }

    public PermissionDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
