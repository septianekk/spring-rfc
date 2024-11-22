package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.dto.StatusCountDTO;
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
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class TblRequestRfcController {

    @Autowired
    private TblRequestRfcService tblRequestRfcService;


    @GetMapping("/req/all")
    public ResponseEntity<Object> findAll() {
//        return ResponseEntity.ok(tblRequestRfcService.findAll());
        return null;
    }

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

    @GetMapping("/req")
    public ResponseEntity<List<TblRequestRfc>> getCreatedBy(
            @RequestParam String createdBy
    ) {
        List<TblRequestRfc> requestRfcs = tblRequestRfcService.getListRequestByCreatedBy(createdBy);
        return ResponseEntity.ok(requestRfcs);
    }

    @GetMapping("/req/assign")
    public ResponseEntity<List<TblRequestRfc>> getAssignCode(
            @RequestParam String assignCode
    ) {
        List<TblRequestRfc> requestRfcs = tblRequestRfcService.getListRequestByAssignCode(assignCode);
        return ResponseEntity.ok(requestRfcs);
    }

    @GetMapping("/req/approval_code_and_status")
    public ResponseEntity<List<TblRequestRfc>> getApprovalCodeAndStatus(
            @RequestParam String approvalCode
    ) {
        List<TblRequestRfc> requestRfcs = tblRequestRfcService.getApprovalStatusApproved(approvalCode);
        return ResponseEntity.ok(requestRfcs);
    }

    @GetMapping("/req/validate")
    public ResponseEntity<List<TblRequestRfc>> getValidateCode(
            @RequestParam String validateCode
    ) {
        List<TblRequestRfc> requestRfcs = tblRequestRfcService.getListRequestByValidateCode(validateCode);
        return ResponseEntity.ok(requestRfcs);
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getRfcSummary(@RequestParam("assignCode") String assignCode) {
        Map<String, Object> result = tblRequestRfcService.getRfcSummary(assignCode);
        return ResponseEntity.ok(Map.of(
                "status", 200,
                "message", "Summary fetched successfully",
                "data", result
        ));
    }

    @GetMapping("/dashboard/status")
    public ApiResponse<List<StatusCountDTO>> getStatus(
            @RequestParam String nik,
            @RequestParam String privilege) {
        List<StatusCountDTO> data = tblRequestRfcService.getStatus(nik, privilege);
        return new ApiResponse<>(200, "Summary fetched successfully", data);
    }

    @GetMapping("/dashboard/tasks")
    public List<Map<String, Object>> getTasks(@RequestParam String nik, @RequestParam String privilege) {
        return tblRequestRfcService.getTasks(nik, privilege);
    }

    @GetMapping("/req/report")
    public ApiResponse<List<TblRequestRfc>> getRequests(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String nik,
            @RequestParam String privilege,
            @RequestParam(required = false, defaultValue = "ALL") String status) {

        List<TblRequestRfc> requests = tblRequestRfcService.getReport(startDate, endDate, nik, privilege, status);
        return new ApiResponse<>(200, "Requests fetched successfully", requests);
    }
}
