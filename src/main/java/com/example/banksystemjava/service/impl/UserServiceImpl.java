package com.example.banksystemjava.service.impl;

import com.example.banksystemjava.model.User;
import com.example.banksystemjava.repository.UserRepository;
import com.example.banksystemjava.service.UserService;

import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccounNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists");
        }
        return userRepository.save(user);
    }
}
