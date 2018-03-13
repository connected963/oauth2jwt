package com.connected.oauth2jwt.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class UserDetail implements UserDetails {

    private static final long serialVersionUID = 5508845126599046227L;

    private final Long id;

    private final String email;

    private final String username;

    private final String password;

    private final String firstName;

    private final String lastName;

    private final LocalDateTime createdAt;

    private final LocalDate dateOfBirth;

    private final Boolean active;

    private final Collection<? extends GrantedAuthority> authorities;

    private final LocalDateTime lastPasswordResetDate;

    UserDetail(Long id, String email, String username, String password, String firstName, String lastName, LocalDateTime createdAt, LocalDate dateOfBirth, Boolean active, Collection<? extends GrantedAuthority> authorities, LocalDateTime lastPasswordResetDate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public LocalDateTime getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}