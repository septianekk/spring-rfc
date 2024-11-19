package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.dto.RefSystemDto;
import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.repo.RefSystemRepository;
import com.spring.api_rfc.spring_rfc.util.GlobalFunction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefSystemService {

    @Autowired
    private RefSystemRepository refSystemRepository;

    private ModelMapper modelMapper;
    public RefSystemService() {
        modelMapper = new ModelMapper();
    }

    public List<RefSystem> findAll() {
            List<RefSystem> refSystems = refSystemRepository.findAll();
        return refSystems;
    }

    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        Optional<RefSystem> tblRefSystem = refSystemRepository.findById(id);
        if (!tblRefSystem.isPresent()){
            return GlobalFunction.dataNotFound(request);
        }
        return GlobalFunction.dataByIdAlreadyFound(convertToDTO(tblRefSystem.get()), request);
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
        return refSystemRepository.save(existingSystem);
    }

    public void deleteSystem(Long id) {
        refSystemRepository.deleteById(id);
    }

    public com.spring.api_rfc.spring_rfc.dto.RefSystemDto convertToDTO(RefSystem tblRefSystem) {
        return modelMapper.map(tblRefSystem, com.spring.api_rfc.spring_rfc.dto.RefSystemDto.class);
    }
}
