package com.spring.repository;

import com.spring.model.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<EmployeeEntity> findAllEmployee();

    void save(EmployeeEntity employeeEntity);

    void update(EmployeeEntity employeeEntity);

    Optional<EmployeeEntity> findEmployeeById(Long id);

    Optional<EmployeeEntity> findEmployeeByUsername(String username);
}
