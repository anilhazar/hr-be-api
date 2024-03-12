package com.spring.model.dto.request.employee;

import com.spring.model.entity.EmployeeEntity;

public class EmployeeCreateRequest {
    private String firstName;

    private String lastName;

    private String gender;

    private int age;

    private String username;


    public  EmployeeEntity toEmployeeEntity(){
        return new EmployeeEntity(
                this.firstName,
                this.lastName,
                this.gender,
                this.age,
                this.username
        );
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
