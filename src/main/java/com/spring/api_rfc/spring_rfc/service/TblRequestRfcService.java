package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.dto.ApprovalDto;
import com.spring.api_rfc.spring_rfc.dto.SignProgrammer;
import com.spring.api_rfc.spring_rfc.dto.SubmitValidateDto;
import com.spring.api_rfc.spring_rfc.dto.ValidateDto;
import com.spring.api_rfc.spring_rfc.model.TblRfcLogs;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcLogRepository;
import com.spring.api_rfc.spring_rfc.validasi.TblRequestRfcValidasi;
import com.spring.api_rfc.spring_rfc.core.IService;
import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcRepository;
import com.spring.api_rfc.spring_rfc.util.GlobalFunction;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class TblRequestRfcService implements IService<TblRequestRfc> {

    private ModelMapper modelMapper;
    public TblRequestRfcService() {
        modelMapper = new ModelMapper();
    }

    @Autowired
    private TblRequestRfcRepository tblRequestRfcRepository;

    @Autowired
    private TblRequestRfcLogRepository tblRequestRfcLogRepository;


    @Override
    public ResponseEntity<Object> save(TblRequestRfc tblRequestRfc, HttpServletRequest request) {
        if (tblRequestRfc==null){
            return GlobalFunction.validatiFailed("Object null", "FV001001001", request);
        }
        try {
            TblRequestRfc savedRequest = tblRequestRfcRepository.save(tblRequestRfc);
            TblRfcLogs log = new TblRfcLogs();

            log.setRequestId(savedRequest.getRequestId());
            log.setStatus("NEW");
            log.setCreatedBy(savedRequest.getCreatedBy()); // Assuming you have logged-in user
            tblRequestRfcLogRepository.save(log);
        } catch (Exception e) {
            GlobalFunction.dataFailedToSave("FE001001001", request);
        }
        return GlobalFunction.dataHasSaved(request);
    }

    public List<TblRequestRfc> getValidates(String status) {
        return tblRequestRfcRepository.findByStatus(status);
    }

    public ResponseEntity<Object> updateStatusValidate(Long id, ValidateDto validateDto, HttpServletRequest request) throws Exception {
        Optional<TblRequestRfc> optionalRequest = tblRequestRfcRepository.findById(id);
        if (!optionalRequest.isPresent()) {
            return GlobalFunction.dataNotFound(request);
        }
        try {
            TblRequestRfc requestRfc = optionalRequest.get();

            requestRfc.setStatus(validateDto.getStatus());
            requestRfc.setValidateNote(validateDto.getValidateNote());
            requestRfc.setCreatedBy(validateDto.getCreatedBy());
            requestRfc.setModifiedDate(new Date());
            TblRequestRfc updatedRequest = tblRequestRfcRepository.save(requestRfc);

            TblRfcLogs log = new TblRfcLogs();
            log.setRequestId(id);
            log.setStatus(validateDto.getStatus());
            log.setCreatedBy(validateDto.getModifiedBy());
            tblRequestRfcLogRepository.save(log);
        } catch (Exception e) {
            return GlobalFunction.failedToChange("FE001001011", request);
        }
        return GlobalFunction.dataSuccesRejected(request);
    }

    @Override
    public ResponseEntity<Object> update(Long id, TblRequestRfc tblRequestRfc, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        return null;
    }

//    @Override
//    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
//        return null;
//    }

    public ResponseEntity<?> listAll(HttpServletRequest request) {
        List<TblRequestRfc> tblRequestRfcs = tblRequestRfcRepository.findAll();
        if (tblRequestRfcs.isEmpty()) {
            return GlobalFunction.dataNotFound(request);
        }

        return GlobalFunction.dataListFound(tblRequestRfcs,request);
    }



    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        Optional<TblRequestRfc> tblRequestRfc =tblRequestRfcRepository.findById(id);
        if (!tblRequestRfc.isPresent()){
            return GlobalFunction.dataNotFound(request);
        }
        return GlobalFunction.dataByIdAlreadyFound(convertToDTO(tblRequestRfc.get()), request);
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> uploadDataExcel(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }


    public List<TblRequestRfc> getApprovals(String approvalCode, String status) {

        return tblRequestRfcRepository.findByApprovalCodeAndStatus(approvalCode,status);
    }

    public ResponseEntity<Object> updateStatusRfc(Long id, ApprovalDto approvalDto, HttpServletRequest request) throws Exception {

        Optional<TblRequestRfc> optionalRequest = tblRequestRfcRepository.findById(id);

        if (optionalRequest.isPresent()) {
            try {
                TblRequestRfc requestRfc = optionalRequest.get();

                requestRfc.setStatus(approvalDto.getStatus());
                if(approvalDto.getStatus().equals("REJECT APPROVAL")){
                    requestRfc.setApprovalNote(approvalDto.getRejectNote());
                }
                requestRfc.setModifiedDate(new Date());
                requestRfc.setModifiedBy(approvalDto.getModifiedBy());
                TblRequestRfc updatedRequest = tblRequestRfcRepository.save(requestRfc);

                TblRfcLogs log = new TblRfcLogs();
                log.setRequestId(id);
                log.setStatus(approvalDto.getStatus());
                log.setCreatedBy(approvalDto.getModifiedBy());

                tblRequestRfcLogRepository.save(log);
            } catch (Exception e) {
                GlobalFunction.dataFailedToSave("FE001001001", request);
            }
            return GlobalFunction.dataHasSaved(request);
        } else {
            return GlobalFunction.dataNotFound(request);
        }
    }

    public ResponseEntity<Object> submitValidate(Long id, SubmitValidateDto submitValidateDto, HttpServletRequest request) throws Exception {
        Optional<TblRequestRfc> optionalRequest = tblRequestRfcRepository.findById(id);
        if (!optionalRequest.isPresent()) {
            return GlobalFunction.dataNotFound(request);
        }
        try {
            TblRequestRfc requestRfc = optionalRequest.get();
            requestRfc.setAssignCode(submitValidateDto.getAssignCode());
            requestRfc.setAssignName(submitValidateDto.getAssignName());
            requestRfc.setLingkupTerdampak(submitValidateDto.getLingkupTerdampak());
            requestRfc.setPrioritasPengerjaan(submitValidateDto.getPrioritasPengerjaan());
            requestRfc.setEvaluasiResiko(submitValidateDto.getEvaluasiResiko());
            requestRfc.setTglExecute(submitValidateDto.getTglExecute());
            requestRfc.setTglEstimasi(submitValidateDto.getTglEstimasi());
            requestRfc.setRekomendasiAlternatif(submitValidateDto.getRekomendasiAlternatif());
            requestRfc.setValidateCode(submitValidateDto.getValidateCode());
            requestRfc.setValidateName(submitValidateDto.getValidateName());
            requestRfc.setModifiedBy(submitValidateDto.getModifiedBy());
            requestRfc.setModifiedDate(new Date());
            TblRequestRfc updatedRequest = tblRequestRfcRepository.save(requestRfc);

            TblRfcLogs log = new TblRfcLogs();
            log.setRequestId(id);
            log.setStatus(submitValidateDto.getStatus());
            log.setCreatedBy(submitValidateDto.getModifiedBy());
            tblRequestRfcLogRepository.save(log);
        } catch (Exception e) {
            return GlobalFunction.failedToChange("FE001001011", request);
        }
        return GlobalFunction.dataSuccesRejected(request);
    }

    public List<TblRequestRfc> getTikets(String assignCode, String status) {

        return tblRequestRfcRepository.findByAssignCodeAndStatus(assignCode,status);
    }

    public ResponseEntity<Object> signProgammer(Long id, SignProgrammer signProgrammer, HttpServletRequest request) throws Exception {
        Optional<TblRequestRfc> optionalRequest = tblRequestRfcRepository.findById(id);
        if (!optionalRequest.isPresent()) {
            return GlobalFunction.dataNotFound(request);
        }
        try {
            TblRequestRfc requestRfc = optionalRequest.get();
            requestRfc.setProgrammerCode(signProgrammer.getProgrammerCode());
            requestRfc.setProgrammerName(signProgrammer.getProgrammerName());
            requestRfc.setModifiedBy(signProgrammer.getModifiedBy());
            requestRfc.setModifiedDate(new Date());
            tblRequestRfcRepository.save(requestRfc);
        } catch (Exception e) {
            return GlobalFunction.failedToChange("FE001001011", request);
        }
        return GlobalFunction.dataHasChanged(request);
    }


    public TblRequestRfc convertToEntity(TblRequestRfcValidasi tblRequestRfcValidasi){
        return modelMapper.map(tblRequestRfcValidasi, TblRequestRfc.class);
    }

    public com.spring.api_rfc.spring_rfc.dto.TblRequestRfcDTO convertToDTO(TblRequestRfc tblRequestRfc){
        return modelMapper.map(tblRequestRfc, com.spring.api_rfc.spring_rfc.dto.TblRequestRfcDTO.class);
    }

}
