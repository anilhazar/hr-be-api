package com.spring.model.entity;

import java.time.LocalDate;

public class EmployeeEntity {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthday;
    private int age;
    private String email;
    private Long id;
    private String username;
    private String password;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstName, String lastName, String gender,
                          LocalDate birthday, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirstName() {
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

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
