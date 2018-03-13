package com.connected.oauth2jwt.security.infrastructure;

import com.connected.oauth2jwt.domain.security.model.RoleName;
import com.connected.oauth2jwt.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class RolesUpdater {

    private RoleService roleService;

    @Autowired
    protected RolesUpdater(final RoleService roleService) {
        this.roleService = roleService;
    }

    @EventListener(ContextRefreshedEvent.class)
    private void updateRoles() {
        final List<RoleName> roles = Arrays.asList(RoleName.class.getEnumConstants());

        createNewsRoles(roles);
        deleteUnusedRoles(roles);
    }

    private void createNewsRoles(final List<RoleName> roles) {
        final Predicate<RoleName> exists = roleService::existsByRoleName;
        final Consumer<RoleName> insert = roleService::insertRoleByRoleName;

        roles.stream()
                .filter(exists.negate())
                .forEach(insert);
    }

    private void deleteUnusedRoles(final List<RoleName> roles) {
        final List<String> rolesJoin = roles.stream()
                .map(RoleName::name)
                .collect(Collectors.toList());

        roleService.deleteByNameNotIn(rolesJoin);
    }
}
