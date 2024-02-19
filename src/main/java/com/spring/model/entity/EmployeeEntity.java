package com.spring.model.entity;

public class EmployeeEntity {
    private Long id;
    private String name;

    private String surname;

    private String gender;

    private int age;

    private String username;

    private String password;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String surname, String gender,
                          int age, String username, String password) {
        this.name = name;
        this.surname = surname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
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
