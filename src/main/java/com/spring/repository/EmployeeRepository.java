package com.spring.repository;

import com.spring.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeEntity> findallEmployee();

    EmployeeEntity save(EmployeeEntity employeeEntity);

    EmployeeEntity update(EmployeeEntity employeeEntity);

    EmployeeEntity findEmployeeById(Long id);
}
