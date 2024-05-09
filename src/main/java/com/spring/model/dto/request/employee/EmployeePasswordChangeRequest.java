package com.spring.model.dto.request.employee;

import jakarta.validation.constraints.NotBlank;

public class EmployeePasswordChangeRequest {
    @NotBlank
    private String newPassword;

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
