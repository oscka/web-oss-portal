package com.osckorea.openmsa.admin.nexus.dto.repository.partial;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cleanup {
    @Builder.Default
    private String[] policyNames = new String[0];
}
