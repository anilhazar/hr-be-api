package com.spring.repository;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.model.enums.RequestStatus;

import java.util.List;
import java.util.Optional;

public interface LeaveRequestRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);

    Optional<LeaveRequestEntity> findById(Long id);

    List<LeaveRequestEntity> findAllById(Long id);

    List<LeaveRequestEntity> findByTodayDate();

    List<LeaveRequestEntity> findByStatus(Long id, RequestStatus requestStatus, int pageSize, int pageNumber);
}
