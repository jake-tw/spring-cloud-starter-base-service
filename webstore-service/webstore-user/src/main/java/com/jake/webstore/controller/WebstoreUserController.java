package com.jake.webstore.controller;

import com.jake.webstore.api.controller.UserController;
import com.jake.webstore.api.dto.User;
import com.jake.webstore.service.UserService;
import com.jake.webstore.utils.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebstoreUserController implements UserController {

    @Autowired
    private UserService WebstoreUserService;

    @Override
    public CommonResponse<User> listUser() {
        return CommonResponse.success(new User());
    }

    @Override
    public CommonResponse<User> getUser(int id) {
        return null;
    }

    @Override
    public CommonResponse<User> updateUser(int id, User user) {
        return null;
    }

    @Override
    public CommonResponse<User> createUser(User user) {
        return null;
    }

    @Override
    public CommonResponse<User> deleteUser(int id) {
        return null;
    }
}
