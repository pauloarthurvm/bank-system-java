package com.example.banksystemjava.service;

import com.example.banksystemjava.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);

}
