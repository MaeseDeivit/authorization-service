package com.sparda.authorizationservice.authorizationservice.application.rest;

import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionCommand;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.create.CreatePermissionResponse;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.input.PermissionApplicationService;
import com.sparda.authorizationservice.common.application.response.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/permissions")
@Slf4j
public class PermissionController {
    private final PermissionApplicationService permissionApplicationService;

    public PermissionController(PermissionApplicationService permissionApplicationService) {
        this.permissionApplicationService = permissionApplicationService;
    }


    @PostMapping
    public GlobalResponse<CreatePermissionResponse> createPermission(@RequestBody CreatePermissionCommand createPermissionCommand) {
        log.info("Creating Permission with id: {}", createPermissionCommand.getPermissionId());
        CreatePermissionResponse createPermissionResponse = this.permissionApplicationService.createPermission(createPermissionCommand);
        log.info("Permission created with id: {}", createPermissionCommand.getPermissionId());
        return new GlobalResponse(createPermissionResponse, HttpStatus.CREATED);
    }

    @PostMapping(value="/{permissionId}")
    public GlobalResponse<CreatePermissionResponse> createPermissionIdByPath(@PathVariable UUID permissionId, @RequestBody CreatePermissionCommand createPermissionCommandWithoutPermissionId) {
      CreatePermissionCommand createPermissionCommand = new CreatePermissionCommand(permissionId,createPermissionCommandWithoutPermissionId.getPermissionName());
        log.info("Creating Permission with id: {}", permissionId);
        CreatePermissionResponse createPermissionResponse = this.permissionApplicationService.createPermission(createPermissionCommand);
        log.info("Permission created with id: {}", permissionId);
        return new GlobalResponse(createPermissionResponse, HttpStatus.CREATED);
    }
}
