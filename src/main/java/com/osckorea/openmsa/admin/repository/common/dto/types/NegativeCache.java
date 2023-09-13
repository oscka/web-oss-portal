package com.osckorea.openmsa.admin.repository.common.dto.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NegativeCache {
    private Boolean enabled;
    private Integer timeToLive;
}