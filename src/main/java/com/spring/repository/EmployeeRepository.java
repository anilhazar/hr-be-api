package com.spring.repository;

import com.spring.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeEntity> findAllEmployee();

    void save(EmployeeEntity employeeEntity);

    void update(EmployeeEntity employeeEntity);

    EmployeeEntity findEmployeeById(Long id);

    EmployeeEntity findEmployeeByUsername(String username);
}
