package com.jake.webstore.sso.service;

import com.jake.webstore.cloud.base.domain.Token;
import com.jake.webstore.cloud.base.enums.TokenType;

public interface SsoService {
    Token register(String username, String email, String password);

    Token login(String username, String password);

    Token createToken(TokenType type, Long id);

    String createSalt(String username);

    String getSalt(String username);

    Token refresh(String refreshToken);
}
