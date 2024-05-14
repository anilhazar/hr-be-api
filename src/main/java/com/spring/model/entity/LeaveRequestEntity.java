package com.spring.model.entity;

import com.spring.model.enums.RequestStatus;
import com.spring.model.enums.RequestType;

import java.time.LocalDate;

public class LeaveRequestEntity {
    private Long id;

    private final RequestType requestType;

    private RequestStatus requestStatus;

    private final LocalDate createDate = LocalDate.now();

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final Long employeeId;

    public LeaveRequestEntity(RequestType requestType, RequestStatus requestStatus, LocalDate startDate, LocalDate endDate, Long employeeId) {
        this.requestType = requestType;
        this.requestStatus = requestStatus;
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

    public RequestStatus getStatus() {
        return requestStatus;
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

    public void setStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
