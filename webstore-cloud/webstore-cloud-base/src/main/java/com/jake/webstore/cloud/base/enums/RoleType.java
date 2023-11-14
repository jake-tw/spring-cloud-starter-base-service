package com.jake.webstore.cloud.base.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    SUPER_ADMIN, ADMIN, USER, GUEST,
    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
