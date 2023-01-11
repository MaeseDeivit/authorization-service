package com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.input;

import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionCommand;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionResponse;

import javax.validation.Valid;


public interface PermissionApplicationService {
    CreatePermissionResponse createPermission(@Valid CreatePermissionCommand createPermissionCommand);

}
