package com.spring.service.impl;

import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmailService;
import com.spring.service.EmployeeEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
class EmployeeEmailServiceImpl implements EmployeeEmailService {

    private final EmailService emailService;
    private final EmployeeRepository employeeRepository;

    public EmployeeEmailServiceImpl(EmailService emailService, EmployeeRepository employeeRepository) {
        this.emailService = emailService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void sendUsernameAndPassword(EmployeeEntity employeeEntity) {

        String subject = "Your Account Information";
        String content = "Dear " + employeeEntity.getfirstName() + ",\n\n"
                + "We are pleased to inform you that your account has been created successfully. Please find your login credentials below:\n\n"
                + "Username: " + employeeEntity.getUsername() + "\n"
                + "Temporary Password: " + employeeEntity.getPassword() + "\n\n"
                + "Best regards,\n";

        emailService.send(employeeEntity.getEmail(), subject, content);

    }


    @Scheduled(cron = "0 0 9 * * *")
    private void sendBirthdayEmail() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        if (employeeEntities.isEmpty()) {
            throw new RuntimeException("No employee found");
        }

        LocalDate today = LocalDate.now();

        List<EmployeeEntity> birthdayEmployees = employeeEntities.stream()
                .filter(employeeEntity -> today.getMonth() == employeeEntity.getBirthday().getMonth())
                .filter(employeeEntity -> today.getDayOfMonth() == employeeEntity.getBirthday().getDayOfMonth())
                .toList();

        if (birthdayEmployees.isEmpty()) {
            throw new RuntimeException("No employee have birthday today");
        }

        birthdayEmployees.forEach(employeeEntity -> {
            String subject = "\uD83C\uDF82 Happy Birthday! \uD83C\uDF89";
            String content = "Dear " + employeeEntity.getFirstName() + ",\n"
                    + "On this special day, may your heart be filled with joy, your path be lined with love, "
                    + "and your dreams soar higher than ever. May each moment be a celebration, "
                    + "and may the year ahead bring you countless reasons to smile. \\n\""
                    + "Wishing you a day as bright as your spirit and a year as wonderful as your presence. "
                    + "Cheers to another amazing trip around the sun! \uD83C\uDF1F"
                    + "Best wishes from all of us at Castilla Of Developers A.Ş!\" \uD83C\uDF88\uD83C\uDF81";

            emailService.send(employeeEntity.getEmail(), subject, content);
        });
    }

}
