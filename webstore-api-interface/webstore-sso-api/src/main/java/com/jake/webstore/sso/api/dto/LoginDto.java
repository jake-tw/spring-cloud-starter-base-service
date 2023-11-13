package com.jake.webstore.sso.api.dto;

import lombok.Builder;

@Builder
public record LoginDto(String username, String email, String password) {
}
