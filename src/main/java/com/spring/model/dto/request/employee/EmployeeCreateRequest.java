package com.spring.model.dto.request.employee;

import com.spring.model.entity.EmployeeEntity;

public class EmployeeCreateRequest {
    private String name;

    private String surname;

    private String gender;

    private int age;

    private String username;


    public  EmployeeEntity toEmployeeEntity(){
        return new EmployeeEntity(
                this.name,
                this.surname,
                this.gender,
                this.age,
                this.username);
    }

}
