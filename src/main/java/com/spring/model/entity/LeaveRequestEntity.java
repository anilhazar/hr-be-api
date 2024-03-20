package com.spring.model.entity;

import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.time.LocalDate;

public class LeaveRequestEntity {
    private Long id;
    private RequestType requestType;
    private Status status;
    private LocalDate createDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long employeeId;

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

    @Override
    public String toString() {
        return "LeaveRequestEntity{" +
                "id=" + id +
                ", requestType=" + requestType +
                ", status=" + status +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employeeId=" + employeeId +
                '}';
    }

}
