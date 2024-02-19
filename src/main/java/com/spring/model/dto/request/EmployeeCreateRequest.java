package com.spring.model.dto.request;

import com.spring.model.entity.EmployeeEntity;

public class EmployeeCreateRequest {
    private String name;

    private String surname;

    private String gender;

    private int age;

    private String username;

    private String password;

    public static EmployeeEntity toEmployeeEntity(EmployeeCreateRequest employeeCreateRequest){
        return new EmployeeEntity(employeeCreateRequest.name, employeeCreateRequest.surname, employeeCreateRequest.gender,
                employeeCreateRequest.age, employeeCreateRequest.username, employeeCreateRequest.password);
    }

}
