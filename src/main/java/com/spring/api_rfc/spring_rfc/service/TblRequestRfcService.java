package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.dto.*;
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

import java.time.LocalDate;
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
            System.out.println(e.getMessage());
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
            requestRfc.setModifiedBy(validateDto.getModifiedBy());
            requestRfc.setModifiedDate(LocalDate.now());
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

    public ResponseEntity<Object> signToSqa(Long id, ValidateDto validateDto, HttpServletRequest request) throws Exception {
        Optional<TblRequestRfc> optionalRequest = tblRequestRfcRepository.findById(id);
        if (!optionalRequest.isPresent()) {
            return GlobalFunction.dataNotFound(request);
        }
        try {
            TblRequestRfc requestRfc = optionalRequest.get();

            requestRfc.setStatus(validateDto.getStatus());
            requestRfc.setSqaCode(validateDto.getSqaCode());
            requestRfc.setSqaName(validateDto.getSqaName());
            requestRfc.setModifiedBy(validateDto.getModifiedBy());
            requestRfc.setModifiedDate(LocalDate.now());
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


    public List<TblRequestRfc> getApprovals(String approvalCode) {

        return tblRequestRfcRepository.findByApprovalCode(approvalCode);
    }

    public List<TblRequestRfc> getApprovalStatusApproved(String approvalCode) {

        return tblRequestRfcRepository.findByApprovalCodeAndStatusApproved(approvalCode);
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
                requestRfc.setModifiedDate(LocalDate.now());
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
            requestRfc.setStatus(submitValidateDto.getStatus());
            requestRfc.setModifiedBy(submitValidateDto.getModifiedBy());
            requestRfc.setModifiedDate(LocalDate.now());
            tblRequestRfcRepository.save(requestRfc);

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

    public List<TblRequestRfc> getTikets(String assignCode) {
        return tblRequestRfcRepository.findByAssignCode(assignCode);
//        return tblRequestRfcRepository.findByAssignCodeAndStatus(assignCode,status);
    }

    public List<TblRequestRfc> getAssignCodeAndStatus(String assignCode, String status) {
        return tblRequestRfcRepository.findByAssignCodeAndStatus(assignCode, status);
//        return tblRequestRfcRepository.findByAssignCodeAndStatus(assignCode,status);
    }

    public List<TblRequestRfc> getListRequestByCreatedBy(String createdBy) {

        return tblRequestRfcRepository.findByCreatedBy(createdBy);
    }

    public List<TblRequestRfc> getListRequestByAssignCode(String assignCode) {

        return tblRequestRfcRepository.findByAssignCode(assignCode);
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
            requestRfc.setModifiedDate(LocalDate.now());
            tblRequestRfcRepository.save(requestRfc);
        } catch (Exception e) {
            return GlobalFunction.failedToChange("FE001001011", request);
        }
        return GlobalFunction.dataHasChanged(request);
    }


    public Map<String, Object> getRfcSummary(String assignCode) {
        return tblRequestRfcRepository.getRfcSummary(assignCode);
    }

    public List<StatusCountDTO> getStatus(String nik, String privilege) {
        List<Object[]> result;

        if (privilege.equals("3")) {
            result = tblRequestRfcRepository.getStatusForSPV(nik);
        } else if (privilege.equals("4")) {
            result = tblRequestRfcRepository.getStatusForManager(nik);
        } else {
            throw new IllegalArgumentException("Invalid privilege");
        }

        List<StatusCountDTO> statusCounts = new ArrayList<>();

        // Inisialisasi status yang akan dimasukkan
        List<String> statuses = List.of("COMPLETED", "ON PROGRESS", "VALIDATED");

        for (String status : statuses) {
            StatusCountDTO dto = new StatusCountDTO();
            dto.setStatus(status);
            dto.setCountPending(0);
            dto.setCountOnprogress(0);
            dto.setCountCompleted(0);

            // Mengisi nilai berdasarkan hasil query
            for (Object[] row : result) {
                String rowStatus = (String) row[0];
                if (status.equals(rowStatus)) {
                    if ("ON PROGRESS".equals(status)) {
                        dto.setCountOnprogress(((Number) row[2]).intValue());
                    } else if ("COMPLETED".equals(status)) {
                        dto.setCountCompleted(((Number) row[3]).intValue());
                    } else {
                        dto.setCountPending(((Number) row[1]).intValue());
                    }
                }
            }

            statusCounts.add(dto);
        }

        return statusCounts;
    }

    public List<Map<String, Object>> getTasks(String nik, String privilege) {
//        List<Map<String, Object>> result = new ArrayList<>();

        List<Object[]> tasks;
        List<Map<String, Object>> result = new ArrayList<>();

        if (privilege.equals("3")) {
            tasks = tblRequestRfcRepository.getTasksForSPV(nik);

            // Convert Object[] to Map for easier manipulation and response
            for (Object[] task : tasks) {
                Map<String, Object> taskMap = new LinkedHashMap<>();
                taskMap.put("Programmer_Code", task[0]);
                taskMap.put("Programmer_Name", task[1]);
                taskMap.put("jml", task[2]);
                taskMap.put("onprogress", task[3]);
                taskMap.put("completed", task[4]);

                result.add(taskMap);
            }
        } else if (privilege.equals("4")) {
            tasks = tblRequestRfcRepository.getTasksForManager(nik);

            // Convert Object[] to Map for easier manipulation and response
            for (Object[] task : tasks) {
                Map<String, Object> taskMap = new LinkedHashMap<>();
                taskMap.put("Assign_Code", task[0]);
                taskMap.put("Assign_Name", task[1]);
                taskMap.put("jml", task[2]);
                taskMap.put("onprogress", task[3]);
                taskMap.put("completed", task[4]);

                result.add(taskMap);
            }
        } else {
            throw new IllegalArgumentException("Invalid privilege");
        }

        return result;
    }

    public TblRequestRfc convertToEntity(TblRequestRfcValidasi tblRequestRfcValidasi){
        return modelMapper.map(tblRequestRfcValidasi, TblRequestRfc.class);
    }

    public com.spring.api_rfc.spring_rfc.dto.TblRequestRfcDTO convertToDTO(TblRequestRfc tblRequestRfc){
        return modelMapper.map(tblRequestRfc, com.spring.api_rfc.spring_rfc.dto.TblRequestRfcDTO.class);
    }

}
