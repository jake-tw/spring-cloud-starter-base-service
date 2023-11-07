package com.jake.webstore.controller;

import com.jake.webstore.api.controller.UserController;
import com.jake.webstore.api.dto.*;
import com.jake.webstore.common.api.utils.domain.Token;
import com.jake.webstore.common.api.utils.domain.User;
import com.jake.webstore.service.UserService;
import com.jake.webstore.common.api.utils.dto.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebstoreUserController implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public CommonResult<LoginRes> login(LoginReq req) {
        Token token = userService.login(req.getUsername(), req.getPassword());
        return CommonResult.success(new LoginRes() {{
            setToken(token);
        }});
    }

    @Override
    public CommonResult<SaltDto> getSalt(String username) {
        String salt = userService.getSalt(username);
        return CommonResult.success(new SaltDto() {{
            setSlat(salt);
        }});
    }

    @Override
    public CommonResult<UserListDto> listUser() {
        List<User> userList = userService.listUser();
        return CommonResult.success(new UserListDto() {{
            setUserList(userList);
        }});
    }

    @Override
    public CommonResult<UserDto> getUser(int id) {
        User user = userService.getUser(id);
        return CommonResult.success(new UserDto() {{
            setUser(user);
        }});
    }

    @Override
    public CommonResult<UserDto> updateUser(int id, UserDto dto) {
        User user = userService.updateUser(id, dto.getUser());
        return CommonResult.success(new UserDto() {{
            setUser(user);
        }});
    }

    @Override
    public CommonResult<UserDto> createUser(UserDto dto) {
        User user = userService.createUser(dto.getUser());
        return CommonResult.success(new UserDto() {{
            setUser(user);
        }});
    }

    @Override
    public CommonResult<UserDto> deleteUser(int id) {
        User user = userService.deleteUser(id);
        return CommonResult.success(new UserDto() {{
            setUser(user);
        }});
    }
}
