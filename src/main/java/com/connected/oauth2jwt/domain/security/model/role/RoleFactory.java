package com.connected.oauth2jwt.domain.security.model.role;

public class RoleFactory {

    private RoleFactory() {

    }

    public static Role createRoleFromName(final RoleName name) {
        return new Role(name);
    }
}
