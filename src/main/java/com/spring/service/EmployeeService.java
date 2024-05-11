package com.spring.service;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.request.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService  {
    List<EmployeeResponse> findAllEmployee();

    void createEmployee(EmployeeCreateRequest employeeCreateRequest);

    void changeEmployeePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest);

}
