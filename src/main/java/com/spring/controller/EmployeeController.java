package com.spring.controller;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(final EmployeeService  employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.findallEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeCreateRequest employeeCreateRequest) {
        EmployeeResponse employeeResponse = employeeService.createEmployee(employeeCreateRequest);
        return ResponseEntity.ok(employeeResponse);
    }




}
