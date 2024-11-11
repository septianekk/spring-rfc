package com.spring.api_rfc.spring_rfc.controller;

import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.repo.UserRepository;
import com.spring.api_rfc.spring_rfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    List findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/status")
    public ResponseEntity<List<User>> getUserBySmCodeAndStatus(
            @RequestParam String smCode,
            @RequestParam String status
    ) {
        List<User> users = userService.getUserBySmCodeAndStatus(smCode,status);
        return ResponseEntity.ok(users);

    }

    @GetMapping("/users/sqa")
    public ResponseEntity<List<User>> getUserPositionAndStatus(
            @RequestParam String position,
            @RequestParam String status
    ) {
        List<User> users = userService.getUserByPositionAndStatus(position,status);
        return ResponseEntity.ok(users);

    }

}
