package com.practice.blog.controller;

import com.practice.blog.dto.UserDto;
import com.practice.blog.entity.User;
import com.practice.blog.mapper.UserMapperImpl;
import com.practice.blog.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userService;
    private UserMapperImpl userMapper;

    public UserController(UserServiceImpl userService, UserMapperImpl userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("")
    public User getUsers(@RequestBody UserDto user){
        User userEntity = userMapper.mapFromDtoToEntity(user);
        return userService.createUser(userEntity);
    }
}
