package com.spring.repository;

import com.spring.model.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<EmployeeEntity> findAll();

    void save(EmployeeEntity employeeEntity);

    void update(EmployeeEntity employeeEntity);

    Optional<EmployeeEntity> findById(Long id);

    Optional<EmployeeEntity> findByUsername(String username);

    Optional<EmployeeEntity> findByEmail(String email);

}
