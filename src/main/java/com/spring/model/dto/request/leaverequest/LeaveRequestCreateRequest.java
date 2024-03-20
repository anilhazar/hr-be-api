package com.spring.model.dto.request.leaverequest;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.time.LocalDate;


public class LeaveRequestCreateRequest {
    private RequestType requestType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long employeeId;

    public LeaveRequestEntity toLeaveRequestEntity(){
        return new LeaveRequestEntity(
                this.requestType,
                Status.PENDING,
                this.startDate,
                this.endDate,
                this.employeeId
        );
    }
}
