package com.connected.oauth2jwt.security.service.authorizedgranttype;

import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeName;
import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeOauth;

import java.util.List;

public interface AuthorizedGrantTypeService {

    AuthorizedGrantTypeOauth insertAuthorizedGrantTypeByAuthorizedGrantTypeName(final AuthorizedGrantTypeName name);

    Boolean existsByAuthorizedGrantTypeName(final AuthorizedGrantTypeName name);

    void deleteByNameNotIn(final List<String> names);
}
