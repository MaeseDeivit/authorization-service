package com.sparda.authorizationservice.authorizationservice.domain.core.exception;


import com.sparda.authorizationservice.common.domain.core.exception.DomainException;

public class PermissionNotFoundException extends DomainException {
    private static String errorCode="101";

    public PermissionNotFoundException(String permission) {
        super("Permission: " + permission + " not found.");
    }

    public static String getErrorCode() {
        return errorCode;
    }
}
