package com.spring.model.dto.response;

import com.spring.model.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeResponse {
    private String name;
    private String surname;
    private int age;
    private String gender;

    public static EmployeeResponse employeeEntityToEmployeeResponse(EmployeeEntity employeeEntity){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setName(employeeEntity.getName());
        employeeResponse.setSurname(employeeEntity.getSurname());
        employeeResponse.setAge(employeeEntity.getAge());
        employeeResponse.setGender(employeeEntity.getGender());
        return employeeResponse;
    }

    public static List<EmployeeResponse> employeeEntityToEmployeeResponse(List<EmployeeEntity> employeeEntities){
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeResponse employeeResponse = EmployeeResponse.employeeEntityToEmployeeResponse(employeeEntity);
            employeeResponses.add(employeeResponse);
        }
        return employeeResponses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
