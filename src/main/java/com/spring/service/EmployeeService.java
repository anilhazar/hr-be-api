package com.spring.service;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.request.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> findAll();

    void create(EmployeeCreateRequest employeeCreateRequest);

    void changePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest);

}
