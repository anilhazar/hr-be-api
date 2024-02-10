package com.spring.repository;

import com.spring.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeEntity> findallEmployee();
}
