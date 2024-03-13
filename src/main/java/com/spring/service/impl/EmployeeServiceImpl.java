package com.spring.service.impl;

import com.spring.model.dto.request.employee.EmployeeCreateRequest;
import com.spring.model.dto.request.employee.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeService;
import com.spring.util.PasswordEncoder;
import com.spring.util.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeEmailService employeeEmailService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeEmailService employeeEmailService) {
        this.employeeRepository = employeeRepository;
        this.employeeEmailService = employeeEmailService;
    }

    @Override
    public List<EmployeeResponse> findAllEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findallEmployee();
        return  EmployeeResponse.toResponse(employeeEntities);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        EmployeeEntity employeeEntity = employeeCreateRequest.toEmployeeEntity();
        String generatedPassword = PasswordGenerator.generate();
        String hashedPassword = PasswordEncoder.hashPassword(generatedPassword);
        employeeEntity.setPassword(hashedPassword);
        employeeRepository.save(employeeEntity);
        employeeEmailService.sendUsernameAndPassword(employeeEntity);

        return EmployeeResponse.toResponse(employeeEntity);
    }

    @Override
    public void changeEmployeePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(id);
        String generatedPassword = employeePasswordChangeRequest.getNewPassword();
        String hashedPassword = PasswordEncoder.hashPassword(generatedPassword);
        employeeEntity.setPassword(hashedPassword);
        employeeRepository.update(employeeEntity);
        EmployeeResponse.toResponse(employeeEntity);
    }

}
