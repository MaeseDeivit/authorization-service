package com.sparda.authorizationservice.common.domain.core.response;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public abstract class GlobalResponse<T> {
    @NotNull
    private final String message;
    @Null
    private final T result;

    protected GlobalResponse(String message, T result) {
        this.message = message;
        this.result = result;
    }
}
