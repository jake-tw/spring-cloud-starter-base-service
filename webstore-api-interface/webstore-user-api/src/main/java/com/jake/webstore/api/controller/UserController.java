package com.jake.webstore.api.controller;

import com.jake.webstore.api.dto.User;
import com.jake.webstore.utils.dto.CommonResult;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
public interface UserController {

    @GetMapping()
    CommonResult<User> listUser();

    @GetMapping("/{id}")
    CommonResult<User> getUser(@PathVariable("id") int id);

    @PutMapping("/{id}")
    CommonResult<User> updateUser(@PathVariable("id") int id, @RequestBody() User user);

    @PostMapping()
    CommonResult<User> createUser(@RequestBody() User user);

    @DeleteMapping("/{id}")
    CommonResult<User> deleteUser(@PathVariable("id") int id);
}
