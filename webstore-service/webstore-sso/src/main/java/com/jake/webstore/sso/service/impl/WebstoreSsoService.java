package com.jake.webstore.sso.service.impl;

import com.jake.webstore.cloud.base.domain.Token;
import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.enums.TokenType;
import com.jake.webstore.cloud.base.exception.WebstoreException;
import com.jake.webstore.cloud.base.utils.ConstantUtil;
import com.jake.webstore.cloud.base.utils.JwtTokenUtil;
import com.jake.webstore.common.redis.utils.RedisUtils;
import com.jake.webstore.sso.entity.User;
import com.jake.webstore.sso.repository.UserRepository;
import com.jake.webstore.sso.service.SsoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class WebstoreSsoService implements SsoService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Token register(String username, String email, String password) {
        boolean isExists = userRepository.existsByUsername(username);
        if (isExists) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        if (!password.matches(ConstantUtil.Regex.HASHED_PASSWORD)) {
            throw new WebstoreException(ResultType.USER_INVALID_PARAM);
        }

        String salt = redisUtils.get(getUserSaltKey(username));
        boolean isTimeout = !StringUtils.hasText(salt);
        if (isTimeout) {
            throw new WebstoreException(ResultType.REQUEST_TIMEOUT);
        }

        User user = new User()
                .setUsername(username)
                .setEmail(email)
                .setPassword(passwordEncoder.encode(password))
                .setSalt(salt);

        userRepository.save(user);
        log.info("[{}] New user registration, username: {}, email: {}", user.getId(), user.getUsername(), user.getEmail());
        return createToken(TokenType.ACCESS, username);
    }

    @Override
    public Token login(String username, String password) {
        // Error messages must be obfuscated to avoid malicious use
        if (!password.matches(ConstantUtil.Regex.HASHED_PASSWORD)) {
            throw new WebstoreException(ResultType.USER_LOGIN_ERROR);
        }

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new WebstoreException(ResultType.USER_LOGIN_ERROR);
        }

        boolean isValid = passwordEncoder.matches(password, user.getPassword());
        if (!isValid) {
            throw new WebstoreException(ResultType.USER_LOGIN_ERROR);
        }
        // TODO store refresh token and make sure the refresh token is unique
        return createToken(TokenType.ACCESS, username);
    }

    @Override
    public Token createToken(TokenType type, String username) {
        String token;
        switch (type) {
            case ACCESS -> token = JwtTokenUtil.generateAccessToken(username);
            case REFRESH -> {
                token = JwtTokenUtil.generateRefreshToken(username);
                // TODO encrypt
                redisUtils.set(ConstantUtil.Redis.Prefix.USER_REFRESH_TOKEN + username, token);
            }
            default -> throw new WebstoreException(ResultType.INTERNAL_SERVER_ERROR);
        }

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
        if (StringUtils.hasText(redisUtils.get(getUserSaltKey(username)))) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        boolean isExists = userRepository.existsByUsername(username);
        if (isExists) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        String salt = UUID.randomUUID().toString();
        redisUtils.set(getUserSaltKey(username), salt, ConstantUtil.Redis.SALT_RESERVE_SECONDS);
        return salt;
    }

    @Override
    public void deleteSalt(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new WebstoreException(ResultType.USER_EXISTS);
        }

        boolean isDeleted = redisUtils.delete(getUserSaltKey(username));
        if (!isDeleted) {
            throw new WebstoreException(ResultType.NOT_FOUND);
        }
    }

    @Override
    public String getSalt(String username) {
        String salt = redisUtils.get(getUserSaltKey(username));
        if (StringUtils.hasText(salt)) {
            return salt;
        }

        User user = userRepository.findByUsername(username);
        if (user != null) {
            salt = user.getSalt();
            redisUtils.set(getUserSaltKey(username), salt);
        }
        return salt;
    }

    @Override
    public Token refresh(String refreshToken) {
        // TODO  validation
        return null;
    }

    @Override
    public void resetPassword(String email) {

    }

    @Override
    public void changePassword(String token, String oldPassword, String newPassword) {

    }

    private String getUserSaltKey(String username) {
        return ConstantUtil.Redis.Prefix.USER_SALT + username;
    }
}
