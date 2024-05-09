package com.spring.service.impl;

import com.spring.model.dto.request.authentication.AuthenticationRequest;
import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.AuthenticationService;
import com.spring.util.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final EmployeeRepository employeeRepository;

    public AuthenticationServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void login(AuthenticationRequest authenticationRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeByUsername(authenticationRequest.getUsername());

        if (employeeEntity == null) {
            throw new NoSuchElementException("No employee found with username of: " + authenticationRequest.getUsername());
        }

        String hashedPassword = PasswordEncoder.hash(authenticationRequest.getPassword());

        if (!(Objects.equals(employeeEntity.getPassword(), hashedPassword))) {
            throw new IllegalArgumentException("Incorrect username or password");
        }
    }
}
