package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcRepository;
import com.spring.api_rfc.spring_rfc.service.TblRequestRfcService;
import com.spring.api_rfc.spring_rfc.validasi.TblRequestRfcValidasi;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class TblRequestRfcController {

    @Autowired
    private TblRequestRfcService tblRequestRfcService;

    @Autowired
    private TblRequestRfcRepository tblRequestRfcRepository;


    @GetMapping("/req/all")
    public ResponseEntity<Object> findAll() {
//        return ResponseEntity.ok(tblRequestRfcService.findAll());
        return null;
    }

    @PostMapping("/insert-req")
    public ResponseEntity<Object> save(@Valid @RequestBody TblRequestRfcValidasi tblRequestRfcValidasi,
                                       HttpServletRequest request) {
        return tblRequestRfcService.save(tblRequestRfcService.convertToEntity(tblRequestRfcValidasi), request);
    }


}
