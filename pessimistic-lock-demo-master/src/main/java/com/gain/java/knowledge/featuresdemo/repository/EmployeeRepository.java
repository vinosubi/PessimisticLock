package com.gain.java.knowledge.featuresdemo.repository;

import com.gain.java.knowledge.featuresdemo.entity.EmployeeEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

   // @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<EmployeeEntity> findByName(String name);
}
