package com.connected.oauth2jwt.domain.security.model.authorizedgranttype;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authorized_grant_types_oauth")
public class AuthorizedGrantTypeOauth implements Serializable {

    private static final long serialVersionUID = 4200405355926201062L;

    @Id
    @GeneratedValue(generator = "authorized_grant_type_oauth_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "authorized_grant_type_oauth_generator", sequenceName = "authorized_grant_types_oauth_id_seq", initialValue = 1)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "authorized_grant_type", nullable = false, length = 50)
    private AuthorizedGrantTypeName name;

    AuthorizedGrantTypeOauth(final AuthorizedGrantTypeName name) {
        Objects.requireNonNull(name, "Name can't be null");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizedGrantTypeOauth that = (AuthorizedGrantTypeOauth) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorizedGrantTypeName getName() {
        return name;
    }

    public void setName(AuthorizedGrantTypeName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
