package com.spring.repository;

import com.spring.model.entity.LeaveRequestEntity;

import java.util.List;

public interface LeaveRequestRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);

    LeaveRequestEntity findById(Long id);

    List<LeaveRequestEntity> findAllById(Long id);

    List<LeaveRequestEntity> findLeavesByTodayDate();
}
