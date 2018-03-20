package com.connected.oauth2jwt.domain.security.model.clientoauth;

import com.connected.oauth2jwt.domain.security.model.authorizedgranttype.AuthorizedGrantTypeOauth;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients_oauth")
public class ClientOauth implements Serializable {

    private static final long serialVersionUID = 4394722967853195601L;

    @Id
    @GeneratedValue(generator = "clientOauth_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "clientOauth_generator", sequenceName = "clients_oauth_id_seq", initialValue = 1)
    private Long id;

    @NotNull
    @Length(min = 1, max = 500)
    @Column(nullable = false, length = 500)
    private String clientId;

    @NotNull
    @Length(min = 1, max = 500)
    @Column(nullable = false, length = 500)
    private String secret;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_authorized_grant_types", joinColumns = @JoinColumn(name = "clients_id"),
            inverseJoinColumns = @JoinColumn(name = "authorized_grant_types_id"))
    private List<AuthorizedGrantTypeOauth> authorizedGrantTypeOauths;

    ClientOauth() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientOauth that = (ClientOauth) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, secret);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<AuthorizedGrantTypeOauth> getAuthorizedGrantTypeOauths() {
        return authorizedGrantTypeOauths;
    }

    public void setAuthorizedGrantTypeOauths(List<AuthorizedGrantTypeOauth> authorizedGrantTypeOauths) {
        this.authorizedGrantTypeOauths = authorizedGrantTypeOauths;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("clientId", clientId)
                .append("secret", secret)
                .toString();
    }
}
