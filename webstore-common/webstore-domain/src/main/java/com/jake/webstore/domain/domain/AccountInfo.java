package com.jake.webstore.domain.domain;

import com.jake.webstore.domain.enums.RoleType;
import lombok.Data;

@Data
public class AccountInfo {
    private RoleType role;
    private boolean isActive;
}
