package com.connected.oauth2jwt.security.service.clientoauth;

import com.connected.oauth2jwt.domain.security.model.clientoauth.ClientOauth;

import java.util.Optional;

public interface ClientOauthService {

    Optional<ClientOauth> findClientOauthByClientId(String clientId);
}
