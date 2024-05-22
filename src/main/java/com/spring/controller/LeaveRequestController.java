package com.spring.controller;

import com.spring.model.dto.request.LeaveRequestChangeStatusRequest;
import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.dto.request.LeaveRequestGetByStatusRequest;
import com.spring.model.dto.response.LeaveRequestResponse;
import com.spring.service.LeaveRequestService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Void> createLeaveRequest(@Valid @RequestBody LeaveRequestCreateRequest
                                                           leaveRequestCreateRequest) {
        leaveRequestService.create(leaveRequestCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/leave-request/employee/{id}")
    public ResponseEntity<List<LeaveRequestResponse>> getLeaveRequests(@PathVariable @Positive Long id) {

        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.findByEmployeeId(id);
        return ResponseEntity.ok(leaveRequestResponses);
    }

    @PutMapping("/leave-request/status")
    public ResponseEntity<Void> updateStatus(@Valid @RequestBody LeaveRequestChangeStatusRequest
                                                     leaveStatusChangeRequest) {
        leaveRequestService.updateStatus(leaveStatusChangeRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/leave-request/daily")
    public ResponseEntity<List<LeaveRequestResponse>> getDailyLeaves() {
        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.findOfTodayDate();
        return ResponseEntity.ok(leaveRequestResponses);
    }

    @GetMapping("/leave-request")
    public ResponseEntity<List<LeaveRequestResponse>> getLeaveRequestsByStatus(
            @RequestBody @Valid LeaveRequestGetByStatusRequest leaveRequestGetByStatusRequest) {
        List<LeaveRequestResponse> leaveRequestResponses = leaveRequestService.findAllByStatus(leaveRequestGetByStatusRequest);
        return ResponseEntity.ok(leaveRequestResponses);
    }


}
