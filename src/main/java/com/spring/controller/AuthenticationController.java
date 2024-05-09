package com.spring.controller;

import com.spring.model.dto.request.authentication.AuthenticationRequest;
import com.spring.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public ResponseEntity<Void> login(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationService.login(authenticationRequest);
        return ResponseEntity.ok().build();
    }
}