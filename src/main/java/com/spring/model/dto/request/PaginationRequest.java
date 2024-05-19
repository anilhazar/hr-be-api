package com.spring.model.dto.request;

import jakarta.validation.constraints.Positive;

public class PaginationRequest {

    @Positive
    private int pageSize;

    @Positive
    private int pageNumber;

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

}
