package com.sparda.authorizationservice.authorizationservice.domain.core.event;

import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.common.domain.core.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class PermissionEvent implements DomainEvent<Permission> {
    private final Permission permission;
    private final ZonedDateTime createdAt;

    public PermissionEvent(Permission permission, ZonedDateTime createdAt) {
        this.permission = permission;
        this.createdAt = createdAt;
    }

    public Permission getPermission() {
        return permission;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
