package com.jake.webstore.sso.controller;

import com.jake.webstore.domain.dto.CommonResult;
import com.jake.webstore.sso.api.controller.AuthController;
import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.sso.service.AuthService;
import com.jake.webstore.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController implements AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SsoService ssoService;

    @PostMapping()
    @Override
    public CommonResult<TokenDto> auth(LoginDto dto) {
        return null;
    }
}
