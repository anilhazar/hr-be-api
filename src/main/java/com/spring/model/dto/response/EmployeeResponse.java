package com.spring.model.dto.response;

import com.spring.model.entity.EmployeeEntity;

import java.util.List;

public class EmployeeResponse {
    private String name;
    private String surname;
    private int age;
    private String gender;

    public static EmployeeResponse toResponse(EmployeeEntity employeeEntity){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setName(employeeEntity.getFirstName());
        employeeResponse.setSurname(employeeEntity.getLastName());
        employeeResponse.setAge(employeeEntity.getAge());
        employeeResponse.setGender(employeeEntity.getGender());
        return employeeResponse;
    }

    public static List<EmployeeResponse> toResponse(List<EmployeeEntity> employeeEntities){
        List<EmployeeResponse> employeeResponses = List.of();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeResponse employeeResponse = EmployeeResponse.toResponse(employeeEntity);
            employeeResponses.add(employeeResponse);
        }
        return employeeResponses;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
