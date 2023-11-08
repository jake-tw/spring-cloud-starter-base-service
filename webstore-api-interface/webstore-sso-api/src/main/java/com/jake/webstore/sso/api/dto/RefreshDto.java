package com.jake.webstore.sso.api.dto;

import com.jake.webstore.domain.dto.BaseDto;
import lombok.Data;

@Data
public class RefreshDto implements BaseDto {
    private String refreshToken;
}
