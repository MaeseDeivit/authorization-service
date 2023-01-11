package com.sparda.authorizationservice.authorizationservice.domain.core.valueobject;

import com.sparda.authorizationservice.common.domain.core.valueobject.BaseId;

import java.util.UUID;

public class PermissionId extends BaseId<UUID> {
    public PermissionId(UUID value) {
        super(value);
    }
}
