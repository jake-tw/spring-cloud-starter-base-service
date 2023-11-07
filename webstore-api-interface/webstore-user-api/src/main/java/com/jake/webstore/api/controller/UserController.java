package com.jake.webstore.api.controller;

import com.jake.webstore.api.dto.*;
import com.jake.webstore.common.api.dto.CommonResult;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
public interface UserController {

    @PostMapping("/login")
    CommonResult<LoginRes> login(@RequestBody() LoginReq req);

    @GetMapping("/salt/{username}")
    CommonResult<SaltDto> getSalt(@PathVariable("username") String username);

    @GetMapping()
    CommonResult<UserListDto> listUser();

    @GetMapping("/{id}")
    CommonResult<UserDto> getUser(@PathVariable("id") int id);

    @PutMapping("/{id}")
    CommonResult<UserDto> updateUser(@PathVariable("id") int id, @RequestBody() UserDto dto);

    @PostMapping()
    CommonResult<UserDto> createUser(@RequestBody() UserDto dto);

    @DeleteMapping("/{id}")
    CommonResult<UserDto> deleteUser(@PathVariable("id") int id);
}
