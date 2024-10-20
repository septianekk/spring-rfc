package com.spring.api_rfc.spring_rfc.service;

import com.spring.api_rfc.spring_rfc.dto.ApprovalDto;
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


    public TblRequestRfc convertToEntity(TblRequestRfcValidasi tblRequestRfcValidasi){
        return modelMapper.map(tblRequestRfcValidasi, TblRequestRfc.class);
    }

    public com.spring.api_rfc.spring_rfc.dto.TblRequestRfcDTO convertToDTO(TblRequestRfc tblRequestRfc){
        return modelMapper.map(tblRequestRfc, com.spring.api_rfc.spring_rfc.dto.TblRequestRfcDTO.class);
    }

}
