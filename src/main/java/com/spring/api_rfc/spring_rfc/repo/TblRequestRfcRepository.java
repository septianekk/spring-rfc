package com.spring.api_rfc.spring_rfc.repo;


import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface TblRequestRfcRepository extends JpaRepository<TblRequestRfc, Long> {
    List<TblRequestRfc> findByStatus(String Status);
    List<TblRequestRfc> findByApprovalCodeAndStatus(String approvalCode, String status);
    List<TblRequestRfc> findByAssignCodeAndStatus(String assignCode, String status);
    List<TblRequestRfc> findByCreatedBy(String createdBy);

    @Query(value = """
        SELECT
            SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NULL THEN 1 ELSE 0 END) AS count_pending,
            SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NOT NULL THEN 1 ELSE 0 END) AS count_onprogress,
            SUM(CASE WHEN Status = 'COMPLETED' THEN 1 ELSE 0 END) AS count_completed
        FROM tbl_request_rfc
        WHERE Assign_Code = :assignCode
    """, nativeQuery = true)
    Map<String, Object> getRfcSummary(@Param("assignCode") String assignCode);
}
