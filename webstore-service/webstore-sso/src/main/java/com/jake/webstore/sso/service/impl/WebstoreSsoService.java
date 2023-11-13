package com.jake.webstore.sso.service.impl;

import com.jake.webstore.cloud.base.domain.Token;
import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.enums.TokenType;
import com.jake.webstore.cloud.base.exception.BizException;
import com.jake.webstore.sso.entity.User;
import com.jake.webstore.sso.repository.UserRepository;
import com.jake.webstore.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WebstoreSsoService implements SsoService {

    // TODO move to redis
    Map<String, String> salts = new HashMap<>();

    @Autowired
    private UserRepository userRepository;

    @Override
    public Token register(String username, String email, String password) {
        boolean isExists = userRepository.existsByUsername(username);
        if (isExists) {
            throw new BizException(ResultType.USER_EXISTS);
        }

        User user = userRepository.save(User.builder()
                .username(username)
                .email(email)
                .password(password)
                .salt(salts.get(username))
                .build());

        return createToken(TokenType.ACCESS, user.getId());
    }

    @Override
    public Token login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            throw new BizException(ResultType.USER_NOT_EXISTS);
        }

        return createToken(TokenType.ACCESS, user.getId());
    }

    @Override
    public Token createToken(TokenType type, Long id) {
        return Token.builder()
                .id(id)
                .type(type)
                .prefix("temp")
                .token("temp")
                .timeout(123)
                .build();
    }

    @Override
    public String createSalt(String username) {
        if (StringUtils.hasText(salts.get(username))) {
            throw new BizException(ResultType.USER_EXISTS);
        }

        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new BizException(ResultType.USER_EXISTS);
        }

        String salt = UUID.randomUUID().toString();
        salts.put(username, salt);
        return salt;
    }

    @Override
    public String getSalt(String username) {
        String salt = salts.get(username);
        if (StringUtils.hasText(salt)) {
            return salt;
        }

        User user = userRepository.findByUsername(username);
        if (user != null) {
            salt = user.getSalt();
            // TODO use different key from create salt?
            salts.put(username, salt);
        }
        return salt;
    }

    @Override
    public Token refresh(String refreshToken) {
        // TODO  validation
        return null;
    }
}
