package com.jake.webstore.api.controller;

import com.jake.webstore.api.dto.User;
import com.jake.webstore.utils.dto.CommonResponse;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
public interface UserController {

    @GetMapping()
    CommonResponse<User> listUser();

    @GetMapping("/{id}")
    CommonResponse<User> getUser(@PathVariable("id") int id);

    @PutMapping("/{id}")
    CommonResponse<User> updateUser(@PathVariable("id") int id, @RequestBody() User user);

    @PostMapping()
    CommonResponse<User> createUser(@RequestBody() User user);

    @DeleteMapping("/{id}")
    CommonResponse<User> deleteUser(@PathVariable("id") int id);
}
