package com.connected.oauth2jwt.security.service.clientoauth;

import com.connected.oauth2jwt.domain.security.model.clientoauth.ClientOauth;
import com.connected.oauth2jwt.security.repository.clientoauth.ClientOauthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientOauthServiceImpl implements ClientOauthService {

    private final ClientOauthRepository clientOauthRepository;

    @Autowired
    public ClientOauthServiceImpl(ClientOauthRepository clientOauthRepository) {
        this.clientOauthRepository = clientOauthRepository;
    }

    @Override
    public Optional<ClientOauth> findClientOauthByClientId(String clientId) {
        return clientOauthRepository.findClientOauthByClientId(clientId);
    }
}
