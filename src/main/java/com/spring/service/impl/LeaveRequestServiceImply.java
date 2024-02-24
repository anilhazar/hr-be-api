package com.spring.service.impl;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class LeaveRequestServiceImply implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestServiceImply(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    public LeaveRequestEntity createLeaveRequest(LeaveRequestCreateRequest leaveRequestCreateRequest) {
        LeaveRequestEntity leaveRequestEntity =
                LeaveRequestCreateRequest.toLeaveRequestEntity(leaveRequestCreateRequest);
        leaveRequestEntity.setCreateDate(new Date()); // repoya method yaz.
        return leaveRequestRepository.save(leaveRequestEntity);

    }
}
