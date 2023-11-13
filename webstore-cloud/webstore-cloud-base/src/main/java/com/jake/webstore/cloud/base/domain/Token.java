package com.jake.webstore.cloud.base.domain;

import com.jake.webstore.cloud.base.enums.TokenType;
import lombok.Builder;

@Builder
public record Token(Long id, TokenType type, String prefix, String token, long timeout) {
}
