package com.jake.webstore.cloud.base.utils;

import com.jake.webstore.cloud.base.domain.User;
import com.jake.webstore.cloud.base.enums.RoleType;
import com.jake.webstore.cloud.base.enums.TokenType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil {
    private static final SecretKey secretKey;
    private static final JwtParser jwtParser;

    static {
        String key = "CanUseSpringComponentInjectValueInsteadThisKey";
        secretKey = Keys.hmacShaKeyFor(key.getBytes());
        jwtParser = Jwts.parser().verifyWith(secretKey).build();
    }

    public static String generateToken(TokenType type, String username) {
        return generateToken(type, username, Collections.emptyMap());
    }

    public static String generateToken(TokenType type, String username, Map<String, String> additional) {
        int timeout = type == TokenType.ACCESS ? ConstantUtil.Token.ACCESS_TOKEN_TIMEOUT_SECONDS : ConstantUtil.Token.REFRESH_TOKEN_TIMEOUT_SECONDS;
        long expirationMillis = Instant.now().plusSeconds(timeout).getEpochSecond() * 1000;

        Claims claims = Jwts.claims()
                .subject(username)
                .issuer("webstore.jake.com")
                .issuedAt(new Date())
                .expiration(new Date(expirationMillis))
                .add("role", RoleType.ADMIN.name())
                .add("type", type)
                .add(additional)
                .build();

        return Jwts.builder().claims(claims).signWith(secretKey).compact();
    }


    public static boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public static String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public static Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(parseToken(token));
    }


    public static Claims parseToken(String token) {
        return jwtParser.parseSignedClaims(token).getPayload();
    }
}
