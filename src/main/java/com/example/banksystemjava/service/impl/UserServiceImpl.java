package com.example.banksystemjava.service.impl;

import com.example.banksystemjava.model.User;
import com.example.banksystemjava.repository.UserRepository;
import com.example.banksystemjava.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
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
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists");
        }
        return userRepository.save(user);
    }
}
