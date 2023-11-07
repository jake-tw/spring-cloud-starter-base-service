package com.jake.webstore.sso.api.dto;

import com.jake.webstore.common.api.dto.BaseDto;
import lombok.Data;

@Data
public class LoginReq implements BaseDto {
    private String username;
    private String password;
}
