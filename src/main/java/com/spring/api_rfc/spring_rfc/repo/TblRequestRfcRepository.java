package com.spring.api_rfc.spring_rfc.repo;


import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TblRequestRfcRepository extends JpaRepository<TblRequestRfc, Long> {
    List<TblRequestRfc> findByStatus(String Status);
    List<TblRequestRfc> findByApprovalCodeAndStatus(String approvalCode, String status);
    List<TblRequestRfc> findByAssignCodeAndStatus(String assignCode, String status);
}
