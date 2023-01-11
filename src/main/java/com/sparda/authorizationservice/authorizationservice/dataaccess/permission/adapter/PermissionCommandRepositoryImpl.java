package com.sparda.authorizationservice.authorizationservice.dataaccess.permission.adapter;

import com.sparda.authorizationservice.authorizationservice.dataaccess.permission.mapper.PermissionDataAccessMapper;
import com.sparda.authorizationservice.authorizationservice.dataaccess.permission.repository.PermissionJpaRepository;
import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionId;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionName;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.output.repositoy.PermissionCommandRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PermissionCommandRepositoryImpl implements PermissionCommandRepository {

    private final PermissionJpaRepository permissionJpaRepository;
    private final PermissionDataAccessMapper permissionDataAccessMapper;

    public PermissionCommandRepositoryImpl(PermissionJpaRepository permissionJpaRepository, PermissionDataAccessMapper permissionDataAccessMapper) {
        this.permissionJpaRepository = permissionJpaRepository;
        this.permissionDataAccessMapper = permissionDataAccessMapper;
    }

    @Override
    public Permission save(Permission permission) {
        permissionJpaRepository.save(permissionDataAccessMapper.permissionToPermissionEntity(permission));
        return permission;
    }

    @Override
    public Optional<Permission> findById(PermissionId permissionId) {
        return permissionJpaRepository.findById(permissionId.getValue()).map(permissionDataAccessMapper::permissionEntityToPermission);
    }

    @Override
    public Optional<Permission> findByName(PermissionName permissionName) {
        return permissionJpaRepository.findByName(permissionName.getValue()).map(permissionDataAccessMapper::permissionEntityToPermission);
    }
}
