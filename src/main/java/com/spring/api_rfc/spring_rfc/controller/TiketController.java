package com.spring.api_rfc.spring_rfc.controller;

import com.spring.api_rfc.spring_rfc.dto.ApprovalDto;
import com.spring.api_rfc.spring_rfc.dto.SignProgrammer;
import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.model.User;
import com.spring.api_rfc.spring_rfc.service.TblRequestRfcService;
import com.spring.api_rfc.spring_rfc.service.UserService;
import com.spring.api_rfc.spring_rfc.util.GlobalFunction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class TiketController {

    @Autowired
    private TblRequestRfcService tblRequestRfcService;

    @Autowired
    UserService userService;

    @GetMapping("/tikets")
    public ResponseEntity<List<TblRequestRfc>> getTikets(
            @RequestParam String assignCode,
            @RequestParam String status
    ) {
        List<TblRequestRfc> requestRfcs = tblRequestRfcService.getTikets(assignCode,status);
        return ResponseEntity.ok(requestRfcs);
    }

    @GetMapping("/tiket/{requestId}")
    public ResponseEntity<Object> findById(@PathVariable(value = "requestId") Long requestId, HttpServletRequest request) {
        return ResponseEntity.ok(tblRequestRfcService.findById(requestId, request));
    }

//    @GetMapping("/tiket/user")
//    public ResponseEntity<List<User>> getUserBySmCodeAndStatus(
//            @RequestParam String smCode,
//            @RequestParam String status
//    ) {
//        List<User> users = userService.getUserBySmCodeAndStatus(smCode,status);
//        return ResponseEntity.ok(users);
//
//    }

    @PutMapping("/tiket/signtoprog/{id}")
    public ResponseEntity<?> updateSignToProg(
            @PathVariable("id") Long id, @Valid @RequestBody SignProgrammer signProgrammer, HttpServletRequest request
    ) {
        try {
            tblRequestRfcService.signProgammer(id, signProgrammer, request);

            return GlobalFunction.dataHasChanged(request);
        } catch (Exception e) {

            return GlobalFunction.dataFailedToSave(e.getMessage(), request);
        }
    }

    @PutMapping("/tiket/approval/{id}")
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
