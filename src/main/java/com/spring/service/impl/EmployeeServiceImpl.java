package com.spring.service.impl;

import com.spring.model.dto.converter.EmployeeConverter;
import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.request.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeEmailService;
import com.spring.service.EmployeeService;
import com.spring.util.PasswordGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeEmailService employeeEmailService;

    private final PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeEmailService employeeEmailService,
                               PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.employeeEmailService = employeeEmailService;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public List<EmployeeResponse> findAll() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        if (employeeEntities.isEmpty()) {
            throw new RuntimeException("No employee found");
        }

        return EmployeeConverter.toResponse(employeeEntities);
    }

    @Override
    public void create(EmployeeCreateRequest employeeCreateRequest) {
        EmployeeEntity employeeEntity = EmployeeConverter.toEntity(employeeCreateRequest);

        Optional<EmployeeEntity> employeeWithSameEmail = employeeRepository.findByEmail(
                employeeCreateRequest.getEmail());
        if (employeeWithSameEmail.isPresent()) {
            throw new RuntimeException("Employee with same email already exists");
        }

        String generatedPassword = PasswordGenerator.generate();
        String encodedPassword = passwordEncoder.encode(generatedPassword);
        employeeEntity.setPassword(encodedPassword);

        employeeEntity.setUsername(generateUsername(employeeEntity));

        employeeRepository.save(employeeEntity);
        new Thread(() -> employeeEmailService.sendUsernameAndPassword(employeeEntity)).start();
    }

    private String generateUsername(EmployeeEntity employeeEntity) {
        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(1000, 99999999);

        return employeeEntity.getfirstName() + randomNumber;
    }

    @Override
    public void changePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Employee found with id of " + id));

        String generatedPassword = employeePasswordChangeRequest.getNewPassword();
        String hashedPassword = passwordEncoder.encode(generatedPassword);
        employeeEntity.setPassword(hashedPassword);

        employeeRepository.update(employeeEntity);

    }


}

