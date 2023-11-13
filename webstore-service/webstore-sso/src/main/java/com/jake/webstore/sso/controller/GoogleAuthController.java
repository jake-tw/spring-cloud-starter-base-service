package com.jake.webstore.sso.controller;

import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.sso.api.controller.AuthController;
import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.sso.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController implements AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping()
    @Override
    public CommonResult<TokenDto> auth(LoginDto dto) {
        return null;
    }
}
