package com.jake.webstore.sso.controller;

import com.jake.webstore.common.api.dto.CommonResult;
import com.jake.webstore.sso.api.controller.AuthController;
import com.jake.webstore.sso.api.dto.LoginReq;
import com.jake.webstore.sso.api.dto.LoginRes;
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
    public CommonResult<LoginRes> auth(LoginReq req) {
        return null;
    }
}
