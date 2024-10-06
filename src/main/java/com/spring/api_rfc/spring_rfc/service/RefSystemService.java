package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.repo.RefSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefSystemService {

    @Autowired
    private RefSystemRepository refSystemRepository;

    public RefSystem create(RefSystem refSystem){
        return refSystemRepository.save(refSystem);
    }

}
