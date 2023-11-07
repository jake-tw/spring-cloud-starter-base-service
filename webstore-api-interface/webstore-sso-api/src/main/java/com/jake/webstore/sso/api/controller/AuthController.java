package com.jake.webstore.sso.api.controller;

import com.jake.webstore.common.api.dto.CommonResult;
import com.jake.webstore.sso.api.dto.LoginReq;
import com.jake.webstore.sso.api.dto.LoginRes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface AuthController {

    CommonResult<LoginRes> auth(@RequestBody() LoginReq req);
}
