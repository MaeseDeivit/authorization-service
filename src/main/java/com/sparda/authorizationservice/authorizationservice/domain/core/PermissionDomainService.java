package com.sparda.authorizationservice.authorizationservice.domain.core;


import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.event.PermissionCreatedEvent;

public interface PermissionDomainService {
    PermissionCreatedEvent validateAndInitiatePermission(Permission permission);

}
