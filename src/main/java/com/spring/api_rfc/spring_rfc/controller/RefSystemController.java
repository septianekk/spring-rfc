package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.repo.RefSystemRepository;
import com.spring.api_rfc.spring_rfc.service.RefSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@RestController
public class RefSystemController {

    @Autowired
    RefSystemRepository refSystemRepository;

    @Autowired
    RefSystemService refSystemService;

    @GetMapping("systems")
    List findAll() {
        return refSystemRepository.findAll();
    }

    @PostMapping("systems")
    public ResponseEntity<RefSystem> create(@RequestBody RefSystem refSystem) {
        try {
            RefSystem _refsystem = refSystemRepository
                    .save(new RefSystem(
                            refSystem.getSystemName(),
                            refSystem.getStatus(),
                            refSystem.getCreated_by(),
                            refSystem.getCreated_date(new Date())
                    ));
            return new ResponseEntity<>(_refsystem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    public ResponseEntity<RefSystem> save(@RequestBody RefSystem refSystem){
//        RefSystem refSystemResult = refSystemService.create(refSystem);
//        return new ResponseEntity<>(refSystemResult, HttpStatus.OK);
//    }

}
