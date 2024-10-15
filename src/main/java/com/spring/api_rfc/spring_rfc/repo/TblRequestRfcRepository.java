package com.spring.api_rfc.spring_rfc.repo;


import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblRequestRfcRepository extends JpaRepository<TblRequestRfc, Long> {

}
