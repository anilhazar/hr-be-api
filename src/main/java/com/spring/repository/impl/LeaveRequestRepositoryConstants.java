package com.spring.repository.impl;

final class LeaveRequestRepositoryConstants {

    static final String SAVE = "INSERT INTO leave_request "
            + "(type, status, create_date, start_date, end_date, employee_id)"
            + "VALUES (:type, :status, :createDate, :startDate, :endDate, :employeeId)";
    static final String UPDATE_BY_ID = "UPDATE leave_request "
            + "SET type = :type, status = :status, "
            + "start_date = :startDate, end_date = :endDate, employee_id = :employeeId "
            + "WHERE id = :id";
    static final String FIND_BY_ID = "SELECT id, type, status, create_date, start_date, end_date, employee_id "
            + "FROM leave_request "
            + "WHERE id = :id";
    static final String FIND_BY_EMPLOYEE = "SELECT id, type, status, create_date, start_date, end_date, employee_id "
            + "FROM leave_request "
            + "WHERE employee_id = :employeeId";
    static final String FIND_BY_DATE = "SELECT id, type, status, create_date, start_date, end_date, employee_id "
            + "FROM leave_request "
            + "WHERE CURRENT_DATE BETWEEN start_date AND end_date";
    static final String FIND_BY_STATUS = "SELECT id, type, status, create_date, start_date, end_date, employee_id "
            + "FROM leave_request "
            + "WHERE employee_id = :employeeId AND status LIKE :status "
            + "ORDER BY id DESC "
            + "LIMIT :limit OFFSET :offset";

    private LeaveRequestRepositoryConstants() {
        throw new IllegalStateException("Utility class");
    }
}



