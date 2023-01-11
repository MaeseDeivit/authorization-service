package com.sparda.authorizationservice.common.application.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class GlobalResponse<T> extends ResponseEntity<T> {
    public GlobalResponse(HttpStatus status) {
        super(status);
    }

    public GlobalResponse(T body, HttpStatus status) {
        super(body, status);
    }

    public GlobalResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public GlobalResponse(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public GlobalResponse(T body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
