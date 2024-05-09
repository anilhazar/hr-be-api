package com.spring.service;

import com.spring.model.dto.request.authentication.AuthenticationRequest;

public interface AuthenticationService {
    void login(AuthenticationRequest authenticationRequest);
}
