package com.connected.oauth2jwt.security.service;

import com.connected.oauth2jwt.domain.security.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);
}
