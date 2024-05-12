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

import java.time.LocalDate;
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
        assignCurrentDate(leaveRequestEntity);
        leaveRequestRepository.save(leaveRequestEntity);
    }

    private void assignCurrentDate(LeaveRequestEntity leaveRequestEntity) {
        leaveRequestEntity.setCreateDate(LocalDate.now());
    }

    @Override
    public List<LeaveRequestResponse> listByEmployeeId(Long id) {

        List<LeaveRequestEntity> leaveRequestEntityList = leaveRequestRepository.findAllById(id);
        return LeaveRequestConverter.toResponse(leaveRequestEntityList);
    }


    @Override
    public void updateStatus(LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest) {
        LeaveRequestEntity leaveRequestEntity = leaveRequestRepository.findById(leaveRequestStatusChangeRequest.getId());
        leaveRequestEntity.setStatus(leaveRequestStatusChangeRequest.getStatus());

        leaveRequestRepository.update(leaveRequestEntity);

        new Thread(() -> leaveRequestEmailService.sendLeaveRequestStatusUpdate(leaveRequestEntity)).start();

    }

    @Override
    public List<LeaveRequestResponse> listLeavesOfToday() {
        List<LeaveRequestEntity> leaveRequestEntities = leaveRequestRepository.findLeavesByTodayDate();
        return LeaveRequestConverter.toResponse(leaveRequestEntities);
    }



}
