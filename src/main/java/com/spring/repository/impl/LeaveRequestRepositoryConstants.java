package com.spring.repository.impl;

final class LeaveRequestRepositoryConstants {

    private LeaveRequestRepositoryConstants() {
        throw new IllegalStateException("Utility class");
    }

    static final String SAVE = "INSERT INTO leave_request "
            + "(request_type, status, create_date, start_date, end_date, employee_id)"
            + "VALUES (:requestType, :status, :createDate, :startDate, :endDate, :employeeId)";
    static final String FIND_BY_ID = "SELECT id, request_type, status, create_date, start_date, end_date, employee_id "
            + "FROM leave_request "
            + "WHERE id = :id";

    static final String LIST = "SELECT id, request_type, status, create_date, start_date, end_date, employee_id "
            + "FROM leave_request "
            + "WHERE employee_id = :employeeId";


}



