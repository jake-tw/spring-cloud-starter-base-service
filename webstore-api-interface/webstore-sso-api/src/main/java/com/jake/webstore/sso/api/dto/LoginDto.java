package com.jake.webstore.sso.api.dto;

import com.jake.webstore.common.api.dto.BaseDto;
import lombok.Data;

@Data
public class LoginDto implements BaseDto {
    private String username;
    private String password;
}
