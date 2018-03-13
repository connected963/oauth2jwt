package com.connected.oauth2jwt.security.service;

import com.connected.oauth2jwt.domain.security.model.Role;
import com.connected.oauth2jwt.domain.security.model.RoleFactory;
import com.connected.oauth2jwt.domain.security.model.RoleName;
import com.connected.oauth2jwt.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role insertRoleByRoleName(final RoleName name) {
        final Role role = RoleFactory.createRoleFromName(name);

        return roleRepository.save(role);
    }

    @Override
    public Boolean existsByRoleName(final RoleName name) {
        return roleRepository.existsByName(name);
    }

    @Override
    public void deleteByNameNotIn(final List<String> names) {
        roleRepository.deleteByNameNotIn(names);
    }
}
