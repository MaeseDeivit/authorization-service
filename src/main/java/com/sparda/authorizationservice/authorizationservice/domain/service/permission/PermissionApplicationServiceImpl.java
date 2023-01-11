package com.sparda.authorizationservice.authorizationservice.domain.service.permission;

import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionCommand;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionCommandHandler;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionResponse;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.input.PermissionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PermissionApplicationServiceImpl implements PermissionApplicationService {
    private final CreatePermissionCommandHandler createPermissionCommandHandler;

    public PermissionApplicationServiceImpl(CreatePermissionCommandHandler createPermissionCommandHandler) {
        this.createPermissionCommandHandler = createPermissionCommandHandler;
    }

    @Override
    public CreatePermissionResponse createPermission(CreatePermissionCommand createPermissionCommand) {
        return createPermissionCommandHandler.createPermission(createPermissionCommand);
    }
}
