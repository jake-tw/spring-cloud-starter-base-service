package com.jake.webstore.sso.controller;

import com.jake.webstore.common.api.dto.CommonResult;
import com.jake.webstore.sso.api.controller.SsoController;
import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.sso.api.dto.SaltDto;
import com.jake.webstore.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebstoreSsoController implements SsoController {

    @Autowired
    private SsoService ssoService;

    @Override
    public CommonResult<TokenDto> login(LoginDto dto) {
        return null;
    }

    @Override
    public CommonResult<SaltDto> getSalt(String username) {
        return null;
    }
}