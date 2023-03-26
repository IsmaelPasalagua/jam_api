package com.api.chiken.controllers;

import com.api.chiken.model.entities.User;
import com.api.chiken.model.requests.LoginRequest;
import com.api.chiken.model.requests.RegisterRequest;
import com.api.chiken.model.responses.AuthResponse;
import com.api.chiken.model.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(this.authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> register(
            @RequestBody LoginRequest request
    ){
        return ResponseEntity.ok(this.authService.authenticate(request));
    }

    @PostMapping("/user")
    public ResponseEntity<User> get(){
        return ResponseEntity.ok().body(this.authService.user());
    }
}
