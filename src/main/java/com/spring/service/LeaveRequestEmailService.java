package com.spring.service;

import com.spring.model.entity.LeaveRequestEntity;

public interface LeaveRequestEmailService {
    void sendLeaveRequestStatusUpdate(LeaveRequestEntity leaveRequestEntity);
}
