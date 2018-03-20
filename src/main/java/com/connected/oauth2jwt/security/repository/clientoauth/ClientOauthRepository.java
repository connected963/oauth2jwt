package com.connected.oauth2jwt.security.repository.clientoauth;

import com.connected.oauth2jwt.domain.security.model.clientoauth.ClientOauth;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClientOauthRepository extends PagingAndSortingRepository<ClientOauth, Long> {

    Optional<ClientOauth> findClientOauthByClientId(String clientId);
}
