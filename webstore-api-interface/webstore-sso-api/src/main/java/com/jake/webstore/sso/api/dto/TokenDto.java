package com.jake.webstore.sso.api.dto;

import com.jake.webstore.domain.domain.Token;
import com.jake.webstore.domain.dto.BaseDto;
import lombok.Data;

@Data
public class TokenDto implements BaseDto {
    private int id;
    private Token token;
    private Token refreshToken;
}
