package com.jake.webstore.user.service;

import com.jake.webstore.cloud.base.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    User getUser(int id);

    User updateUser(int id, User user);

    User createUser(User user);

    User deleteUser(int id);
}
