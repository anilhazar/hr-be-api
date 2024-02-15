package com.spring.model.dto.request;

import com.spring.model.entity.EmployeeEntity;

public class EmployeeCreateRequest {
    private String name;

    private String surname;

    private String gender;

    private int age;

    private String username;

    private String password;

    public static EmployeeEntity requestToEmployeeEntity(EmployeeCreateRequest employeeCreateRequest){
        return new EmployeeEntity(employeeCreateRequest.name, employeeCreateRequest.surname, employeeCreateRequest.gender,
                employeeCreateRequest.age, employeeCreateRequest.username, employeeCreateRequest.password);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
