package com.jake.webstore.controller;

import com.jake.webstore.api.controller.UserController;
import com.jake.webstore.api.dto.User;
import com.jake.webstore.service.UserService;
import com.jake.webstore.utils.dto.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebstoreUserController implements UserController {

    @Autowired
    private UserService WebstoreUserService;

    @Override
    public CommonResult<User> listUser() {
        return CommonResult.success(new User());
    }

    @Override
    public CommonResult<User> getUser(int id) {
        return null;
    }

    @Override
    public CommonResult<User> updateUser(int id, User user) {
        return null;
    }

    @Override
    public CommonResult<User> createUser(User user) {
        return null;
    }

    @Override
    public CommonResult<User> deleteUser(int id) {
        return null;
    }
}
