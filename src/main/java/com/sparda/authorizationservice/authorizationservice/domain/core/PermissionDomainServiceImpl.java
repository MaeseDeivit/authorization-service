package com.sparda.authorizationservice.authorizationservice.domain.core;

import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.event.PermissionCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@Service
public class PermissionDomainServiceImpl implements PermissionDomainService{
    @Override
    public PermissionCreatedEvent validateAndInitiatePermission(Permission permission) {
        return new PermissionCreatedEvent(permission, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
