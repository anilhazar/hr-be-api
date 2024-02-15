package com.spring.service.impl;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.response.EmployeeResponse;
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

 /*
    @Override
    public List<EmployeeResponse> findallEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findallEmployee();
        List<EmployeeResponse> employeeDTOs = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeResponse employeeDTO = EmployeeResponse.employeeEntityToEmployeeDTO(employeeEntity);
            employeeDTOs.add(employeeDTO);
        }
        return employeeDTOs;
    } */

    @Override
    public List<EmployeeResponse> findallEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findallEmployee();
        return  EmployeeResponse.employeeEntityToEmployeeResponse(employeeEntities);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        EmployeeEntity employeeEntity = EmployeeCreateRequest.requestToEmployeeEntity(employeeCreateRequest);
        employeeRepository.save(employeeEntity);
        return EmployeeResponse.employeeEntityToEmployeeResponse(employeeEntity);
    }
}
