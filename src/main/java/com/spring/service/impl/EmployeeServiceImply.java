package com.spring.service.impl;

import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.impl.EmployeeRepositoryImpl;
import com.spring.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImply implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImply(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeEntity> findallEmployee() {

        return employeeRepository.findallEmployee();
    }
}
