package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcLogRepository;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcRepository;
import com.spring.api_rfc.spring_rfc.response.ApiResponse;
import com.spring.api_rfc.spring_rfc.service.TblRequestRfcService;
import com.spring.api_rfc.spring_rfc.util.GlobalFunction;
import com.spring.api_rfc.spring_rfc.validasi.TblRequestRfcValidasi;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class TblRequestRfcController {

    @Autowired
    private TblRequestRfcService tblRequestRfcService;

    @GetMapping("/get-all-req")
    public ResponseEntity<Object> findAll(HttpServletRequest request){
        return ResponseEntity.ok(tblRequestRfcService.findAll(request));
    }

//    @GetMapping("/req/all")
//    public ResponseEntity<List<TblRequestRfc>> findAll(HttpServletRequest request) {
//        return ResponseEntity.ok(tblRequestRfcService.listAll(request));
//    }


    @GetMapping("/req/{requestId}")
    public ResponseEntity<Object> findById(@PathVariable(value = "requestId") Long requestId, HttpServletRequest request) {
        return ResponseEntity.ok(tblRequestRfcService.findById(requestId, request));
    }

    @PostMapping("/insert-req")
    public ResponseEntity<Object> save(@Valid @RequestBody TblRequestRfcValidasi tblRequestRfcValidasi,
                                       HttpServletRequest request) {
        return tblRequestRfcService.save(tblRequestRfcService.convertToEntity(tblRequestRfcValidasi), request);
    }




}
