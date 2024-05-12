package com.spring.controller;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestStatusChangeRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.service.LeaveRequestService;
import jakarta.validation.Valid;
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

    @GetMapping("employee/leave-requests/{id}")
    public ResponseEntity<List<LeaveRequestResponse>> getLeaveRequests(@PathVariable Long id) {

        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.listByEmployeeId(id);
        return ResponseEntity.ok(leaveRequestResponses);
    }

    @PostMapping("leave-request/status/")
    public ResponseEntity<Void> updateStatus(@Valid @RequestBody LeaveRequestStatusChangeRequest leaveRequestStatusChangeRequest) {
        leaveRequestService.changeStatusById(leaveRequestStatusChangeRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("leave-request/daily")
    public ResponseEntity<List<LeaveRequestResponse>> getDailyLeaves() {
        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.listLeavesOfToday();
        return ResponseEntity.ok(leaveRequestResponses);
    }


}
