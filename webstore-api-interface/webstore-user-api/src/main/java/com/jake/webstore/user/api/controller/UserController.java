package com.jake.webstore.user.api.controller;

import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.user.api.dto.*;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/users")
public interface UserController {
    @GetMapping()
    CommonResult<UserListDto> listUser();

    @GetMapping("/{id}")
    CommonResult<UserDto> getUser(@PathVariable("id") int id);

    @PutMapping("/{id}")
    CommonResult<UserDto> updateUser(@PathVariable("id") int id, @RequestBody UserDto dto);

    @PostMapping()
    CommonResult<UserDto> createUser(@RequestBody() UserDto dto);

    @DeleteMapping("/{id}")
    CommonResult<UserDto> deleteUser(@PathVariable("id") int id);
}
