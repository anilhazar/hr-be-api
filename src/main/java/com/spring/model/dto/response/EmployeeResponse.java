package com.spring.model.dto.response;

public class EmployeeResponse {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String email;

    public EmployeeResponse(String firstName, String lastName, int age, String gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
