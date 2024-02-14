package com.srijanmukherjee.yeetcode.controller;

import com.srijanmukherjee.yeetcode.dto.request.ConfirmationRequest;
import com.srijanmukherjee.yeetcode.dto.request.LoginRequest;
import com.srijanmukherjee.yeetcode.dto.request.RegisterRequest;
import com.srijanmukherjee.yeetcode.dto.response.AuthenticationResponse;
import com.srijanmukherjee.yeetcode.dto.response.ConfirmationResponse;
import com.srijanmukherjee.yeetcode.dto.response.RegistrationResponse;
import com.srijanmukherjee.yeetcode.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/confirm")
    public ResponseEntity<ConfirmationResponse> confirmCode(@RequestBody ConfirmationRequest request) {
        return ResponseEntity.ok(service.confirmCode(request));
    }
}
