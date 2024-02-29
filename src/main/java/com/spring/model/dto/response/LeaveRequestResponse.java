package com.spring.model.dto.response;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveRequestResponse {

    private RequestType requestType;
    private Status status;
    private Date createDate;
    private Date startDate;
    private Date endDate;

    public static LeaveRequestResponse leaveRequestEntityToResponse(LeaveRequestEntity leaveRequestEntity){
        return new LeaveRequestResponse(leaveRequestEntity.getRequestType(), leaveRequestEntity.getStatus(),
                leaveRequestEntity.getCreateDate(), leaveRequestEntity.getStartDate(), leaveRequestEntity.getEndDate());
    }

    public static List<LeaveRequestResponse> leaveRequestEntityToResponse(List<LeaveRequestEntity> leaveRequestEntityList) {
        List<LeaveRequestResponse> leaveRequestResponses = new ArrayList<>();
        for (LeaveRequestEntity leaveRequestEntity : leaveRequestEntityList) {
            leaveRequestResponses.add(new LeaveRequestResponse(leaveRequestEntity.getRequestType(), leaveRequestEntity.getStatus(),
                    leaveRequestEntity.getCreateDate(), leaveRequestEntity.getStartDate(), leaveRequestEntity.getEndDate()));

        }
        return leaveRequestResponses;
    }

    public LeaveRequestResponse(RequestType requestType, Status status, Date createDate, Date startDate, Date endDate) {
        this.requestType = requestType;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
