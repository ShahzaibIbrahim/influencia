package com.shah.starter.contoller;

import com.shah.starter.entity.Authority;
import com.shah.starter.entity.Brand;
import com.shah.starter.entity.User;
import com.shah.starter.model.BrandModel;
import com.shah.starter.model.UserModel;
import com.shah.starter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserModel userModel) {
        ResponseEntity response = null;
        try {
            Authority authority = new Authority();
            authority.setName("USER");

            User user = new User();
            BeanUtils.copyProperties(userModel, user);

            user.setAuthorities(new HashSet<>(Collections.singletonList(authority)));

            user = userService.registerUser(user);

            if (user.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }



    @RequestMapping("/user")
    public User getUserDetailsAfterLogin(Authentication authentication) {
        List<User> users = userService.findByUsername(authentication.getName());
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

}
