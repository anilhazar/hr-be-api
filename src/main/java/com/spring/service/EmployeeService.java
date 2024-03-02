package com.spring.service;

import com.spring.model.dto.request.employee.EmployeeCreateRequest;
import com.spring.model.dto.request.employee.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService  {
    List<EmployeeResponse> findAllEmployee();

    EmployeeResponse createEmployee(EmployeeCreateRequest employeeCreateRequest);

    void changeEmployeePassword(Long id, EmployeePasswordChangeRequest employeePasswordChangeRequest);

}
