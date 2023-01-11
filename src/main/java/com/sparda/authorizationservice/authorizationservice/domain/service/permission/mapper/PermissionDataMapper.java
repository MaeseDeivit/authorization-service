package com.sparda.authorizationservice.authorizationservice.domain.service.permission.mapper;

import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionId;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionName;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionCommand;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionResponse;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class PermissionDataMapper {
    public Permission createPermissionCommandToPermission(CreatePermissionCommand createPermissionCommand) {
        return new Permission(
                new PermissionId(createPermissionCommand.getPermissionId()),
                new PermissionName(createPermissionCommand.getPermissionName()),
                ZonedDateTime.now(ZoneId.of("UTC"))
        );
    }

    public CreatePermissionResponse PermissionToCreatePermissionResponse(Permission permission) {
        return new CreatePermissionResponse("success", permission.toString());
    }

}