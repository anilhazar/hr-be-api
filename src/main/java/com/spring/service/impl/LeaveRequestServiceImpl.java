package com.spring.service.impl;

import com.spring.model.dto.request.leaverequest.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    public void createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        LeaveRequestEntity leaveRequestEntity = leaveRequestCreateRequest.toLeaveRequestEntity();
        assignCurrentDate(leaveRequestEntity);
    }

    @Override
    public List<LeaveRequestResponse> listLeaveRequests(Long id) {

        List<LeaveRequestEntity> leaveRequestEntityList = leaveRequestRepository.list(id);
        return LeaveRequestResponse.toResponse(leaveRequestEntityList);
    }

    public void assignCurrentDate(LeaveRequestEntity leaveRequestEntity) {
        leaveRequestEntity.setCreateDate(LocalDate.now());
    }

}
