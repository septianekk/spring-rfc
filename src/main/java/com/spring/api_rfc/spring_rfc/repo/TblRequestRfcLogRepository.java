package com.spring.api_rfc.spring_rfc.repo;

import com.spring.api_rfc.spring_rfc.model.TblRfcLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblRequestRfcLogRepository extends JpaRepository<TblRfcLogs, Long> {
}
