package com.spring.service.impl;

import com.spring.model.dto.converter.LeaveRequestConverter;
import com.spring.model.dto.request.leaverequest.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    public void createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        LeaveRequestEntity leaveRequestEntity = LeaveRequestConverter.toEntity(leaveRequestCreateRequest);
        assignCurrentDate(leaveRequestEntity);
        leaveRequestRepository.save(leaveRequestEntity);
    }

    private void assignCurrentDate(LeaveRequestEntity leaveRequestEntity) {
        leaveRequestEntity.setCreateDate(LocalDate.now());
    }

    @Override
    public List<LeaveRequestResponse> listLeaveRequests(Long id) {

        List<LeaveRequestEntity> leaveRequestEntityList = leaveRequestRepository.list(id);
        return LeaveRequestConverter.toResponse(leaveRequestEntityList);
    }


}
