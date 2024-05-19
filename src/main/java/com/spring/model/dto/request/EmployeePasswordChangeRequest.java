package com.spring.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public class EmployeePasswordChangeRequest {

    @NotBlank
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
