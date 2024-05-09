package com.spring.service.impl;

import com.spring.model.entity.EmployeeEntity;
import com.spring.service.EmailService;
import com.spring.service.EmployeeEmailService;
import org.springframework.stereotype.Service;

@Service
class EmployeeEmailServiceImpl implements EmployeeEmailService {

    private final EmailService emailService;

    public EmployeeEmailServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendUsernameAndPassword(EmployeeEntity employeeEntity) {

        String subject = "Your Account Information";
        String content = "Dear " + employeeEntity.getFirstName() + ",\n\n"
                + "We are pleased to inform you that your account has been created successfully. Please find your login credentials below:\n\n"
                + "Username: " + employeeEntity.getUsername() + "\n"
                + "Temporary Password: " + employeeEntity.getPassword() + "\n\n"
                + "Best regards,\n";

        emailService.send(employeeEntity.getEmail(), subject, content);

    }
}
