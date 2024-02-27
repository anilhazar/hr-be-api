package com.spring.model.dto.request;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.util.Date;

public class LeaveRequestCreateRequest {
    private RequestType requestType;
    private Date startDate;
    private Date endDate;
    private Long employeeId;

    public static LeaveRequestEntity toLeaveRequestEntity(LeaveRequestCreateRequest leaveRequestCreateRequest){
        return new LeaveRequestEntity(leaveRequestCreateRequest.requestType, Status.pending,
                leaveRequestCreateRequest.startDate, leaveRequestCreateRequest.endDate, leaveRequestCreateRequest.employeeId);
    }

    public RequestType getRequestType() {
        return requestType;
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
}
