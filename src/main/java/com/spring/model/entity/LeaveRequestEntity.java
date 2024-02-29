package com.spring.model.entity;

import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.util.Date;

public class LeaveRequestEntity {
    private Long id;
    private RequestType requestType;
    private Status status;
    private Date createDate;
    private Date startDate;
    private Date endDate;
    private Long employeeId;

    public LeaveRequestEntity(RequestType requestType, Status status, Date startDate, Date endDate, Long employeeId) {
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

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
