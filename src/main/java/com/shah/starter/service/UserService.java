package com.shah.starter.service;

import com.shah.starter.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    List<User> findByUsername(String username);
}
