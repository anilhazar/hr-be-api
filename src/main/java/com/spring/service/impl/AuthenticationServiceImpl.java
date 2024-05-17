package com.spring.service.impl;

import com.spring.model.dto.request.AuthenticationRequest;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void login(AuthenticationRequest authenticationRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeByUsername(authenticationRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Incorrect Username or Password"));

        boolean isCorrect = passwordEncoder.matches(authenticationRequest.getPassword(), employeeEntity.getPassword());

        if (!isCorrect) {
            throw new RuntimeException("Incorrect username or password");
        }
    }
}
