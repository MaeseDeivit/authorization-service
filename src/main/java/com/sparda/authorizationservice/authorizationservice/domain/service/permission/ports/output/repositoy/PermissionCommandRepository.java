package com.sparda.authorizationservice.authorizationservice.domain.service.permission.ports.output.repositoy;


import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionId;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionName;

import java.util.Optional;

public interface PermissionCommandRepository {
    Permission save(Permission permission);
    Optional<Permission> findById(PermissionId permissionId);

    Optional<Permission> findByName(PermissionName permissionName);
}
