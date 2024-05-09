package com.spring.model.dto.response;

import com.spring.model.enums.RequestType;
import com.spring.model.enums.Status;

import java.time.LocalDate;

public class LeaveRequestResponse {

    private final RequestType requestType;
    private final Status status;
    private final LocalDate createDate;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public LeaveRequestResponse(RequestType requestType, Status status, LocalDate createDate, LocalDate startDate, LocalDate endDate) {
        this.requestType = requestType;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
