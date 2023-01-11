package com.sparda.authorizationservice.authorizationservice.domain.core.entity;

import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionId;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionName;
import com.sparda.authorizationservice.common.domain.core.entity.BaseEntity;

import java.time.ZonedDateTime;

public class Permission extends BaseEntity<PermissionId> {
    private final PermissionName name;
    private final ZonedDateTime createdAt;

    public Permission(PermissionId id,PermissionName name, ZonedDateTime createdAt) {
        setId(id);
        this.name = name;
        this.createdAt = createdAt;
    }

    public PermissionName getName() {
        return name;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + getId().getValue() +
                ", name=" + name.getValue() +
                ", createdAt=" + createdAt +
                '}';
    }
}
