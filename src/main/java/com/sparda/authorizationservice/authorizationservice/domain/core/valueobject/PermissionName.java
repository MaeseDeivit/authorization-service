package com.sparda.authorizationservice.authorizationservice.domain.core.valueobject;

public class PermissionName {
    private final String name;

    public PermissionName(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
