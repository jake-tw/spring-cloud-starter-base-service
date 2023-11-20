package com.jake.webstore.sso.service.impl;

import com.jake.webstore.cloud.base.component.RedisService;
import com.jake.webstore.cloud.base.domain.Token;
import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.enums.TokenType;
import com.jake.webstore.cloud.base.exception.WebstoreException;
import com.jake.webstore.cloud.base.utils.ConstantUtil;
import com.jake.webstore.cloud.base.utils.JwtTokenUtil;
import com.jake.webstore.sso.entity.User;
import com.jake.webstore.sso.repository.UserRepository;
import com.jake.webstore.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class WebstoreSsoService implements SsoService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisService redisService;

    @Override
    public Token register(String username, String email, String password) {
        boolean isExists = userRepository.existsByUsername(username);
        if (isExists) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        String salt = getUserSaltKey(username);
        boolean isTimeout = !StringUtils.hasText(salt);
        if (isTimeout) {
            throw new WebstoreException(ResultType.REQUEST_TIMEOUT);
        }

        userRepository.save(new User() {{
            setUsername(username);
            setEmail(email);
            setPassword(passwordEncoder.encode(password));
            setSalt(salt);
        }});

        return createToken(TokenType.ACCESS, username);
    }

    @Override
    public Token login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new WebstoreException(ResultType.USER_NOT_EXISTS);
        }
        boolean isValid = passwordEncoder.matches(password, user.getPassword());
        if (!isValid) {
            throw new WebstoreException(ResultType.USER_LOGIN_ERROR);
        }
        return createToken(TokenType.ACCESS, username);
    }

    @Override
    public Token createToken(TokenType type, String username) {
        String token = JwtTokenUtil.generateToken(type, username);
        Date date = JwtTokenUtil.getExpirationDateFromToken(token);
        return Token.builder()
                .username(username)
                .type(type)
                .prefix(ConstantUtil.Token.TOKEN_PREFIX)
                .token(token)
                .timeout(date.toInstant().getEpochSecond())
                .build();
    }

    @Override
    public String createSalt(String username) {
        if (StringUtils.hasText(redisService.get(getUserSaltKey(username)))) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        String salt = UUID.randomUUID().toString();
        redisService.set(getUserSaltKey(username), salt, ConstantUtil.SALT_RESERVE_SECONDS);
        return salt;
    }

    @Override
    public void deleteSalt(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        boolean isDeleted = redisService.delete(getUserSaltKey(username));
        if (!isDeleted) {
            throw new WebstoreException(ResultType.NOT_FOUND);
        }
    }

    @Override
    public String getSalt(String username) {
        String salt = redisService.get(getUserSaltKey(username));
        if (StringUtils.hasText(salt)) {
            return salt;
        }

        User user = userRepository.findByUsername(username);
        if (user != null) {
            salt = user.getSalt();
            redisService.set(getUserSaltKey(username), salt);
        }
        return salt;
    }

    @Override
    public Token refresh(String refreshToken) {
        // TODO  validation
        return null;
    }

    private String getUserSaltKey(String username) {
        return redisService.get(ConstantUtil.Redis.Prefix.USER_SALT + username);
    }
}
