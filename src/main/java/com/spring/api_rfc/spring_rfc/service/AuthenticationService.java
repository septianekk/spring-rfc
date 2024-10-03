package com.spring.api_rfc.spring_rfc.service;


import com.spring.api_rfc.spring_rfc.dto.LoginUserDto;
import com.spring.api_rfc.spring_rfc.dto.RegisterUserDto;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.repo.UserRepository;
import com.spring.api_rfc.spring_rfc.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
//
//    public AuthenticationService(
//            UserRepository userRepository,
//            AuthenticationManager authenticationManager,
//            PasswordEncoder passwordEncoder,
//            JwtService jwtService) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//    }

//    public User signup(RegisterUserDto input) {
//        User user = new User()
//                .setName(input.getName())
//                .setEmail(input.getEmail())
//                .setPassword(passwordEncoder.encode(input.getPassword()));
//
//        return userRepository.save(user);
//    }

    public LoginResponse login(LoginUserDto input){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getNik(),
                        input.getPassword()
                )
        );
        User user = (User) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return loginResponse;
    }

    // OLD
//    public User authenticate(LoginUserDto input) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        input.getNik(),
//                        input.getPassword()
//                )
//        );
////        User user = (User) authenticationManager.getPrincipal();
//
//        return userRepository.findByNik(input.getNik())
//                             .orElseThrow();
//    }

}
