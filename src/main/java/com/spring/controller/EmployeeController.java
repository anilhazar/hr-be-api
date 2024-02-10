package com.spring.controller;

import com.spring.model.dto.EmployeeDTO;
import com.spring.model.entity.EmployeeEntity;
import com.spring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(final EmployeeService  employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeService.findallEmployee();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setName(employeeEntity.getName());
            employeeDTO.setSurname(employeeEntity.getSurname());
            employeeDTO.setAge(employeeEntity.getAge());
            employeeDTO.setGender(employeeEntity.getGender());
            employeeDTOs.add(employeeDTO);
        }

        return employeeDTOs;
    }



}
