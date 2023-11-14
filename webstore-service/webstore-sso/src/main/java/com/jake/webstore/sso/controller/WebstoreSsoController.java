package com.jake.webstore.sso.controller;

import com.jake.webstore.cloud.base.domain.Token;
import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.cloud.base.enums.TokenType;
import com.jake.webstore.sso.api.controller.SsoController;
import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.RefreshDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.sso.api.dto.SaltDto;
import com.jake.webstore.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebstoreSsoController implements SsoController {

    @Autowired
    private SsoService ssoService;

    @Override
    public CommonResult<TokenDto> register(LoginDto dto) {
        Token token = ssoService.register(dto.username(), dto.email(), dto.password());
        Token refreshToken = ssoService.createToken(TokenType.REFRESH, token.id());
        return CommonResult.success(TokenDto.builder()
                .id(token.id())
                .token(token)
                .refreshToken(refreshToken)
                .build());
    }

    @Override
    public CommonResult<TokenDto> login(LoginDto dto) {
        Token token = ssoService.login(StringUtils.hasText(dto.username()) ? dto.username() : dto.email(), dto.password());
        Token refreshToken = ssoService.createToken(TokenType.REFRESH, token.id());
        return CommonResult.success(TokenDto.builder()
                .id(token.id())
                .token(token)
                .refreshToken(refreshToken)
                .build());
    }

    @Override
    public CommonResult<TokenDto> refresh(RefreshDto dto) {
        Token token = ssoService.refresh(dto.refreshToken());
        Token refreshToken = ssoService.createToken(TokenType.REFRESH, token.id());
        return CommonResult.success(TokenDto.builder()
                .id(token.id())
                .token(token)
                .refreshToken(refreshToken)
                .build());
    }

    @Override
    public CommonResult<SaltDto> createSalt(String username) {
        String salt = ssoService.createSalt(username);
        return CommonResult.success(SaltDto.builder()
                .username(username)
                .slat(salt)
                .build());
    }

    @Override
    public CommonResult<SaltDto> getSalt(String username) {
        String salt = ssoService.getSalt(username);
        return CommonResult.success(SaltDto.builder()
                .username(username)
                .slat(salt)
                .build());
    }
}