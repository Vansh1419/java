package com.practice.blog.service.impl;

import com.practice.blog.entity.User;
import com.practice.blog.repository.UserRepository;
import com.practice.blog.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
