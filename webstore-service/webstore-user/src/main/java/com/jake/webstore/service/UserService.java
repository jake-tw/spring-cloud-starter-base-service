package com.jake.webstore.service;

import com.jake.webstore.common.api.utils.domain.Token;
import com.jake.webstore.common.api.utils.domain.User;

import java.util.List;

public interface UserService {

    Token login(String username, String password);

    String getSalt(String username);

    List<User> listUser();

    User getUser(int id);

    User updateUser(int id, User user);

    User createUser(User user);

    User deleteUser(int id);
}
