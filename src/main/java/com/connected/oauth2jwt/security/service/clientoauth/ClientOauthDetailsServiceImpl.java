package com.connected.oauth2jwt.security.service.clientoauth;

import com.connected.oauth2jwt.domain.security.model.clientoauth.ClientOauth;
import com.connected.oauth2jwt.domain.security.model.clientoauth.ClientOauthDetailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientOauthDetailsServiceImpl implements ClientDetailsService {

    private final ClientOauthService clientOauthService;

    @Autowired
    public ClientOauthDetailsServiceImpl(ClientOauthService clientOauthService) {
        this.clientOauthService = clientOauthService;
    }

    @Override
    public ClientDetails loadClientByClientId(final String clientId) {
        Optional<ClientOauth> clientOauth = clientOauthService.findClientOauthByClientId(clientId);

        if (clientOauth.isPresent()) {
            return ClientOauthDetailFactory.create(clientOauth.get());
        } else {
            throw new ClientRegistrationException(String.format("No client found with clientId '%s'.", clientId));
        }
    }
}
