package com.spring.service;

import com.spring.model.entity.EmployeeEntity;

public interface EmployeeEmailService {
    void sendUsernameAndPassword(EmployeeEntity employeeEntity);
}
