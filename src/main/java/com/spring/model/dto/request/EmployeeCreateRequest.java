package com.spring.model.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeCreateRequest {
    @NotBlank
    @Size(min = 2, max = 45)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 45)
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 45)
    private String gender;

    @NotNull
    @Past
    private LocalDate birthday;

    @Positive
    private int age;

    @NotBlank
    @Email
    private String email;


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

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
