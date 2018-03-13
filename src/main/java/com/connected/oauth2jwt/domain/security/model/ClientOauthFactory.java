package com.connected.oauth2jwt.domain.security.model;

public class ClientOauthFactory {

    private ClientOauthFactory() {

    }

    public static ClientOauth createEmpty() {

        return new ClientOauth();
    }
}
