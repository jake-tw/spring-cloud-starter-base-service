package com.jake.webstore.sso.api.dto;

import lombok.Builder;

@Builder
public record SaltDto(String username, String slat) {
}
