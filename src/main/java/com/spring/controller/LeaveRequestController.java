package com.spring.controller;

import com.spring.model.dto.request.LeaveRequestCreateRequest;
import com.spring.model.entity.LeaveRequestEntity;
import com.spring.service.LeaveRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(final LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping("/leave-request")
    public ResponseEntity<LeaveRequestEntity> createLeaveRequest (@RequestBody LeaveRequestCreateRequest leaveRequestCreateRequest){
        LeaveRequestEntity leaveRequestEntity = leaveRequestService.createLeaveRequest(leaveRequestCreateRequest);
        return ResponseEntity.ok(leaveRequestEntity);
    }

}
