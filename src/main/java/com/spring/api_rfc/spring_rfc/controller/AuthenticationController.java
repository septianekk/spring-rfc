package com.spring.api_rfc.spring_rfc.controller;

import com.spring.api_rfc.spring_rfc.dto.LoginUserDto;
import com.spring.api_rfc.spring_rfc.dto.RegisterUserDto;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.response.LoginResponse;
import com.spring.api_rfc.spring_rfc.service.AuthenticationService;
import com.spring.api_rfc.spring_rfc.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RequestMapping("/api")
@RestController
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

//    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
//        this.jwtService = jwtService;
//        this.authenticationService = authenticationService;
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
//        System.out.println(loginUserDto);
//        User authenticatedUser = authenticationService.login(loginUserDto);
//        String jwtToken = jwtService.generateToken(authenticatedUser);
//
//        return ResponseEntity.ok(loginResponse);
        try {
            LoginResponse loginResponse = authenticationService.login(loginUserDto);
            System.out.println(loginResponse);
            return ResponseEntity.ok(loginResponse);
        } catch (AuthenticationException e) {
//            throw new RuntimeException(e);
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
