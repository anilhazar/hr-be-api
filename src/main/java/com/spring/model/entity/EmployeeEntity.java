package com.spring.model.entity;

public class EmployeeEntity {
    private Long id;
    private String firstName;

    private String lastName;

    private String gender;

    private int age;

    private String username;

    private String password;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstName, String lastName, String gender,
                          int age, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.username = username;
        this.password = password;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
