package com.shah.starter.service.impl;

import com.shah.starter.model.User;
import com.shah.starter.repository.UserRepository;
import com.shah.starter.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {


    private final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User registerUser(User user) {
        User savedCustomer = null;
        ResponseEntity response = null;
        try {
            String hashPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPwd);
            user.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));

            savedCustomer = userRepository.save(user);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error in registering user");
            throw ex;
        }

        return savedCustomer;
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
