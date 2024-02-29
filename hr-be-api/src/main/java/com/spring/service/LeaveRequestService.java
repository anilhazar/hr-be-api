package com.spring.service;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequestEntity createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest);

    List<LeaveRequestResponse> listLeaveRequests(Long id);

    void  assignCurrentDate(LeaveRequestEntity leaveRequestEntity);
}
