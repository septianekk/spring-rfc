package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.dto.SubmitValidateDto;
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

    @PutMapping("/validate/update/{id}")
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

    @PutMapping("/validate/submit/{id}")
    public ResponseEntity<?> submitValidate(
            @PathVariable("id") Long id, @Valid @RequestBody SubmitValidateDto submitValidateDto, HttpServletRequest request
    ) {
        try {
            tblRequestRfcService.submitValidate(id, submitValidateDto, request);

            return GlobalFunction.dataSuccesSubmitted(request);
        } catch (Exception e) {

            return GlobalFunction.dataFailedToSave(e.getMessage(), request);
        }
    }

}
