package com.spring.model.dto.request;

import jakarta.validation.constraints.Positive;

public class Pagination {

    @Positive
    private int pageSize;

    @Positive
    private int pageNumber;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
