package com.sparda.authorizationservice.authorizationservice.domain.service.permission.create;

import lombok.Getter;

@Getter
public class CreatePermissionResponse{

    private final String message;
    private final String result;

    public CreatePermissionResponse(String message, String result) {
        this.message = message;
        this.result = result;
    }
}
