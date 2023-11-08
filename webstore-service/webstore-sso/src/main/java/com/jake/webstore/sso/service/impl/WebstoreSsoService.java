package com.jake.webstore.sso.service.impl;

import com.jake.webstore.domain.domain.Token;
import com.jake.webstore.domain.enums.TokenType;
import com.jake.webstore.sso.service.SsoService;

public class WebstoreSsoService implements SsoService {

    @Override
    public Token register(String username, String email, String password) {
        return null;
    }

    @Override
    public Token login(String username, String password) {
        return null;
    }

    @Override
    public Token createToken(TokenType type, int id) {
        return null;
    }

    @Override
    public String getSalt(String username) {
        return null;
    }

    @Override
    public String putSalt(String username) {
        return null;
    }

    @Override
    public Token refresh(String refreshToken) {
        return null;
    }
}
