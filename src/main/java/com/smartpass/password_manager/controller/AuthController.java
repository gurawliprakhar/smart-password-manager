package com.smartpass.password_manager.controller;

import com.smartpass.password_manager.DTO.LoginRequest;
import com.smartpass.password_manager.DTO.RegisterRequest;
import com.smartpass.password_manager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String jwt = userService.loginUser(request);
        return ResponseEntity.ok(jwt);
    }

}
