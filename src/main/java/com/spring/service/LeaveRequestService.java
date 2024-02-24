package com.spring.service;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.entity.LeaveRequestEntity;

public interface LeaveRequestService {
    LeaveRequestEntity createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest);
}
