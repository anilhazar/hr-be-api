package com.spring.repository;

import com.spring.model.entity.LeaveRequestEntity;

import java.util.List;

public interface LeaveRequestRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);

    LeaveRequestEntity findLeaveRequestsById(Long id);

    List<LeaveRequestEntity> findLeaveRequestByEmployeeId(Long id);

    List<LeaveRequestEntity> findLeavesByTodayDate();
}
