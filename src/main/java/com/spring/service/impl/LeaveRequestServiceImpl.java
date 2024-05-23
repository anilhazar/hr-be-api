package com.spring.service.impl;

import com.spring.model.dto.converter.LeaveRequestConverter;
import com.spring.model.dto.request.LeaveRequestChangeStatusRequest;
import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestGetByStatusRequest;
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
    public List<LeaveRequestResponse> findByEmployeeId(Long id) {

        List<LeaveRequestEntity> leaveRequestEntityList = leaveRequestRepository.findAllById(id);

        if (leaveRequestEntityList.isEmpty()) {
            throw new RuntimeException("No leave request found with id: " + id);
        }
        return LeaveRequestConverter.toResponse(leaveRequestEntityList);
    }


    @Override
    public void updateStatus(LeaveRequestChangeStatusRequest leaveStatusChangeRequest) {

        LeaveRequestEntity leaveRequestEntity = leaveRequestRepository.findById(leaveStatusChangeRequest.getId())
                .orElseThrow(() -> new RuntimeException("No Leaves Found with related Id of "
                        + leaveStatusChangeRequest.getId()
                        + "and status of "
                        + leaveStatusChangeRequest.getStatus()));

        if (leaveRequestEntity.getStatus().equals(leaveStatusChangeRequest.getStatus())) {
            throw new RuntimeException("Equal status Values Detected, status Update Attempt Failed");
        }
        leaveRequestEntity.setStatus(leaveStatusChangeRequest.getStatus());

        leaveRequestRepository.update(leaveRequestEntity);

        new Thread(() -> leaveRequestEmailService.sendLeaveStatusUpdate(leaveRequestEntity)).start();

    }

    @Override
    public List<LeaveRequestResponse> findOfTodayDate() {
        List<LeaveRequestEntity> leaveRequestEntities = leaveRequestRepository.findByTodayDate();

        if (leaveRequestEntities.isEmpty()) {
            throw new RuntimeException("No Leaves with Date of Today Found ");
        }

        return LeaveRequestConverter.toResponse(leaveRequestEntities);
    }

    @Override
    public List<LeaveRequestResponse> findAllByStatus(LeaveRequestGetByStatusRequest leaveRequestGetByStatusRequest) {
        List<LeaveRequestEntity> leaveRequestEntities = leaveRequestRepository.findByStatus(
                leaveRequestGetByStatusRequest.getFilter().getId(),
                leaveRequestGetByStatusRequest.getFilter().getStatus(),
                leaveRequestGetByStatusRequest.getPaginationRequest().getPageSize(),
                leaveRequestGetByStatusRequest.getPaginationRequest().getPageNumber());

        if (leaveRequestEntities.isEmpty()) {
            throw new RuntimeException("No Leaves with status of: " + leaveRequestGetByStatusRequest.getFilter().getStatus() + " and "
                    + "id of: " + leaveRequestGetByStatusRequest.getFilter().getId() + " found");
        }

        return LeaveRequestConverter.toResponse(leaveRequestEntities);

    }



}
