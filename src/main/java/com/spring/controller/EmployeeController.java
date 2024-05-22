package com.spring.controller;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.request.EmployeePasswordChangeRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/employees")

    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/employee")
    public ResponseEntity<Void> createEmployee(
            @RequestBody @Valid final EmployeeCreateRequest employeeCreateRequest) {
        employeeService.create(employeeCreateRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employee/{id}/password")
    public ResponseEntity<Void> changePassword(@PathVariable final Long id,
                                               @Valid @RequestBody final EmployeePasswordChangeRequest employeePasswordChangeRequest) {
        employeeService.changePassword(id, employeePasswordChangeRequest);
        return ResponseEntity.ok().build();
    }


}
