package com.shah.starter.service.impl;

import com.shah.starter.entity.Authority;
import com.shah.starter.entity.Brand;
import com.shah.starter.entity.User;
import com.shah.starter.model.BrandModel;
import com.shah.starter.repository.BrandRepository;
import com.shah.starter.service.BrandService;
import com.shah.starter.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BrandServiceImpl implements BrandService {


    private final Logger LOG = Logger.getLogger(BrandServiceImpl.class.getName());

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    @Transactional
    public Brand registerBrand(BrandModel brandModel) {
        Brand registeredBrand = null;
        ResponseEntity response = null;
        try {
            //1. Save the brand
            Brand newBrand = new Brand();
            BeanUtils.copyProperties(brandModel, newBrand);

            registeredBrand = brandRepository.save(newBrand);

            //2. Register User First
            User newUser = new User();
            BeanUtils.copyProperties(brandModel.getUser(), newUser);

            Authority authority = new Authority();
            authority.setName("BRAND");

            newUser.setAuthorities(new HashSet<>(Collections.singletonList(authority)));
            newUser.setBrand(registeredBrand);

            User createdUser = userService.registerUser(newUser);

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error in registering user");
            throw ex;
        }

        return registeredBrand;
    }

}
