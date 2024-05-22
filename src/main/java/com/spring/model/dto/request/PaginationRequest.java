package com.spring.model.dto.request;

import jakarta.validation.constraints.Positive;

public class PaginationRequest {

    @Positive
    private int pageSize;

    @Positive
    private int pageNumber;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

}
