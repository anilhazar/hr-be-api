package com.spring.model.dto.response;

public class EmployeeResponse {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final String email;

    public EmployeeResponse(String firstName, String lastName, int age, String gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}
