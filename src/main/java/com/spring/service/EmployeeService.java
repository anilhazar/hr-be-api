package com.spring.service;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.request.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService  {
    List<EmployeeResponse> findallEmployee();

    EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest);

    void changeEmployeePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest);

}
