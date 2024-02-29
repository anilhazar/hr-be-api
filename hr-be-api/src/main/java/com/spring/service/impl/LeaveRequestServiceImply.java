package com.spring.service.impl;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LeaveRequestServiceImply implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestServiceImply(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    public LeaveRequestEntity createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        LeaveRequestEntity leaveRequestEntity = LeaveRequestCreateRequest.toLeaveRequestEntity(leaveRequestCreateRequest);
        assignCurrentDate(leaveRequestEntity);
        return leaveRequestRepository.save(leaveRequestEntity);

    }

    @Override
    public List<LeaveRequestResponse> listLeaveRequests(Long id) {

        List<LeaveRequestEntity> leaveRequestEntityList = leaveRequestRepository.list(id);
        return LeaveRequestResponse.leaveRequestEntityToResponse(leaveRequestEntityList);
    }

    public void assignCurrentDate(LeaveRequestEntity leaveRequestEntity) {
        leaveRequestEntity.setCreateDate(new Date());
    }
}
