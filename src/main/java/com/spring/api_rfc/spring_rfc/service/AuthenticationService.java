package com.spring.api_rfc.spring_rfc.service;


import com.spring.api_rfc.spring_rfc.dto.LoginUserDto;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.repo.UserRepository;
import com.spring.api_rfc.spring_rfc.response.LoginResponse;
import com.spring.api_rfc.spring_rfc.util.GlobalFunction;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<Object> login(LoginUserDto input, HttpServletRequest request){
        LoginResponse loginResponse = new LoginResponse();
        Optional<User> userOptional = userRepository.findByNik(input.getNik());
        if (userOptional.isEmpty()) {
            return GlobalFunction.dataNotFound(request);
        }
//
        User checkPassword = userOptional.get();
        if (!passwordEncoder.matches(input.getPassword(), checkPassword.getPassword())) {
            return GlobalFunction.invalidCredential(request);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getNik(),
                        input.getPassword()
                )
        );
        User userNow = (User) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(userNow);

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        loginResponse.setNik(userNow.getNik());
        loginResponse.setName(userNow.getName());
        loginResponse.setBranch(userNow.getBranch());
        loginResponse.setDivision(userNow.getDivision());
        loginResponse.setPosition(userNow.getPosition());
        loginResponse.setDepartement(userNow.getDepartement());
        loginResponse.setUnit(userNow.getUnit());
        loginResponse.setLevel(userNow.getLevel());
        loginResponse.setSm_code(userNow.getSm_code());
        loginResponse.setSm_name(userNow.getSm_name());
        loginResponse.setPrivilege(userNow.getPrivilege());
        return GlobalFunction.successWithToken(loginResponse,request);
    }

}
