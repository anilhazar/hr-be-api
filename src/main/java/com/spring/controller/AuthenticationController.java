package com.spring.controller;

import com.spring.model.dto.request.AuthenticationRequest;
import com.spring.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        authenticationService.login(authenticationRequest);
        return ResponseEntity.ok().build();
    }
}
