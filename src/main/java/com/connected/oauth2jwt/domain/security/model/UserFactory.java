package com.connected.oauth2jwt.domain.security.model;

public class UserFactory {

    private UserFactory() {

    }

    public static User createEmpty() {

        return new User();
    }
}
