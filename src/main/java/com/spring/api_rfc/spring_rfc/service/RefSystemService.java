package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.dto.RefSystemDto;
import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.repo.RefSystemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefSystemService {

    @Autowired
    private RefSystemRepository refSystemRepository;

    public List<RefSystem> findAll() {
            List<RefSystem> refSystems = refSystemRepository.findAll();
        return refSystems;
    }


    public RefSystem create(RefSystem refSystem){
        return refSystemRepository.save(refSystem);
    }

    public RefSystem insertSystem(@Valid RefSystemDto input){
        RefSystem refSystem = new RefSystem();
        refSystem.setSystemName(input.getSystemName());
        refSystem.setStatus(input.getStatus());
        refSystem.setCreated_by(input.getCreated_by());
        return refSystemRepository.save(refSystem);
    }

    public RefSystem updateSystem(RefSystemDto refSystem){
        RefSystem existingSystem = refSystemRepository.findById(refSystem.getSystemId()).orElseThrow(() -> new RuntimeException("System not found"));
        existingSystem.setSystemName(refSystem.getSystemName());
        existingSystem.setStatus(refSystem.getStatus());
        existingSystem.setCreated_by(refSystem.getCreated_by());
        return refSystemRepository.save(existingSystem);
    }

    public void deleteSystem(Long id) {
        refSystemRepository.deleteById(id);
    }
}
