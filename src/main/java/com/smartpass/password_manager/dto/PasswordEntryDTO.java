package com.smartpass.password_manager.dto;

public class PasswordEntryDTO {

    private Long id;
    private String website;
    private String username;
    private String password; // This holds the decrypted password

    public PasswordEntryDTO() {
    }

    public PasswordEntryDTO(Long id, String website, String username, String password) {
        this.id = id;
        this.website = website;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
