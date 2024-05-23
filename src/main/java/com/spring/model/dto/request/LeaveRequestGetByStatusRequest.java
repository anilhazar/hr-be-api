package com.spring.model.dto.request;

import com.spring.model.enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LeaveRequestGetByStatusRequest {
    @NotNull
    private Filter filter;

    @NotNull
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public static class Filter {
        @NotNull
        @Positive
        private Long id;

        @NotNull
        private Status status;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }
}
