package com.connected.oauth2jwt.domain.security.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = -6040482976972115208L;

    @Id
    @GeneratedValue(generator = "user_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_generator", sequenceName = "users_id_seq", initialValue = 1)
    private Long id;

    @NotNull
    @Length(max = 255)
    @Column(nullable = false)
    private String email;

    @NotNull
    @Length(max = 255)
    @Column(nullable = false)
    private String username;

    @NotNull
    @NotEmpty
    @Length(max = 500)
    @Column(nullable = false)
    private String password;

    @NotNull
    @NotEmpty
    @Length(max = 255)
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @NotEmpty
    @Length(max = 255)
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateOfBirth;

    @NotNull
    @Column
    private Boolean active;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(active, user.active) &&
                Objects.equals(lastPasswordResetDate, user.lastPasswordResetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, firstName, lastName, createdAt, dateOfBirth, active, lastPasswordResetDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(LocalDateTime lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("email", email)
                .append("username", username)
                .append("password", password)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("createdAt", createdAt)
                .append("dateOfBirth", dateOfBirth)
                .append("active", active)
                .append("lastPasswordResetDate", lastPasswordResetDate)
                .append("roles", roles)
                .toString();
    }
}
