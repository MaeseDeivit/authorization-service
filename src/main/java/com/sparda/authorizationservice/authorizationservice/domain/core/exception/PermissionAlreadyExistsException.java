package com.sparda.authorizationservice.authorizationservice.domain.core.exception;

import com.sparda.authorizationservice.common.domain.core.exception.DomainException;

public class PermissionAlreadyExistsException extends DomainException {
    private static String errorCode="100";

    public PermissionAlreadyExistsException(String permission) {
        super("Permission: " + permission + " already exist.");
    }

    public static String getErrorCode() {
        return errorCode;
    }
}
