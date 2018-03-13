package com.connected.oauth2jwt.security.service;

import com.connected.oauth2jwt.domain.security.model.ClientOauth;

import java.util.Optional;

public interface ClientOauthService {

    Optional<ClientOauth> findClientOauthByClientId(String clientId);
}
