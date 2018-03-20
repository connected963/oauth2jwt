package com.connected.oauth2jwt.security.service.user;

import com.connected.oauth2jwt.domain.security.model.user.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);
}
