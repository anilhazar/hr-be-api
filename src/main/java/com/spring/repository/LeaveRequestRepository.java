package com.spring.repository;

import com.spring.model.entity.LeaveRequestEntity;

import java.util.List;
import java.util.Optional;

public interface LeaveRequestRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);

    Optional<LeaveRequestEntity> findById(Long id);

    Optional<List<LeaveRequestEntity>> findAllById(Long id);

    Optional<List<LeaveRequestEntity>> findLeavesByTodayDate();
}
