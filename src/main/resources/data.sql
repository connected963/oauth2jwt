INSERT INTO users (id, email, username, password, first_Name, last_Name,
                   created_At, date_Of_Birth, active, last_Password_Reset_Date)
VALUES (nextval('users_id_seq'), 'oauth@oauth.com', 'oauth',
        '$2a$10$mARwXosX/D4e0aklW36fPOFjgZGaVhgrhTz69ZxMVSlJgxMcKfy2O', 'Oauth',
        '2', NOW(), '1997-03-26', TRUE, NOW());

INSERT INTO roles (id, role)
VALUES (nextval('roles_id_seq'), 'ADMIN');

INSERT INTO user_role VALUES (currval('users_id_seq'), currval('roles_id_seq'));


INSERT INTO clients_oauth (id, client_id, secret)
VALUES (nextval('clients_oauth_id_seq'), 'client', 'secret');

INSERT INTO authorized_grant_types_oauth (id, authorized_grant_type)
VALUES (nextval('authorized_grant_types_oauth_id_seq'), 'AUTHORIZATION_CODE');

INSERT INTO client_authorized_grant_types (clients_id, authorized_grant_types_id)
VALUES (1, CURRVAL('authorized_grant_types_oauth_id_seq'));

INSERT INTO authorized_grant_types_oauth (id, authorized_grant_type)
VALUES (nextval('authorized_grant_types_oauth_id_seq'), 'REFRESH_TOKEN');

INSERT INTO client_authorized_grant_types (clients_id, authorized_grant_types_id)
VALUES (1, CURRVAL('authorized_grant_types_oauth_id_seq'));

INSERT INTO authorized_grant_types_oauth (id, authorized_grant_type)
VALUES (nextval('authorized_grant_types_oauth_id_seq'), 'PASSWORD');

INSERT INTO client_authorized_grant_types (clients_id, authorized_grant_types_id)
VALUES (1, CURRVAL('authorized_grant_types_oauth_id_seq'));

INSERT INTO authorized_grant_types_oauth (id, authorized_grant_type)
VALUES (nextval('authorized_grant_types_oauth_id_seq'), 'IMPLICIT');

INSERT INTO client_authorized_grant_types (clients_id, authorized_grant_types_id)
VALUES (1, CURRVAL('authorized_grant_types_oauth_id_seq'));

INSERT INTO authorized_grant_types_oauth (id, authorized_grant_type)
VALUES (nextval('authorized_grant_types_oauth_id_seq'), 'CLIENT_CREDENTIALS');

INSERT INTO client_authorized_grant_types (clients_id, authorized_grant_types_id)
VALUES (1, CURRVAL('authorized_grant_types_oauth_id_seq'));