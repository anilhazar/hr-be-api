package com.spring.service.impl;

import com.spring.model.dto.converter.LeaveRequestConverter;
import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestStatusChangeRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.service.LeaveRequestEmailService;
import com.spring.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    private final LeaveRequestEmailService leaveRequestEmailService;

    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository, LeaveRequestEmailService leaveRequestEmailService) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveRequestEmailService = leaveRequestEmailService;
    }

    @Override
    public void create(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        LeaveRequestEntity leaveRequestEntity = LeaveRequestConverter.toEntity(leaveRequestCreateRequest);
        leaveRequestRepository.save(leaveRequestEntity);
    }


    @Override
    public List<LeaveRequestResponse> listByEmployeeId(Long id) {

        List<LeaveRequestEntity> leaveRequestEntityList = leaveRequestRepository.findAllById(id)
                .orElseThrow(() -> new RuntimeException("No Employee Found with id of " + id));
        return LeaveRequestConverter.toResponse(leaveRequestEntityList);
    }


    @Override
    public void updateStatus(LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest) {

        LeaveRequestEntity leaveRequestEntity = leaveRequestRepository.findById(leaveRequestStatusChangeRequest.getId())
                .orElseThrow(() -> new RuntimeException("No Leaves Found with related Id of "
                        + leaveRequestStatusChangeRequest.getId() + "and RequestStatus of " + leaveRequestStatusChangeRequest.getStatus()));

        if (leaveRequestEntity.getStatus().equals(leaveRequestStatusChangeRequest.getStatus())) {
            throw new IllegalArgumentException("Equal RequestStatus Values Detected, RequestStatus Update Attempt Failed");
        }
        leaveRequestEntity.setStatus(leaveRequestStatusChangeRequest.getStatus());

        leaveRequestRepository.update(leaveRequestEntity);

        new Thread(() -> leaveRequestEmailService.sendLeaveRequestStatusUpdate(leaveRequestEntity)).start();

    }

    @Override
    public List<LeaveRequestResponse> listLeavesOfToday() {
        List<LeaveRequestEntity> leaveRequestEntities = leaveRequestRepository.findLeavesByTodayDate()
                .orElseThrow(() -> new RuntimeException("No Leave found for today"));
        return LeaveRequestConverter.toResponse(leaveRequestEntities);
    }



}
