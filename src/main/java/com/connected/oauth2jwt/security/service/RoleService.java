package com.connected.oauth2jwt.security.service;

import com.connected.oauth2jwt.domain.security.model.Role;
import com.connected.oauth2jwt.domain.security.model.RoleName;

import java.util.List;

public interface RoleService {

    Role insertRoleByRoleName(final RoleName name);

    Boolean existsByRoleName(final RoleName name);

    void deleteByNameNotIn(final List<String> names);
}
