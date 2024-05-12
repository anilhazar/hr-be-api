package com.spring.model.dto.request;

import com.spring.model.enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LeaveRequestStatusChangeRequest {
    @NotNull
    @Positive
    private Long id;
    @NotNull
    private Status status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
