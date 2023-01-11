package com.sparda.authorizationservice.authorizationservice.dataaccess.permission.adapter;

import com.sparda.authorizationservice.authorizationservice.dataaccess.permission.mapper.PermissionDataAccessMapper;
import com.sparda.authorizationservice.authorizationservice.dataaccess.permission.repository.PermissionJpaRepository;
import com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.output.repositoy.PermissionQueryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PermissionQueryRepositoryImpl implements PermissionQueryRepository {

    private final PermissionJpaRepository permissionJpaRepository;
    private final PermissionDataAccessMapper permissionDataAccessMapper;

    public PermissionQueryRepositoryImpl(PermissionJpaRepository permissionJpaRepository, PermissionDataAccessMapper permissionDataAccessMapper) {
        this.permissionJpaRepository = permissionJpaRepository;
        this.permissionDataAccessMapper = permissionDataAccessMapper;
    }
}
