package com.jake.webstore.sso.service;

import com.jake.webstore.domain.domain.Token;
import com.jake.webstore.domain.enums.TokenType;

public interface SsoService {
    Token register(String username, String email, String password);

    Token login(String username, String password);

    Token createToken(TokenType type, int id);

    String getSalt(String username);

    String putSalt(String username);

    Token refresh(String refreshToken);
}
