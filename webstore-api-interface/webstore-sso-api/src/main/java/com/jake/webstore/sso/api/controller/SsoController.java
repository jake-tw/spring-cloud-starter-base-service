package com.jake.webstore.sso.api.controller;


import com.jake.webstore.sso.api.dto.LoginReq;
import com.jake.webstore.sso.api.dto.LoginRes;
import com.jake.webstore.common.api.dto.CommonResult;
import com.jake.webstore.sso.api.dto.SaltDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sso")
public interface SsoController {

    @PostMapping("/login")
    CommonResult<LoginRes> login(@RequestBody() LoginReq req);

    @GetMapping("/salt/{username}")
    CommonResult<SaltDto> getSalt(@PathVariable("username") String username);
}
