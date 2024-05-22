package com.spring.model.dto.response;

import com.spring.model.enums.Status;
import com.spring.model.enums.Type;

import java.time.LocalDate;

public class LeaveRequestResponse {

    private final Type type;
    private final Status status;
    private final LocalDate createDate;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public LeaveRequestResponse(Type type, Status status, LocalDate createDate, LocalDate startDate, LocalDate endDate) {
        this.type = type;
        this.status = status;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Type gettype() {
        return type;
    }

    public Status getStatus() {
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
