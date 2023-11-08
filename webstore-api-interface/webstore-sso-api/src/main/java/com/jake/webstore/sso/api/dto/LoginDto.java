package com.jake.webstore.sso.api.dto;

import com.jake.webstore.domain.dto.BaseDto;
import lombok.Data;

@Data
public class LoginDto implements BaseDto {
    private String username;
    private String email;
    private String password;
}
