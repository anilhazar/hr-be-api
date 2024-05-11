package com.spring.service.impl;

import com.spring.model.dto.request.AuthenticationRequest;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

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
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeByUsername(authenticationRequest.getUsername());

        if (employeeEntity == null) {
            throw new NoSuchElementException("No employee found with username of: " + authenticationRequest.getUsername());
        }

        String hashedPassword = passwordEncoder.encode(authenticationRequest.getPassword());

        if (!(Objects.equals(employeeEntity.getPassword(), hashedPassword))) {
            throw new IllegalArgumentException("Incorrect username or password");
        }
    }
}
