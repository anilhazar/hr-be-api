package com.spring.model.entity;

import com.spring.model.enums.Status;
import com.spring.model.enums.Type;

import java.time.LocalDate;

public class LeaveRequestEntity {

    private Type type;
    private final LocalDate createDate = LocalDate.now();
    private LocalDate startDate;
    private LocalDate endDate;
    private Long employeeId;
    private Long id;
    private Status status;

    public LeaveRequestEntity() {
    }

    public LeaveRequestEntity(Type type, Status status, LocalDate startDate, LocalDate endDate, Long employeeId) {
        this.type = type;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type gettype() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }


}
