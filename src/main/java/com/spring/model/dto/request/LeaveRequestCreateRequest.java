package com.spring.model.dto.request;

import com.spring.model.enums.RequestType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;


public class LeaveRequestCreateRequest {
    @NotNull
    private RequestType requestType;
    @NotBlank
    @FutureOrPresent
    private LocalDate startDate;
    @NotBlank
    @FutureOrPresent
    private LocalDate endDate;
    @NotNull
    @Positive
    private Long employeeId;

    public RequestType getRequestType() {
        return requestType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
