package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.dto.RefSystemDto;
import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.repo.RefSystemRepository;
import com.spring.api_rfc.spring_rfc.response.ApiResponse;
import com.spring.api_rfc.spring_rfc.service.RefSystemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@RestController
public class RefSystemController {

    @Autowired
    RefSystemService refSystemService;

    @GetMapping("systems")
    public ResponseEntity<ApiResponse<List<RefSystem>>> listAll() {
        List<RefSystem> refSystems = refSystemService.findAll();

        if (refSystems.isEmpty()) {
            return new ResponseEntity<>(
                    new ApiResponse<>(204, "No Systems found", new ArrayList<>()),
                    HttpStatus.NO_CONTENT
            );
        }

        return new ResponseEntity<>(
                new ApiResponse<>(200, "Systems found", refSystems),
                HttpStatus.OK
        );
    }

    @Transactional
    @PostMapping("systems")
    public ResponseEntity<String> create(@RequestBody RefSystemDto refSystem) {
        try {
            refSystemService.insertSystem(refSystem);
            return new ResponseEntity<>("System registered successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return refSystemService.insertSystem(refSystem,status);
    }

    @GetMapping("systems/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long requestId, HttpServletRequest request) {
        return ResponseEntity.ok(refSystemService.findById(requestId, request));
    }

    @PutMapping("systems/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody RefSystemDto refSystem) {

        try {
//            refSystemService.insertSystem(refSystem);
            refSystem.setSystemId(id);
            refSystemService.updateSystem(refSystem);
            return new ResponseEntity<>("System updated successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("systems/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        refSystemService.deleteSystem(id);
        return ResponseEntity.ok("System deleted successfully");
    }
}
