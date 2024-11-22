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
    @Query("select u from TblRequestRfc u where u.approvalCode = ?1 and u.status ='NEW'")
    List<TblRequestRfc> findByApprovalCode(String approvalCode);

    @Query("select u from TblRequestRfc u where u.approvalCode = ?1 and u.status in ('APPROVED', 'ON PROGRESS','COMPLETED','REJECT VALIDATED','REJECT APPROVAL')")
    List<TblRequestRfc> findByApprovalCodeAndStatusApproved(String approvalCode);

    @Query("select u from TblRequestRfc u where u.assignCode = ?1 and u.status in ('APPROVED', 'ON PROGRESS','COMPLETED','REJECT VALIDATED','REJECT APPROVAL')")
    List<TblRequestRfc> findByAssignCode(String assignCode);

    List<TblRequestRfc> findByAssignCodeAndStatus(String assignCode, String status);

    List<TblRequestRfc> findByCreatedBy(String createdBy);

    List<TblRequestRfc> findByValidateCode(String validateCode);
//    List<TblRequestRfc> findByAssignCode(String assignCode);

    @Query(value = """
        SELECT
            SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NULL THEN 1 ELSE 0 END) AS count_pending,
            SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NOT NULL THEN 1 ELSE 0 END) AS count_onprogress,
            SUM(CASE WHEN Status = 'COMPLETED' THEN 1 ELSE 0 END) AS count_completed
        FROM tbl_request_rfc
        WHERE Assign_Code = :assignCode
    """, nativeQuery = true)
    Map<String, Object> getRfcSummary(@Param("assignCode") String assignCode);

    // Untuk SPV
    @Query(value = """
        SELECT Status,
               SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NULL THEN 1 ELSE 0 END) AS count_pending,
               SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NOT NULL THEN 1 ELSE 0 END) AS count_onprogress,
               SUM(CASE WHEN Status = 'COMPLETED' THEN 1 ELSE 0 END) AS count_completed
        FROM tbl_request_rfc
        WHERE Assign_Code = :nik
        GROUP BY Status
    """, nativeQuery = true)
    List<Object[]> getStatusForSPV(@Param("nik") String nik);

    // Untuk Manager
    @Query(value = """
        SELECT Status,
               SUM(CASE WHEN Status = 'VALIDATED' AND Assign_Code IS NULL THEN 1 ELSE 0 END) AS count_pending,
               SUM(CASE WHEN Status = 'ON PROGRESS' THEN 1 ELSE 0 END) AS count_onprogress,
               SUM(CASE WHEN Status = 'COMPLETED' THEN 1 ELSE 0 END) AS count_completed
        FROM tbl_request_rfc
        WHERE validate_code = :nik
        GROUP BY Status
    """, nativeQuery = true)
    List<Object[]> getStatusForManager(@Param("nik") String nik);

    // Untuk SPV
    @Query(value = """
        SELECT Programmer_Code, Programmer_Name, COUNT(Request_ID) AS jml,
               SUM(CASE WHEN Status = 'ON PROGRESS' AND Programmer_Code IS NOT NULL THEN 1 ELSE 0 END) AS onprogress,
               SUM(CASE WHEN Status = 'COMPLETED' THEN 1 ELSE 0 END) AS completed
        FROM tbl_request_rfc
        WHERE Assign_Code = :nik
          AND Programmer_Code IS NOT NULL
        GROUP BY Programmer_Code, Programmer_Name
    """, nativeQuery = true)
    List<Object[]> getTasksForSPV(@Param("nik") String nik);

    // Untuk Manager
    @Query(value = """
        SELECT Assign_Code, Assign_Name, COUNT(Request_ID) AS jml,
               SUM(CASE WHEN Status = 'ON PROGRESS' THEN 1 ELSE 0 END) AS onprogress,
               SUM(CASE WHEN Status = 'COMPLETED' THEN 1 ELSE 0 END) AS completed
        FROM tbl_request_rfc
        WHERE validate_code = :nik
        GROUP BY Assign_Code, Assign_Name
    """, nativeQuery = true)
    List<Object[]> getTasksForManager(@Param("nik") String nik);

    @Query(value = """
            SELECT * 
            FROM tbl_request_rfc 
            WHERE Created_Date BETWEEN :startDate AND :endDate 
              AND (:privilege = '3' AND Assign_Code = :nik OR :privilege = '4') 
              AND (:status = 'ALL' AND Status IN :statuses OR Status = :status) 
            ORDER BY Created_Date DESC
            """, nativeQuery = true)
    List<TblRequestRfc> getRequests(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("nik") String nik,
            @Param("privilege") String privilege,
            @Param("status") String status,
            @Param("statuses") List<String> statuses);
}
