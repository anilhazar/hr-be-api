package com.spring.repository.impl;

public class LeaveRequestRepositoryConstants {

    static final String SAVE = "INSERT INTO leave_request "
                             + "(request_type, status, create_date, start_date, end_date, employee_id)"
                             + "VALUES (:requestType, :status, :createDate, :startDate, :endDate, :employeeId)";
}
