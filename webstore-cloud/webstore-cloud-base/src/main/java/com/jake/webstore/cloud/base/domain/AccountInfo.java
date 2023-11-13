package com.jake.webstore.cloud.base.domain;

import com.jake.webstore.cloud.base.enums.RoleType;
import lombok.Builder;

@Builder
public record AccountInfo(RoleType role, boolean isActive) {
}
