package com.sparda.authorizationservice.authorizationservice.dataaccess.permission.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name = "permissions")
@Entity
public class PermissionEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique=true)
    private String name;

    public PermissionEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
