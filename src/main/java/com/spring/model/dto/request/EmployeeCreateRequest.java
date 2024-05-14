package com.spring.model.dto.request;

import jakarta.validation.constraints.*;

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
    @Positive
    private Integer age;
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

    public void setAge(@NotNull @Positive Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public @NotNull @Positive Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
