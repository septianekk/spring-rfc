package com.spring.api_rfc.spring_rfc.repo;

import com.spring.api_rfc.spring_rfc.model.RefSystem;
import com.spring.api_rfc.spring_rfc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefSystemRepository extends JpaRepository<RefSystem, Long> {

    List<RefSystem> findBySystemName(String SystemName);

}
