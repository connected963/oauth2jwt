package com.connected.oauth2jwt.security.repository.role;

import com.connected.oauth2jwt.domain.security.model.role.Role;
import com.connected.oauth2jwt.domain.security.model.role.RoleName;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    @RestResource(exported = false)
    Boolean existsByName(RoleName name);

    @RestResource(exported = false)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ROLES WHERE ROLE NOT IN (?1)", nativeQuery = true)
    void deleteByNameNotIn(List<String> names);

    @Override
    @RestResource(exported = false)
    <S extends Role> S save(S role);

    @Override
    @RestResource(exported = false)
    <S extends Role> Iterable<S> saveAll(Iterable<S> roles);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Role role);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Role> roles);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
