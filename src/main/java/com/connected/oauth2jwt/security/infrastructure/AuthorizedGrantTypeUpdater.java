package com.connected.oauth2jwt.security.infrastructure;

import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeName;
import com.connected.oauth2jwt.security.service.authorizedgranttype.AuthorizedGrantTypeService;
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
public class AuthorizedGrantTypeUpdater {

    private AuthorizedGrantTypeService authorizedGrantTypeService;

    @Autowired
    protected AuthorizedGrantTypeUpdater(final AuthorizedGrantTypeService authorizedGrantTypeService) {
        this.authorizedGrantTypeService = authorizedGrantTypeService;
    }

    @EventListener(ContextRefreshedEvent.class)
    private void updateRoles() {
        final List<AuthorizedGrantTypeName> authorizedGrantTypeNames = Arrays.asList(AuthorizedGrantTypeName.class.getEnumConstants());

        createNewsAuthorizedGrantType(authorizedGrantTypeNames);
        deleteUnusedAuthorizedGrantTypes(authorizedGrantTypeNames);
    }

    private void createNewsAuthorizedGrantType(final List<AuthorizedGrantTypeName> authorizedGrantTypeNames) {
        final Predicate<AuthorizedGrantTypeName> exists = authorizedGrantTypeService::existsByAuthorizedGrantTypeName;
        final Consumer<AuthorizedGrantTypeName> insert = authorizedGrantTypeService::insertAuthorizedGrantTypeByAuthorizedGrantTypeName;

        authorizedGrantTypeNames.stream()
                .filter(exists.negate())
                .forEach(insert);
    }

    private void deleteUnusedAuthorizedGrantTypes(final List<AuthorizedGrantTypeName> authorizedGrantTypeNames) {
        final List<String> rolesJoin = authorizedGrantTypeNames.stream()
                .map(AuthorizedGrantTypeName::name)
                .collect(Collectors.toList());

        authorizedGrantTypeService.deleteByNameNotIn(rolesJoin);
    }
}
