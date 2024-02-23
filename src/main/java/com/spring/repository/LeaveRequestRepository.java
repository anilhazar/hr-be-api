package com.spring.repository;

import com.spring.model.entity.LeaveRequestEntity;

public interface LeaveRequestRepository {

    LeaveRequestEntity save(LeaveRequestEntity leaveRequestEntity);
}
