package com.spring.controller;

import com.spring.model.dto.request.employee.EmployeeCreateRequest;
import com.spring.model.dto.request.employee.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService  employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/employees")

    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.findAllEmployee());
    }

    @PostMapping("/employee")
    public ResponseEntity<Void> createEmployee(@RequestBody final EmployeeCreateRequest employeeCreateRequest) {
        employeeService.createEmployee(employeeCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employee/{id}/password")
    public ResponseEntity<Void> changePassword(@PathVariable final Long id, @RequestBody final EmployeePasswordChangeRequest employeePasswordChangeRequest) {
        employeeService.changeEmployeePassword(id, employeePasswordChangeRequest);
        return ResponseEntity.ok().build();
    }



}
