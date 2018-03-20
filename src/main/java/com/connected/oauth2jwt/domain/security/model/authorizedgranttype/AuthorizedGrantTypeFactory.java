package com.connected.oauth2jwt.domain.security.model.authorizedgranttype;

public class AuthorizedGrantTypeFactory {

    private AuthorizedGrantTypeFactory() {

    }

    public static AuthorizedGrantTypeOauth createAuthorizedGrantTypeFromName(final AuthorizedGrantTypeName name) {
        return new AuthorizedGrantTypeOauth(name);
    }
}
