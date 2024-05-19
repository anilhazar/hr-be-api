package com.spring.model.dto.request;

import com.spring.model.enums.RequestStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LeaveRequestStatusChangeRequest {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    private RequestStatus requestStatus;

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Long getId() {
        return id;
    }

    public RequestStatus getStatus() {
        return requestStatus;
    }

}
