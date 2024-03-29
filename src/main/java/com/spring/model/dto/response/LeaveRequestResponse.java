package com.spring.model.dto.response;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.time.LocalDate;
import java.util.List;

public class LeaveRequestResponse {

    private RequestType requestType;
    private Status status;
    private LocalDate createDate;
    private LocalDate startDate;
    private LocalDate endDate;

    public static LeaveRequestResponse toResponse(LeaveRequestEntity leaveRequestEntity){
        return new LeaveRequestResponse(
                leaveRequestEntity.getRequestType(),
                leaveRequestEntity.getStatus(),
                leaveRequestEntity.getCreateDate(),
                leaveRequestEntity.getStartDate(),
                leaveRequestEntity.getEndDate());
    }

    public static List<LeaveRequestResponse> toResponse(List<LeaveRequestEntity> leaveRequestEntityList) {
        List<LeaveRequestResponse> leaveRequestResponses = List.of();
        for (LeaveRequestEntity leaveRequestEntity : leaveRequestEntityList) {
            leaveRequestResponses.add(toResponse(leaveRequestEntity));
        }
        return leaveRequestResponses;
    }

    public LeaveRequestResponse(RequestType requestType, Status status, LocalDate createDate, LocalDate startDate, LocalDate endDate) {
        this.requestType = requestType;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
