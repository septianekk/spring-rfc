package com.spring.api_rfc.spring_rfc.controller;

import com.spring.api_rfc.spring_rfc.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    List findAll() {
        return userRepository.findAll();
    }

}
