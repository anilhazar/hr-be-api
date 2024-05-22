package com.spring.model.dto.response;

import com.spring.model.enums.RequestStatus;
import com.spring.model.enums.RequestType;

import java.time.LocalDate;

public class LeaveRequestResponse {

    private final RequestType requestType;
    private final RequestStatus status;
    private final LocalDate createDate;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public LeaveRequestResponse(RequestType requestType, RequestStatus status, LocalDate createDate, LocalDate startDate, LocalDate endDate) {
        this.requestType = requestType;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
