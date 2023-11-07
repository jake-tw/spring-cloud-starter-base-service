package com.jake.webstore.sso.api.controller;

import com.jake.webstore.common.api.dto.CommonResult;
import com.jake.webstore.sso.api.dto.LoginDto;
import com.jake.webstore.sso.api.dto.TokenDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {

    CommonResult<TokenDto> auth(@RequestBody() LoginDto dto);
}
