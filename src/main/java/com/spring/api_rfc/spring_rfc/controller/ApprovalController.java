package com.spring.api_rfc.spring_rfc.controller;

import com.spring.api_rfc.spring_rfc.dto.ApprovalDto;
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
public class ApprovalController {

    @Autowired
    private TblRequestRfcService tblRequestRfcService;

    @GetMapping("/approvals")
    public ResponseEntity<List<TblRequestRfc>> getApprovals(
            @RequestParam String approvalCode,
            @RequestParam String status
    ) {
        List<TblRequestRfc> users = tblRequestRfcService.getApprovals(approvalCode,status);
        return ResponseEntity.ok(users);

    }

    @PutMapping("/approval/{id}")
    public ResponseEntity<?> updateStatusRfc(
            @PathVariable("id") Long id, @Valid @RequestBody ApprovalDto approvalDto,HttpServletRequest request
    ) {
        try {
            tblRequestRfcService.updateStatusRfc(id, approvalDto, request);

            return GlobalFunction.dataHasChanged(request);
        } catch (Exception e) {

            return GlobalFunction.dataFailedToSave(e.getMessage(), request);
        }
    }

}
