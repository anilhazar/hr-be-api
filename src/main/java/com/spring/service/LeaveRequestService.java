package com.spring.service;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestGetByStatusRequest;
import com.spring.model.dto.request.LeaveRequestStatusChangeRequest;
import com.spring.model.dto.response.LeaveRequestResponse;

import java.util.List;

public interface LeaveRequestService {
    void create(LeaveRequestCreateRequest leaveRequestCreateRequest);

    void updateStatus(LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest);

    List<LeaveRequestResponse> findByEmployeeId(Long id);

    List<LeaveRequestResponse> findOfTodayDate();

    List<LeaveRequestResponse> findAllByStatus(LeaveRequestGetByStatusRequest leaveRequestGetByStatusRequest);

}
