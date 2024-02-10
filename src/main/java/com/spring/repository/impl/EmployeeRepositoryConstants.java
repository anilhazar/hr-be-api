package com.spring.repository.impl;

import org.sql2o.Connection;

public class EmployeeRepositoryConstants {
    static final String FIND_ALL = "SELECT id, name, surname, age, gender, username, password FROM employee";
}
