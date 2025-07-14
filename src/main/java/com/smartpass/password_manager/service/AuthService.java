package com.smartpass.password_manager.service;

import com.smartpass.password_manager.dto.LoginRequest;
import com.smartpass.password_manager.dto.SignupRequest;
import com.smartpass.password_manager.dto.JwtResponse;
import com.smartpass.password_manager.model.User;
import com.smartpass.password_manager.repository.UserRepository;
import com.smartpass.password_manager.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    // ✅ Manual constructor to initialize all dependencies
    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
    }

    public String register(SignupRequest signup) {
        User user = new User(signup.getName(), signup.getEmail(),
                passwordEncoder.encode(signup.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    public JwtResponse login(LoginRequest login) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
        );
        String token = jwtUtil.generateToken(login.getEmail());
        return new JwtResponse(token, login.getEmail());
    }
}
