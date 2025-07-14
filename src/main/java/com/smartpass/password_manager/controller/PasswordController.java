package com.smartpass.password_manager.controller;

import com.smartpass.password_manager.dto.PasswordEntryDTO;
import com.smartpass.password_manager.model.PasswordEntry;
import com.smartpass.password_manager.model.User;
import com.smartpass.password_manager.repository.PasswordRepository;
import com.smartpass.password_manager.repository.UserRepository;
import com.smartpass.password_manager.utils.EncryptionUtil;

import com.smartpass.password_manager.utils.PasswordGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    @Autowired
    private PasswordGeneratorUtil generator;
    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private EncryptionUtil encryptionUtil;

    @Autowired
    private UserRepository userRepository;

    // Get passwords for logged-in user
    @GetMapping
    public List<PasswordEntryDTO> getPasswords(@AuthenticationPrincipal UserDetails userDetails) throws Exception {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        List<PasswordEntry> entries = passwordRepository.findByUser(user);

        // Decrypt passwords before sending back
        return entries.stream().map(entry -> {
            try {
                return new PasswordEntryDTO(
                        entry.getId(),
                        entry.getWebsite(),
                        entry.getUsername(),
                        encryptionUtil.decrypt(entry.getEncryptedPassword())
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    // Save new password entry
    @PostMapping
    public ResponseEntity<?> savePassword(@RequestBody PasswordEntryDTO dto,
                                          @AuthenticationPrincipal UserDetails userDetails) throws Exception {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        PasswordEntry entry = new PasswordEntry();
        entry.setUser(user);
        entry.setWebsite(dto.getWebsite());
        entry.setUsername(dto.getUsername());
        // Encrypt password before saving
        entry.setEncryptedPassword(encryptionUtil.encrypt(dto.getPassword()));

        passwordRepository.save(entry);
        return ResponseEntity.ok("Password saved successfully");
    }

    // Suggest secure password (local AI logic)
    @GetMapping("/suggest")
    public ResponseEntity<String> suggestPassword(
            @RequestParam(defaultValue = "16") int length,
            @RequestParam(defaultValue = "true") boolean symbols) {

        String password = generator.generate(length, symbols);
        return ResponseEntity.ok(password);
    }
}
