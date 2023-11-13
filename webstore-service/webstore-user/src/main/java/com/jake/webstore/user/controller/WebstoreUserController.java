package com.jake.webstore.user.controller;

import com.jake.webstore.user.api.controller.UserController;
import com.jake.webstore.cloud.base.domain.User;
import com.jake.webstore.user.api.dto.*;
import com.jake.webstore.user.service.UserService;
import com.jake.webstore.cloud.base.dto.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebstoreUserController implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public CommonResult<UserListDto> listUser() {
        List<User> userList = userService.listUser();
        return CommonResult.success(UserListDto.builder()
                .userList(userList)
                .build());
    }

    @Override
    public CommonResult<UserDto> getUser(int id) {
        User user = userService.getUser(id);
        return CommonResult.success(UserDto.builder()
                .user(user)
                .build());
    }

    @Override
    public CommonResult<UserDto> updateUser(int id, UserDto dto) {
        User user = userService.updateUser(id, dto.user());
        return CommonResult.success(UserDto.builder()
                .user(user)
                .build());
    }

    @Override
    public CommonResult<UserDto> createUser(UserDto dto) {
        User user = userService.createUser(dto.user());
        return CommonResult.success(UserDto.builder()
                .user(user)
                .build());
    }

    @Override
    public CommonResult<UserDto> deleteUser(int id) {
        User user = userService.deleteUser(id);
        return CommonResult.success(UserDto.builder()
                .user(user)
                .build());
    }
}
