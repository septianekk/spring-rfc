package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcRepository;
import com.spring.api_rfc.spring_rfc.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserBySmCodeAndStatus(String smCode, String status) {

        return userRepository.findBySmCodeAndStatus(smCode,status);
    }

    public List<User> getUserByPositionAndStatus(String position, String status) {

        return userRepository.findByPositionAndStatus(position,status);
    }

}
