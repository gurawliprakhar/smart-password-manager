package com.smartpass.password_manager.repository;


import com.smartpass.password_manager.model.PasswordEntry;
import com.smartpass.password_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordRepository extends JpaRepository<PasswordEntry, Long> {
    List<PasswordEntry> findByUserId(Long userId);
    List<PasswordEntry> findByUser(User user);
}
