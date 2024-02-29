package com.spring.repository.impl;

class EmployeeRepositoryConstants {
    static final String FIND_ALL = "SELECT id, name, surname, age, gender, username, password FROM employee";

    static final String SAVE = "INSERT INTO employee (name, surname, age, gender, username, password)"
                             + "VALUES (:name, :surname, :age, :gender, :username, :password)";

    static final String FIND_BY_ID = "SELECT id, name, surname, age, gender, username, password " +
                                     "FROM employee " +
                                     "WHERE id = :id";

    static final String UPDATE = "UPDATE employee "
                               + "SET name = :name, surname = :surname, age = :age, gender = :gender, username = :username, password = :password "
                               + "WHERE id = :id";

}
