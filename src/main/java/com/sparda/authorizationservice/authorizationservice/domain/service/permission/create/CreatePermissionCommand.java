package com.sparda.authorizationservice.authorizationservice.domain.service.permission.create;

import com.sparda.authorizationservice.common.domain.service.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

    @Getter
    @Builder
    @AllArgsConstructor
    public class CreatePermissionCommand implements Command {
        private final UUID permissionId;
        @NotNull
        private final String permissionName;
    }

