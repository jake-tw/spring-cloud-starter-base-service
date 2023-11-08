package com.jake.webstore.sso.api.controller;


import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.RefreshDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import com.jake.webstore.domain.dto.CommonResult;
import com.jake.webstore.sso.api.dto.SaltDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sso")
public interface SsoController {

    @PostMapping("/register")
    CommonResult<TokenDto> register(@RequestBody() LoginDto dto);

    @PostMapping("/login")
    CommonResult<TokenDto> login(@RequestBody() LoginDto dto);

    @PostMapping("/refresh")
    CommonResult<TokenDto> refresh(@RequestBody() RefreshDto dto);

    @GetMapping("/salt/{username}")
    CommonResult<SaltDto> getSalt(@PathVariable("username") String username);

    @PutMapping("/salt/{username}")
    CommonResult<SaltDto> putSalt(@PathVariable("username") String username);
}
