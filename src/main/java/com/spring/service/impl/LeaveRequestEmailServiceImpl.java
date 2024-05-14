package com.spring.service.impl;

import com.spring.model.entity.EmployeeEntity;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmailService;
import com.spring.service.LeaveRequestEmailService;
import org.springframework.stereotype.Service;

@Service
class LeaveRequestEmailServiceImpl implements LeaveRequestEmailService {
    private final EmployeeRepository employeeRepository;
    private final EmailService emailService;

    public LeaveRequestEmailServiceImpl(EmployeeRepository employeeRepository, EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
    }

    @Override
    public void sendLeaveRequestStatusUpdate(LeaveRequestEntity leaveRequestEntity) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(leaveRequestEntity.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("No employee found with id of " + leaveRequestEntity.getId()));
        String email = employeeEntity.getEmail();
        String subject = "Your Leave Information";
        String content = "Dear " + employeeEntity.getFirstName() + ",\n\n"
                + "We are pleased to inform you that your leave request is " + leaveRequestEntity.getStatus().toString().toLowerCase() + "\n\n"
                + "Best regards,\n"
                + "COD Human Resources";
        emailService.send(email, subject, content);
    }
}
