package com.spring.repository.impl.employee;

final class EmployeeRepositoryConstants {

    private EmployeeRepositoryConstants() {
        throw new IllegalStateException("Utility class");
    }
    static final String FIND_ALL = "SELECT id, first_name, last_name, age, gender, username, password FROM employee";

    static final String SAVE = "INSERT INTO employee (first_name, last_name, age, gender, email, username, password)"
            + "VALUES (:firstName, :lastName, :age, :gender, :email, :username, :password)";

    static final String FIND_BY_ID = "SELECT id, first_name, last_name, age, gender, username, password " +
            "FROM employee " +
            "WHERE id = :id";

    static final String UPDATE = "UPDATE employee "
            + "SET first_name = :firstName, last_name = :lastName, age = :age, gender = :gender, email = :email, username = :username, password = :password "
            + "WHERE id = :id";


}
