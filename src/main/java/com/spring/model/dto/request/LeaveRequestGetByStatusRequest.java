package com.spring.model.dto.request;

import com.spring.model.enums.RequestStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LeaveRequestGetByStatusRequest {
    @NotNull
    private Filter filter;

    @NotNull
    private PaginationRequest paginationRequest;

    public @NotNull PaginationRequest getPagination() {
        return paginationRequest;
    }

    public void setPagination(@NotNull PaginationRequest paginationRequest) {
        this.paginationRequest = paginationRequest;
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
        private RequestStatus requestStatus;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public RequestStatus getStatus() {
            return requestStatus;
        }

        public void setStatus(RequestStatus requestStatus) {
            this.requestStatus = requestStatus;
        }
    }
}
