package com.osckorea.openmsa.nexus.webhook.audit.dto.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AuditAttributes {
    @Schema(example = "TestUser")
    private String id;

    @Schema(example = "TestName")
    private String name;

    @Schema(example = "example@example.com")
    private String enmai;

    @Schema(example = "default")
    private String source;

    @Schema(example = "active")
    private String status;

    @Schema(example = "nx-admin, nx-anonymous")
    private String roles;
}
