package com.spring.repository;

import com.spring.model.entity.LeaveRequestEntity;

import java.util.List;

public interface LeaveRequestRepository {

    LeaveRequestEntity save(LeaveRequestEntity leaveRequestEntity);

    LeaveRequestEntity findLeaveRequestsById(Long id);

    List<LeaveRequestEntity> list(Long id);
}
