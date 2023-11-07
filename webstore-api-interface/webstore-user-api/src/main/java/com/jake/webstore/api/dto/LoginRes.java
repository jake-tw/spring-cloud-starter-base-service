package com.jake.webstore.api.dto;

import com.jake.webstore.common.api.domain.Token;
import com.jake.webstore.common.api.dto.BaseDto;
import lombok.Data;

@Data
public class LoginRes implements BaseDto {
    private int id;
    private Token token;
}
