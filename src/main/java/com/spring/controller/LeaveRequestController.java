package com.spring.controller;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestStatusChangeRequest;
import com.spring.model.dto.request.PaginationRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.model.enums.RequestStatus;
import com.spring.service.LeaveRequestService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(final LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping("/leave-request")
    public ResponseEntity<Void> createLeaveRequest(@Valid @RequestBody LeaveRequestCreateRequest leaveRequestCreateRequest) {
        leaveRequestService.create(leaveRequestCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{id}/leave-request")
    public ResponseEntity<List<LeaveRequestResponse>> getLeaveRequests(@PathVariable @Positive Long id) {

        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.listByEmployeeId(id);
        return ResponseEntity.ok(leaveRequestResponses);
    }

    @PutMapping("/leave-request/status")
    public ResponseEntity<Void> updateStatus(@Valid @RequestBody LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest) {
        leaveRequestService.updateStatus(leaveRequestStatusChangeRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/leave-request/daily")
    public ResponseEntity<List<LeaveRequestResponse>> getDailyLeaves() {
        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.listLeavesOfToday();
        return ResponseEntity.ok(leaveRequestResponses);
    }

    @GetMapping("/employee/{id}/leave-request/{status}")
    public ResponseEntity<List<LeaveRequestResponse>> getLeaveRequestsByStatus(@PathVariable @NotNull RequestStatus status,
                                                                               @PathVariable Long id,
                                                                               @RequestBody @Valid PaginationRequest paginationRequest) {
        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.listLeavesByStatus(id, status, paginationRequest);
        return ResponseEntity.ok(leaveRequestResponses);
    }




}
