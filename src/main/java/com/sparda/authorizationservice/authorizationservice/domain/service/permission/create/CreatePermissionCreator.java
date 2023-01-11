package com.sparda.authorizationservice.authorizationservice.domain.service.permission.create;

import com.sparda.authorizationservice.authorizationservice.domain.core.PermissionDomainService;
import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.event.PermissionCreatedEvent;
import com.sparda.authorizationservice.authorizationservice.domain.core.exception.PermissionAlreadyExistsException;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionId;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionName;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.mapper.PermissionDataMapper;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.output.repositoy.PermissionCommandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Slf4j
@Service
public class CreatePermissionCreator {
    private final PermissionCommandRepository permissionCommandRepository;
    private final PermissionDataMapper permissionDataMapper;
    private final PermissionDomainService permissionDomainService;

    public CreatePermissionCreator(PermissionCommandRepository permissionCommandRepository, PermissionDataMapper permissionDataMapper, PermissionDomainService permissionDomainService) {
        this.permissionCommandRepository = permissionCommandRepository;
        this.permissionDataMapper = permissionDataMapper;
        this.permissionDomainService = permissionDomainService;
    }
    public PermissionCreatedEvent createPermission(CreatePermissionCommand createPermissionCommand){
        checkAvailabilityPermission(createPermissionCommand);

        Permission permission = permissionDataMapper.createPermissionCommandToPermission(createPermissionCommand);

        PermissionCreatedEvent permissionCreatedEvent = permissionDomainService.validateAndInitiatePermission(permission);
        permissionCommandRepository.save(permission);
        return permissionCreatedEvent;
    }

    private void checkAvailabilityPermission(CreatePermissionCommand createPermissionCommand){
        Optional<Permission> permissionByIdResult = permissionCommandRepository.findById(new PermissionId(createPermissionCommand.getPermissionId()));

        if (!permissionByIdResult.isEmpty()){
            throw new PermissionAlreadyExistsException(createPermissionCommand.getPermissionId().toString());
        }

        Optional<Permission> permissionByNameResult = permissionCommandRepository.findByName(new PermissionName(createPermissionCommand.getPermissionName()));

        if (!permissionByNameResult.isEmpty()){
            throw new PermissionAlreadyExistsException(createPermissionCommand.getPermissionName());
        }

    }
}
