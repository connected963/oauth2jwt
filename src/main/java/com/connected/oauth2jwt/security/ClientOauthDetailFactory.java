package com.connected.oauth2jwt.security;

import com.connected.oauth2jwt.domain.security.model.AuthorizedGrantTypeName;
import com.connected.oauth2jwt.domain.security.model.AuthorizedGrantTypeOauth;
import com.connected.oauth2jwt.domain.security.model.ClientOauth;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientOauthDetailFactory {

    private ClientOauthDetailFactory() {

    }

    public static ClientOauthDetail create(ClientOauth clientOauth) {
        return new ClientOauthDetail(
                clientOauth.getClientId(),
                clientOauth.getSecret(),
                mapToAuthorizedGrantTypes(clientOauth.getAuthorizedGrantTypeOauths()));
    }

    private static Set<String> mapToAuthorizedGrantTypes(final List<AuthorizedGrantTypeOauth> authorizedGrantTypeOauths) {
        return authorizedGrantTypeOauths.stream()
                .map(AuthorizedGrantTypeOauth::getName)
                .map(AuthorizedGrantTypeName::name)
                .collect(Collectors.toSet());
    }

}