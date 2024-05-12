package com.spring.model.entity;

public class EmployeeEntity {
    private Long id;
    private final String firstName;

    private final String lastName;

    private final String gender;

    private final int age;

    private final String email;

    private String username;

    private String password;


    public EmployeeEntity(String firstName, String lastName, String gender,
                          int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstname() {
        return firstName;
    }
}
