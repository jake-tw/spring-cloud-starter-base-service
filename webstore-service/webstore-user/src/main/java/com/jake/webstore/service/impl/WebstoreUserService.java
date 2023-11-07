package com.jake.webstore.service.impl;

import com.jake.webstore.common.api.domain.Token;
import com.jake.webstore.common.api.domain.User;
import com.jake.webstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebstoreUserService implements UserService {

    @Override
    public Token login(String username, String password) {
        return null;
    }

    @Override
    public String getSalt(String username) {
        return null;
    }

    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User updateUser(int id, User user) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(int id) {
        return null;
    }
}
