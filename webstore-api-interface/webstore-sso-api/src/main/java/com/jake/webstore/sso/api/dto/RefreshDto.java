package com.jake.webstore.sso.api.dto;

import lombok.Builder;

@Builder
public record RefreshDto(String refreshToken) {
}
