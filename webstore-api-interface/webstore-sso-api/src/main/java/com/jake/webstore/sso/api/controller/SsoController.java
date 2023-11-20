package com.jake.webstore.sso.api.controller;

import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.RefreshDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.sso.api.dto.SaltDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sso")
public interface SsoController {

    @PostMapping("/register")
    CommonResult<TokenDto> register(@RequestBody LoginDto dto);

    @PostMapping("/login")
    CommonResult<TokenDto> login(@RequestBody LoginDto dto);

    @PostMapping("/refresh")
    CommonResult<TokenDto> refresh(@RequestBody RefreshDto dto);

    @PostMapping("/salt/{username}")
    CommonResult<SaltDto> createSalt(@PathVariable("username") String username);

    @DeleteMapping("/salt/{username}")
    CommonResult<?> deleteSalt(@PathVariable("username") String username);

    @GetMapping("/salt/{username}")
    CommonResult<SaltDto> getSalt(@PathVariable("username") String username);
}
