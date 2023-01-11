package com.sparda.authorizationservice.authorizationservice.dataaccess.permission.mapper;

import com.sparda.authorizationservice.authorizationservice.dataaccess.permission.entity.PermissionEntity;
import com.sparda.authorizationservice.authorizationservice.domain.core.entity.Permission;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionId;
import com.sparda.authorizationservice.authorizationservice.domain.core.valueobject.PermissionName;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class PermissionDataAccessMapper {

    public PermissionEntity permissionToPermissionEntity(Permission permission) {
        return new PermissionEntity(permission.getId().getValue(),permission.getName().getValue());
    }

    public Permission permissionEntityToPermission(PermissionEntity permissionEntity) {
   return new Permission(new PermissionId(permissionEntity.getId()),new PermissionName(permissionEntity.getName()), ZonedDateTime.now());
    }
}
