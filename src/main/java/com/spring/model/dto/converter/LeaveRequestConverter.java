package com.spring.model.dto.converter;

import com.spring.model.dto.request.leaverequest.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.Status;

import java.util.List;

public class LeaveRequestConverter {
    public static LeaveRequestEntity toEntity(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        return new LeaveRequestEntity(
                leaveRequestCreateRequest.getRequestType(),
                Status.PENDING,
                leaveRequestCreateRequest.getStartDate(),
                leaveRequestCreateRequest.getEndDate(),
                leaveRequestCreateRequest.getEmployeeId()
        );
    }

    public static LeaveRequestResponse toResponse(LeaveRequestEntity leaveRequestEntity) {
        return new LeaveRequestResponse(
                leaveRequestEntity.getRequestType(),
                leaveRequestEntity.getStatus(),
                leaveRequestEntity.getCreateDate(),
                leaveRequestEntity.getStartDate(),
                leaveRequestEntity.getEndDate()
        );
    }

    public static List<LeaveRequestResponse> toResponse(List<LeaveRequestEntity> leaveRequestEntityList) {
        List<LeaveRequestResponse> leaveRequestResponses = List.of();
        for (LeaveRequestEntity leaveRequestEntity : leaveRequestEntityList) {
            leaveRequestResponses.add(toResponse(leaveRequestEntity));
        }
        return leaveRequestResponses;
    }

}
