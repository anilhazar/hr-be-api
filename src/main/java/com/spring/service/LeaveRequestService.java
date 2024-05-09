package com.spring.service;

import com.spring.model.dto.request.leaverequest.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;

import java.util.List;

public interface LeaveRequestService {
    void createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest);

    List<LeaveRequestResponse> listLeaveRequests(Long id);

}
