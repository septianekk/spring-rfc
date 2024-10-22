package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.dto.ValidateDto;
import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.service.TblRequestRfcService;
import com.spring.api_rfc.spring_rfc.util.GlobalFunction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ValidateController {
    @Autowired
    private TblRequestRfcService tblRequestRfcService;

    @GetMapping("/validates")
    public ResponseEntity<List<TblRequestRfc>> getValidates(
            @RequestParam(value = "status") String status
    ) {
        List<TblRequestRfc> requestRfcs = tblRequestRfcService.getValidates(status);
        return ResponseEntity.ok(requestRfcs);
    }

    @PutMapping("/validate/updt/{id}")
    public ResponseEntity<?> updateStatusValidate(
            @PathVariable("id") Long id, @Valid @RequestBody ValidateDto validateRfcDTO, HttpServletRequest request
    ) {
        try {
            tblRequestRfcService.updateStatusValidate(id, validateRfcDTO, request);

            return GlobalFunction.dataSuccesRejected(request);
        } catch (Exception e) {

            return GlobalFunction.dataFailedToSave(e.getMessage(), request);
        }
    }

    @GetMapping("/req/{request_id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "request_id") Long requestId, HttpServletRequest request) {
        return ResponseEntity.ok(tblRequestRfcService.findById(requestId, request));
    }
}
