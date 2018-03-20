package com.connected.oauth2jwt.domain.security.model.user;

import com.connected.oauth2jwt.domain.security.model.role.Role;
import com.connected.oauth2jwt.domain.security.model.role.RoleName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailFactory {

    private UserDetailFactory() {

    }

    public static UserDetail create(User user) {
        return new UserDetail(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt(),
                user.getDateOfBirth(),
                user.getActive(),
                mapToGrantedAuthority(user.getRoles()),
                user.getLastPasswordResetDate());
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(final List<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .map(RoleName::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}