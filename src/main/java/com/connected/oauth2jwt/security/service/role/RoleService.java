package com.connected.oauth2jwt.security.service.role;

import com.connected.oauth2jwt.domain.security.model.role.Role;
import com.connected.oauth2jwt.domain.security.model.role.RoleName;

import java.util.List;

public interface RoleService {

    Role insertRoleByRoleName(final RoleName name);

    Boolean existsByRoleName(final RoleName name);

    void deleteByNameNotIn(final List<String> names);
}
