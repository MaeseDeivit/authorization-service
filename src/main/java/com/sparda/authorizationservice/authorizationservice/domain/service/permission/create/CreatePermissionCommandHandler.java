package com.sparda.authorizationservice.authorizationservice.domain.service.permission.create;

import com.sparda.authorizationservice.authorizationservice.domain.core.event.PermissionCreatedEvent;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.mapper.PermissionDataMapper;
import com.sparda.authorizationservice.common.domain.service.command.CommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CreatePermissionCommandHandler implements CommandHandler {
    private final CreatePermissionCreator createPermissionCreator;
    private final PermissionDataMapper permissionDataMapper;

    public CreatePermissionCommandHandler(CreatePermissionCreator createPermissionCreator, PermissionDataMapper permissionDataMapper) {
        this.createPermissionCreator = createPermissionCreator;
        this.permissionDataMapper = permissionDataMapper;
    }

    @Transactional
    public CreatePermissionResponse createPermission(CreatePermissionCommand createPermissionCommand){

        PermissionCreatedEvent permissionCreatedEvent = createPermissionCreator.createPermission(createPermissionCommand);
        CreatePermissionResponse createPermissionResponse = permissionDataMapper.PermissionToCreatePermissionResponse(permissionCreatedEvent.getPermission());
        return createPermissionResponse;
    }
}
