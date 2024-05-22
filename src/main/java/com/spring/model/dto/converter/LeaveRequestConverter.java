package com.spring.model.dto.converter;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class LeaveRequestConverter {

    private LeaveRequestConverter() {
    }

    public static LeaveRequestEntity toEntity(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        return new LeaveRequestEntity(
                leaveRequestCreateRequest.gettype(),
                Status.PENDING,
                leaveRequestCreateRequest.getStartDate(),
                leaveRequestCreateRequest.getEndDate(),
                leaveRequestCreateRequest.getEmployeeId()
        );
    }

    public static LeaveRequestResponse toResponse(LeaveRequestEntity leaveRequestEntity) {
        return new LeaveRequestResponse(
                leaveRequestEntity.gettype(),
                leaveRequestEntity.getStatus(),
                LocalDate.now(),
                leaveRequestEntity.getStartDate(),
                leaveRequestEntity.getEndDate()
        );
    }

    public static List<LeaveRequestResponse> toResponse(List<LeaveRequestEntity> leaveRequestEntities) {
        List<LeaveRequestResponse> leaveRequestResponses = new ArrayList<>();
        for (LeaveRequestEntity leaveRequestEntity : leaveRequestEntities) {
            leaveRequestResponses.add(toResponse(leaveRequestEntity));
        }
        return leaveRequestResponses;
    }

}
