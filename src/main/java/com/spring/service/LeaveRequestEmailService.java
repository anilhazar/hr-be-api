package com.spring.service;

import com.spring.model.entity.LeaveRequestEntity;

public interface LeaveRequestEmailService {
    void sendLeaveStatusUpdate(LeaveRequestEntity leaveRequestEntity);
}
