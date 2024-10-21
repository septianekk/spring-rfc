package com.spring.api_rfc.spring_rfc.controller;

import com.spring.api_rfc.spring_rfc.dto.LoginUserDto;
import com.spring.api_rfc.spring_rfc.dto.RegisterUserDto;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.response.LoginResponse;
import com.spring.api_rfc.spring_rfc.service.AuthenticationService;
import com.spring.api_rfc.spring_rfc.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody LoginUserDto loginUserDto, HttpServletRequest request) {
        return authenticationService.login(loginUserDto,request);
        //        try {
//            LoginResponse loginResponse = authenticationService.login(loginUserDto, request);
//            System.out.println(loginUserDto);
//            return ResponseEntity.ok(loginResponse);
//        } catch (AuthenticationException e) {;
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
    }

}
