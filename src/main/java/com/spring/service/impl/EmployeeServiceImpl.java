package com.spring.service.impl;

import com.spring.model.dto.converter.EmployeeConverter;
import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.request.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeEmailService;
import com.spring.service.EmployeeService;
import com.spring.util.PasswordEncoder;
import com.spring.util.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeEmailService employeeEmailService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeEmailService employeeEmailService) {
        this.employeeRepository = employeeRepository;
        this.employeeEmailService = employeeEmailService;
    }

    @Override
    public List<EmployeeResponse> findAllEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAllEmployee();
        return EmployeeConverter.toResponse(employeeEntities);
    }

    @Override
    public void createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        EmployeeEntity employeeEntity = EmployeeConverter.toEntity(employeeCreateRequest);


        String generatedPassword = PasswordGenerator.generate();
        String encodedPassword = PasswordEncoder.hash(generatedPassword);
        employeeEntity.setPassword(encodedPassword);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            employeeEntity.setUsername(generateUsername(employeeEntity));
            employeeRepository.save(employeeEntity);
        });

        executor.submit(() -> employeeEmailService.sendUsernameAndPassword(employeeEntity));
        executor.shutdown();
    }

    private String generateUsername(EmployeeEntity employeeEntity) {
        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(1000, 99999999);

        return employeeEntity.getFirstName() + randomNumber;
    }

    @Override
    public void changeEmployeePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(id);

        String generatedPassword = employeePasswordChangeRequest.getNewPassword();
        String hashedPassword = PasswordEncoder.hash(generatedPassword);
        employeeEntity.setPassword(hashedPassword);

        employeeRepository.update(employeeEntity);

    }


}

