package com.jake.webstore.api.dto;

import com.jake.webstore.common.api.dto.BaseDto;
import lombok.Data;

@Data
public class LoginReq implements BaseDto {
    private String username;
    private String password;
}
