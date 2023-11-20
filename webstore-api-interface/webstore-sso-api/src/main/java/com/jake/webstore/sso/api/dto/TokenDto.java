package com.jake.webstore.sso.api.dto;

import com.jake.webstore.cloud.base.domain.Token;
import lombok.Builder;

@Builder
public record TokenDto(Token accessToken, Token refreshToken) {
}
