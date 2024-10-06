package com.spring.api_rfc.spring_rfc.repo;

import com.spring.api_rfc.spring_rfc.model.RefDepartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefDepartementRepository extends JpaRepository<RefDepartement, Long> {

    List<RefDepartement> findByDepartement(String Departement);

}
