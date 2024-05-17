package com.spring.service;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestStatusChangeRequest;
import com.spring.model.dto.request.PaginationRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.enums.RequestStatus;

import java.util.List;

public interface LeaveRequestService {
    void create(LeaveRequestCreateRequest leaveRequestCreateRequest);

    void updateStatus(LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest);

    List<LeaveRequestResponse> findByEmployeeId(Long id);

    List<LeaveRequestResponse> findOfTodayDate();

    List<LeaveRequestResponse> findAllByStatus(Long id, RequestStatus requestStatus, PaginationRequest paginationRequest);

}
