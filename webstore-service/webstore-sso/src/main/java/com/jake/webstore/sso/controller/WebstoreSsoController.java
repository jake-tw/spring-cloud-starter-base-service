package com.jake.webstore.sso.controller;

import com.jake.webstore.cloud.base.SubjectUtils;
import com.jake.webstore.domain.domain.Token;
import com.jake.webstore.domain.dto.CommonResult;
import com.jake.webstore.domain.enums.TokenType;
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
        Token token = ssoService.register(dto.getUsername(), dto.getEmail(), dto.getPassword());

        SubjectUtils.Subject subject = SubjectUtils.get();
        Token refreshToken = ssoService.createToken(TokenType.REFRESH, subject.getId());
        return CommonResult.success(new TokenDto() {{
            setId(subject.getId());
            setToken(token);
            setRefreshToken(refreshToken);
        }});
    }

    @Override
    public CommonResult<TokenDto> login(LoginDto dto) {
        Token token = ssoService.login(StringUtils.hasText(dto.getUsername()) ? dto.getUsername() : dto.getEmail(), dto.getPassword());

        SubjectUtils.Subject subject = SubjectUtils.get();
        Token refreshToken = ssoService.createToken(TokenType.REFRESH, subject.getId());
        return CommonResult.success(new TokenDto() {{
            setId(subject.getId());
            setToken(token);
            setRefreshToken(refreshToken);
        }});
    }

    @Override
    public CommonResult<TokenDto> refresh(RefreshDto dto) {
        return null;
    }

    @Override
    public CommonResult<SaltDto> getSalt(String username) {
        return null;
    }

    @Override
    public CommonResult<SaltDto> putSalt(String username) {
        return null;
    }
}