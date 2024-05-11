package com.spring.model.entity;

import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.time.LocalDate;

public class LeaveRequestEntity {
    private Long id;

    private final RequestType requestType;

    private final Status status;

    private LocalDate createDate;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final Long employeeId;

    public LeaveRequestEntity(RequestType requestType, Status status, LocalDate startDate, LocalDate endDate, Long employeeId) {
        this.requestType = requestType;
        this.status=status;
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

    public RequestType getRequestType() {
        return requestType;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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
