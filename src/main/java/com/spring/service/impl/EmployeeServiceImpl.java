package com.spring.service.impl;

import com.spring.model.dto.request.employee.EmployeeCreateRequest;
import com.spring.model.dto.request.employee.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponse> findAllEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findallEmployee();
        return  EmployeeResponse.toResponse(employeeEntities);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        EmployeeEntity employeeEntity = employeeCreateRequest.toEmployeeEntity();
        employeeRepository.save(employeeEntity);
        return EmployeeResponse.toResponse(employeeEntity);
    }

    @Override
    public void changeEmployeePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(id);
        employeeEntity.setPassword(employeePasswordChangeRequest.getNewPassword());
        employeeRepository.update(employeeEntity);
        EmployeeResponse.toResponse(employeeEntity);
    }

}
