package com.jake.webstore.sso.api.controller;


import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.common.api.dto.CommonResult;
import com.jake.webstore.sso.api.dto.SaltDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sso")
public interface SsoController {

    @PostMapping("/login")
    CommonResult<TokenDto> login(@RequestBody() LoginDto dto);

    @GetMapping("/salt/{username}")
    CommonResult<SaltDto> getSalt(@PathVariable("username") String username);
}
