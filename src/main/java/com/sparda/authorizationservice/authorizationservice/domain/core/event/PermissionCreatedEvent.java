package com.sparda.authorizationservice.authorizationservice.domain.core.event;

import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import java.time.ZonedDateTime;

public class PermissionCreatedEvent extends PermissionEvent {

    public PermissionCreatedEvent(Permission permission, ZonedDateTime createdAt) {

        super(permission, createdAt);
    }

    @Override
    public void fire() {

    }
}
