package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcRepository;
import com.spring.api_rfc.spring_rfc.service.TblRequestRfcService;
import com.spring.api_rfc.spring_rfc.validasi.TblRequestRfcValidasi;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/req/{request_id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "request_id") Long requestId, HttpServletRequest request) {
        return ResponseEntity.ok(tblRequestRfcService.findById(requestId, request));
    }

    @PostMapping("/insert-req")
    public ResponseEntity<Object> save(@Valid @RequestBody TblRequestRfcValidasi tblRequestRfcValidasi,
                                       HttpServletRequest request) {
        return tblRequestRfcService.save(tblRequestRfcService.convertToEntity(tblRequestRfcValidasi), request);
    }


}
