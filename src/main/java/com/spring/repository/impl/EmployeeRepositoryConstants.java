package com.spring.repository.impl;

final class EmployeeRepositoryConstants {

    static final String FIND_ALL = "SELECT id, first_name, last_name, age, birthday, gender, username, password FROM employee";
    static final String SAVE = "INSERT INTO employee (first_name, last_name, age, gender, birthday, email, username, password)"
            + "VALUES (:firstName, :lastName, :age, :gender, :birthday, :email, :username, :password)";
    static final String FIND_BY_ID = "SELECT id, first_name, last_name, age, birthday, gender, username, password " +
            "FROM employee " +
            "WHERE id = :id";
    static final String UPDATE_BY_ID = "UPDATE employee "
            + "SET first_name = :firstName, last_name = :lastName, age = :age, birthday = :birthday, gender = :gender, email = :email, username = :username, password = :password "
            + "WHERE id = :id";
    static final String FIND_BY_USERNAME = "SELECT id, first_name, last_name, age, birthday, gender, username, password " +
            "FROM employee " +
            "WHERE username = :username";

    private EmployeeRepositoryConstants() {
        throw new IllegalStateException("Utility class");
    }

}
