package com.spring.service;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestStatusChangeRequest;
import com.spring.model.dto.response.LeaveRequestResponse;

import java.util.List;

public interface LeaveRequestService {
    void create(LeaveRequestCreateRequest leaveRequestCreateRequest);

    void updateStatus(LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest);

    List<LeaveRequestResponse> listByEmployeeId(Long id);

    List<LeaveRequestResponse> listLeavesOfToday();

}
