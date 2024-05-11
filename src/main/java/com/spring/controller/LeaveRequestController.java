package com.spring.controller;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.service.LeaveRequestService;
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
    public ResponseEntity<Void> createLeaveRequest(@RequestBody LeaveRequestCreateRequest leaveRequestCreateRequest) {
        leaveRequestService.createLeaveRequest(leaveRequestCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("employee/leave-requests/{id}")
    public ResponseEntity<List<LeaveRequestResponse>> getLeaveRequests(@PathVariable Long id) {

        List<LeaveRequestResponse> leaveRequestResponseList = leaveRequestService.listLeaveRequests(id);
        return ResponseEntity.ok(leaveRequestResponseList);
    }

}
