package com.connected.oauth2jwt.security.service.authorizedgranttype;

import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeFactory;
import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeName;
import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeOauth;
import com.connected.oauth2jwt.security.repository.authorizedgranttype.AuthorizedGrantTypeOauthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizedGrantTypeServiceImpl implements AuthorizedGrantTypeService {


    private AuthorizedGrantTypeOauthRepository authorizedGrantTypeOauthRepository;

    @Autowired
    public AuthorizedGrantTypeServiceImpl(AuthorizedGrantTypeOauthRepository authorizedGrantTypeOauthRepository) {
        this.authorizedGrantTypeOauthRepository = authorizedGrantTypeOauthRepository;
    }

    @Override
    public AuthorizedGrantTypeOauth insertAuthorizedGrantTypeByAuthorizedGrantTypeName(final AuthorizedGrantTypeName name) {
        final AuthorizedGrantTypeOauth authorizedGrantTypeOauth = AuthorizedGrantTypeFactory.createAuthorizedGrantTypeFromName(name);

        return authorizedGrantTypeOauthRepository.save(authorizedGrantTypeOauth);
    }

    @Override
    public Boolean existsByAuthorizedGrantTypeName(final AuthorizedGrantTypeName name) {
        return authorizedGrantTypeOauthRepository.existsByName(name);
    }

    @Override
    public void deleteByNameNotIn(final List<String> names) {
        authorizedGrantTypeOauthRepository.deleteByNameNotIn(names);
    }
}
