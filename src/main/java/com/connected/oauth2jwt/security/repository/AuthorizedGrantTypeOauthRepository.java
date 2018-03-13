package com.connected.oauth2jwt.security.repository;

import com.connected.oauth2jwt.domain.security.model.AuthorizedGrantTypeName;
import com.connected.oauth2jwt.domain.security.model.AuthorizedGrantTypeOauth;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AuthorizedGrantTypeOauthRepository extends PagingAndSortingRepository<AuthorizedGrantTypeOauth, Long> {

    @RestResource(exported = false)
    Boolean existsByName(AuthorizedGrantTypeName name);

    @RestResource(exported = false)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM authorized_grant_types_oauth WHERE AUTHORIZED_GRANT_TYPE NOT IN (?1)", nativeQuery = true)
    void deleteByNameNotIn(List<String> names);

    @Override
    @RestResource(exported = false)
    <S extends AuthorizedGrantTypeOauth> S save(S role);

    @Override
    @RestResource(exported = false)
    <S extends AuthorizedGrantTypeOauth> Iterable<S> saveAll(Iterable<S> authorizedGrantTypeOauths);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(AuthorizedGrantTypeOauth authorizedGrantTypeOauth);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends AuthorizedGrantTypeOauth> authorizedGrantTypeOauths);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
