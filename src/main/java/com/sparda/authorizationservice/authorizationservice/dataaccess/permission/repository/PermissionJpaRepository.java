package com.sparda.authorizationservice.authorizationservice.dataaccess.permission.repository;

import com.sparda.authorizationservice.authorizationservice.dataaccess.permission.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PermissionJpaRepository extends JpaRepository<PermissionEntity, UUID> {
    Optional<PermissionEntity> findByName(String name);
}
