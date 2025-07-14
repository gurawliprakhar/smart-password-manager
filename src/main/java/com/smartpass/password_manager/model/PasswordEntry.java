package com.smartpass.password_manager.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "passwords")
public class PasswordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String website;
    private String username;
    private String encryptedPassword;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
