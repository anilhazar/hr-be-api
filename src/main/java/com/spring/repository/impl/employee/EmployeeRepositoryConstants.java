package com.spring.repository.impl.employee;

class EmployeeRepositoryConstants {
    static final String FIND_ALL = "SELECT id, first_name, last_name, age, gender, username, password FROM employee";

    static final String SAVE = "INSERT INTO employee (first_name, last_name, age, gender, username, password)"
            + "VALUES (:firstName, :lastName, :age, :gender, :username, :password)";

    static final String FIND_BY_ID = "SELECT id, first_name, last_name, age, gender, username, password " +
            "FROM employee " +
            "WHERE id = :id";

    static final String UPDATE = "UPDATE employee "
            + "SET first_name = :firstName, last_name = :lastName, age = :age, gender = :gender, username = :username, password = :password "
            + "WHERE id = :id";

    private EmployeeRepositoryConstants() {
        throw new IllegalStateException("Utility class");
    }

}
