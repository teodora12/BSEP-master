INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Milica','Matic','user@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Ana', 'Maric','admin@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Main system', 'Main', 'megatravel@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Boston system', 'Boston','bostonsistem@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('London system', 'London', 'londonsistem@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Hong Kong system', 'Hong Kong', 'hongkongsistem@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Reservation micro-service', 'Reservation', 'reservationmicroservice@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Search micro-service', 'Search', 'searchmicroservice@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('User management micro-service', 'User management', 'usermanagementmicroservice@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Client module', 'Client', 'clientmodule@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Eureka server', 'Eureka', 'eurekaserver@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (name, last_name, email,password, enabled) VALUES ('Proxy server', 'Proxy', 'proxyserver@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);



INSERT INTO user (name,email,password, enabled) VALUES ('Ana', 'ana@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );
INSERT INTO user (name,email,password, enabled) VALUES ('Sonja', 'sonja@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );

INSERT INTO role (id, name ) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name ) VALUES (2, 'ROLE_SISTEM_ADMIN');
INSERT INTO role (id, name ) VALUES (3, 'ROLE_SISTEM');
INSERT INTO role (id, name ) VALUES (4, 'ROLE_ADMIN');
INSERT INTO role (id, name ) VALUES (5, 'ROLE_AGENT');

INSERT INTO privilege (id, name) VALUES (1, 'WRITE_CERTIFICATE');
INSERT INTO privilege (id, name) VALUES (2, 'READ_CERTIFICATE');
INSERT INTO privilege (id, name) VALUES (3, 'READ_USER_CERTIFICATE');
INSERT INTO privilege (id, name) VALUES (4, 'READ_CERTIFICATE_RELATIONS');
INSERT INTO privilege (id, name) VALUES (5, 'WRITE_CERTIFICATE_RELATIONS');
INSERT INTO privilege (id, name) VALUES (6, 'READ_CATEGORIES');
INSERT INTO privilege (id, name) VALUES (7, 'READ_TYPES');
INSERT INTO privilege (id, name) VALUES (8, 'READ_ADDITIONAL_SERVICES');
INSERT INTO privilege (id, name) VALUES (9, 'ADD_CATEGORY');
INSERT INTO privilege (id, name) VALUES (10, 'DELETE_CATEGORY');
INSERT INTO privilege (id, name) VALUES (11, 'UPDATE_CATEGORY');
INSERT INTO privilege (id, name) VALUES (12, 'ADD_TYPE');
INSERT INTO privilege (id, name) VALUES (13, 'DELETE_TYPE');
INSERT INTO privilege (id, name) VALUES (14, 'UPDATE_TYPE');
INSERT INTO privilege (id, name) VALUES (15, 'ADD_ADDITIONAL_SERVICES');
INSERT INTO privilege (id, name) VALUES (16, 'DELETE_ADDITIONAL_SERVICES');
INSERT INTO privilege (id, name) VALUES (17, 'UPDATE_ADDITIONAL_SERVICES');
INSERT INTO privilege (id, name) VALUES (18, 'WRITE_RESERVATION');
INSERT INTO privilege (id, name) VALUES (19, 'READ_RESERVATION');
INSERT INTO privilege (id, name) VALUES (20, 'CHANGE_NAME_AND_LAST_NAME');



INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 4);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 5);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 6);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 9);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 10);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 11);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 12);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 13);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 14);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 15);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 16);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 17);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 6);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 7);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 8);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 6);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 7);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 8);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 18);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 19);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 6);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 7);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 8);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 19);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 20);


INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (1, 'United States of America', 'Houston', 'Bellaire Boulevard', '3', 29.6989805, -95.6629681);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (2, 'France', 'Roissy-en-France', 'Dev de Roissy-en-France', '1', 49.0014595, 2.50757950000002);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (3, 'Germany', 'Frankfurt am Main', 'Hugo-Eckener-Ring', '1', 50.05316879999999, 8.578212699999995);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (4, 'Spain', 'Madrid', 'Calle Amador de los Ríos', '3', 40.42707219999999, -3.6915054999999484);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (5, 'Australia', 'Running Creek', 'Kiewa Valley Highway', '11', -36.6845488, 147.13870659999998);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (6, 'France', 'Nice', 'Rue Costes et Bellonte', '1', 43.6675552, 7.210142000000019);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (7, 'Turkey', 'Bakırköy Istanbul', 'Yeşilköy Halkalı Caddesi', '93', 40.9658349, 28.797335799999928);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (8, 'Austria', 'Knittelfeld', 'Austriastraße', '23', 47.2127112, 14.832708300000036);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (9, 'Netherlands', 'Haarlemmermeer', 'Evert van de Beekstraat', '202', 52.3052023, 4.752573699999971);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (10, 'Serbia', 'Novi Sad', 'Novosadskog sajma', '35', 45.2543657, 19.827130399999987);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO user_role (user_id, role_id) VALUES (4, 3);
INSERT INTO user_role (user_id, role_id) VALUES (5, 3);
INSERT INTO user_role (user_id, role_id) VALUES (6, 3);
INSERT INTO user_role (user_id, role_id) VALUES (7, 3);
INSERT INTO user_role (user_id, role_id) VALUES (8, 3);
INSERT INTO user_role (user_id, role_id) VALUES (9, 3);
INSERT INTO user_role (user_id, role_id) VALUES (10, 3);
INSERT INTO user_role (user_id, role_id) VALUES (11, 3);
INSERT INTO user_role (user_id, role_id) VALUES (12, 3);
INSERT INTO user_role (user_id, role_id) VALUES (13, 4);
INSERT INTO user_role (user_id, role_id) VALUES (14, 4);


INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('system', '2049-03-05 01:00:00', true, 'megatravel@yahoo.com', 1, 'megatravel@yahoo.com', '2019-03-05 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq7Yo5Ih17tQCwPA7JjTxAjzYJSyxl3ygHzlutPAFYv9D9UxMr1oyjQHGudbm9dC7JR9baJfbPQ511Nti/RC5atB+3zGtCzH+mbFcOklsb7u69u7CRPgBKmQhc1myChq300gbe3O5uqeet8a0FCBACTYnOxGbl2KWyQHlhBY4qoOVAJnEsUkSrh55EJ/+nQCk9cAkhn4PBJ/XOSXrxuBzt2b/KkB2e5/UDH9syf9mBN2N/uvzYHymNXMnhtxKZNTj39H0oIE/qJx+uPOFpzwRgkvGCupFCa4Vul+FrfoS5kl6T3vmseQIH5NzbbS3grl3ohYS1aF9O1Fg1z82tmihaQIDAQAB', 1, 3);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('boston', '2024-03-06 01:00:00', true, 'megatravel@yahoo.com', 1, 'bostonsistem@yahoo.com', '2019-03-06 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu75XqiEcbsFiA761AQkP+UYcVv5G18EUZMfNkXa8TM473+jJ0yjVkfr7CBKn2om9bnF6bdxGHiXaY15Ro5rvIObmia9y3qiY/AbjcDFn5ZTBHlnK/GclfC3GF0HztEW6F5Wzk9NdnxVI4kaf2aGYaDQgvSF2BB8PTe6wBR07OVkna7AN2QPDoEahE094qPFwGa0h/PwvSywTDdwUoL9KTKiO+raWwsj3SQpLIHsE/RXzejw0Y9Ve3Z+yXZUh8CM4LMObGOKbM1OnYwGupcHzHnsRNC4XBhEw4ttUiYNyWeShHOsoQzuWAD94A8khPEXufSlMgwDTfnlfbt4GX/pY7QIDAQAB', 1, 4);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('hong kong', '2022-03-04 01:00:00', true, 'megatravel@yahoo.com', 1, 'hongkongsistem@yahoo.com', '2019-03-04 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi591+6H2yTVAyPslh6wmmS+hrSKGb4LBG6+fUR7cJyYnIwzH2n5jJV7z8u3GhDmtTJ1AXF3kt3sI7Yu2+sb86LYN628H3pDXAco3tRKv2zv5p91HYBbVQl7bA9zlM+3iMzIdUZpPM6Zrx8jXTwsXyblNNezMJbUc8eGXTpt31KQLNKqrifstJF+UalcrPnahCJIu5gOgjytn3n0GmGzqP3A5q+WBSZAQ8in0NDSGR8F+Xkr62BpoFlE6GyqbZEb7o9VzmhG8zQH2jFGSacvx/poSm74FQ6DH583R6Mhok5CasmgHSxH+10alLqDPxlW6VsdGoc8ujWdcQzBDsPz3zwIDAQAB', 1, 6);

INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('searchmicroservice', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'searchmicroservice@yahoo.com', '2019-06-05 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl/DocwNjeaACyqdASFoqRB90Nzw+vD0PEap8o1VQCAdnUXLW4xiw1kIICE+ujSMbSascDSTf0zpOJGjjQIKLMTvUnJaoGYVvXviYDwsmDwJu4/5XhoB5QFYs/32+ugXXgVoxU1vP+jfqaRbCXveRVcvuV8Bt0Aj25x8XYbEs54G4P9AiP/i2aaE5k1k0oR3svJXVVoH2FdIiAgFYAlvZkk2rOYxZv8CZMxrzp2YF+5FmB+Spcdhd4xahi9FfVFOt7DvTQqUihq0TbhP8RlTvCmXfUrjwNrSI8H/bF65ycnLcx6pF4OI7qJGU1yoqIT/sB9eD7Fl7YWtYrpZmrID5OQIDAQAB', 1, 8);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('reservationmicroservice', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'reservationmicroservice@yahoo.com', '2019-06-05 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgbrxq6k1QvbtfUPBu9PEBy4480nhlPp9lEbjaautIVS2SuaVJQcFwP5EeBbyH6DEg0d/CbwXCQzx7TTITWKaMy9kGwjuB5msHgFVnUtO5KmG7AGWEY3+Rmo4EDoZfx0XK4mvanTKvsdQGgJ7nxKhmVb7UkOmKRvHgGqaEIynSrUfJli0eKE3OvWoWd19dCrf0DhKfTn2KF7vdB6IefQuFT4USTYzQsMVNEONbs+K5MupR0b38VVFo1DfsN4aagpXwINrYC7IKLD02mxCarKI1dZOCPuFNMXlN76evU3sopohoK/pzK2AbVBSS57TXelYCtrIUGrd71CmnzIUUfN1JwIDAQAB', 1, 7);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('usermanagementmicroservice', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'usermanagementmicroservice@yahoo.com', '2019-06-05 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyawMxCsWIrSPXZngFg1jbyIlW7G8fh982pcPI3K+tF4bFSvnLkFHf43Kp3C1QaPRhAuVETvbM67TxBkgaGqPoROFnBJEBYf4RW71LMDZLRDuxBOjCToxUot/OzvSvuokVKAur99IoqOkbd+4QcNmUalMZRYnM63WdFkVgFknw1vno+qLZ+ms+YmrcK+rXj/7+HNhge8l9pV7eM6mhHvJJiSEC6nEXCnpvxx2FTo/U1mol3cJh0mlRBeCTojcHNyQFIhGyfvu+gntafhb1Qt7nlfV0Sep80V2ZlYo4MCS8/+QbM3RSqaIwNYen1Ga3OY34UNYpOvB45+F2lJKttqf0QIDAQAB', 1, 9);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('clientmodule', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'clientmodule@yahoo.com', '2019-06-06 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiQ5/3uGIg1aOjxa8muevQaZW2D6n8fNjUZiEkLMuSIETYHkRjLhU5++HJtL6IWVxayJVwRIUNNbZ9V41G+sqLUwVrUxMsnk7g0lC4R0tbNEZyUraXOAK1CwzE8ud3Tuovr8sM6ZjsbtKAcbx7oXo2LL76tQhO/64Ny/ZceOdG6XpJsJCzsa14vmi2sP9vc1klQD7kgO/ZQTnOw3ETpUM5SrEGAMPCkMRahVgNIoMjyLVHPesT6EFnhhXp8vPahk7VNRt6a4pUt1ZdiYZEMc1Psrf8zTzqKJYaBCBBbl914KTHK3U8U3CmGtyAgwtkOgWJz8L9nRYbJ9mm3GC9ii6CwIDAQAB', 1, 10);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('eurekaserver', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'eurekaserver@yahoo.com', '2019-06-06 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnK6koK3RBZsWLV/ukUJG+O0m0ZVHNuKztqJxJo69wWxurEvsigTbHsn1rjDzZUmsRyWeK8AwCu2jZiRmGjc1Ay1SLGWYQszsXTU6IrosnBW1NNQ3xl85MtlcOPbK7L2uZalXuGyR+NvRXLnwg5CtmRMjWkIyEGnZjp1knHL2D2WxjQ6BsGTVgUc1lLDXppGSVE6cEpaxo67jAOB4/tffk/2T7kUQH1AvUOUmPbrr2s/fX+hzNB5Wg8/LtfgIucDJoPE+WVCpgnb2ZgnA0kY1rWzLeICGBP4CJgQ/UHGbnNXu5sUaEboyYQN2Th8d0nvJ8LAocGNWSnzuttz6WHmm1wIDAQAB', 1, 11);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('proxyserver', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'proxyserver@yahoo.com', '2019-06-06 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp2pcypBNkvdOUjvqV1mDSHmkrS+POzZzzdeMLdrV4PQmlntxqKQUpda/vOHdMrnNYauuPfUkzWB/bToHUbOlIE0rMtowndY+KE4nmK+yxyPhGo0WzwxAWfBbvJm2pqMyN1ggcXq81b1scGTKTK/TpRkkl2FWl579bqlTa4z2j/Pt+TzX/yvV0ZoEdnD3uuklT0J2f42Hd1neQYx9wj1imN+ylI0T0NmfQVlp9qLKqGguQDuZUUENU+49Sm/RQxbJ7XlwpjvmJQePvCSMSYSiOXTOTnYx9GtXk4GLPcKGlmcLnea0viCNQjfisuU8FwWoV+q7Gta63XyR8JPESmKXkQIDAQAB', 1, 12);
INSERT INTO certificate (alias, expiration_date, isca, issued_by, issued_by_id, issued_to, issuing_date, public_key, state, user_id) VALUES ('agentservice', '2024-06-06 01:00:00', false, 'megatravel@yahoo.com', 1, 'londonsistem@yahoo.com', '2019-06-06 01:00:00', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqmehfCkD1XErMiH+fJvlM3kRY4pb3vVhJB8sBf4z3sqgs5H1fshR8OmqTkO3+LvGuvr9p9TxzNzO3Uny4vVACzxJLvVucdwQn+iwgrksuSyqxsSO8Qf7OqaFKJGjdJjp4/dNe0eiHxWTM8jMoL0L+DqanY0+jaLn8f4hPMDx5CEMAkJEfcOydts1aw4wifp8Gi6WydJG8URDkAS+3/n/eLV7zCx8p4B1eyeD1e7sq71SF3TYbDY6Xzr+RLm6Ot0HSZ/OtE8Fy88kLIh4zWWz11ojdauRilISrXB8nrhccRNeyyWqSeyIdmm4FkqwQcavvkY8HZIMuRyAKqOEj/uU5wIDAQAB', 1, 5);




INSERT INTO certificate_status (certificate_id, state) VALUES (1, 1);
INSERT INTO certificate_status (certificate_id, state) VALUES (2, 1);
INSERT INTO certificate_status (certificate_id, state) VALUES (3, 1);



INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (1, 4, 1, 1, 'Houston Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (2, 3, 1, 2, 'Houston Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (3, 2, 1, 3, 'Houston Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (4, 2, 2, 4, 'Houston Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (5, 4, 2, 5, 'Houston Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (6, 2, 1, 1,'Roissy-en-France Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (7, 2, 1, 2,'Roissy-en-France Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (8, 1, 1, 3,'Roissy-en-France Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (9, 3, 1, 4,'Roissy-en-France Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (10, 5, 1, 1,'Frankfurt Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (11, 4, 2, 2,'Frankfurt Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (12, 4, 1, 1,'Madrid hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (13, 4, 2, 2,'Madrid hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (14, 5, 3, 3,'Madrid hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (15, 2, 1, 1,'Running Creek Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (16, 2, 2, 2,'Running Creek Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (17, 1, 2, 3,'Running Creek Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (18, 2, 1, 1,'Nice Hotel');
INSERT INTO troom (id, capacity, floor, room_number, accommodation_name) VALUES (19, 2, 1, 2,'Nice Hotel');

INSERT INTO tadditional_service (id, name) VALUES (1, 'Kitchen');
INSERT INTO tadditional_service (id, name) VALUES (2, 'Parking');
INSERT INTO tadditional_service (id, name) VALUES (3, 'Pets');
INSERT INTO tadditional_service (id, name) VALUES (4, 'Private bathroom');
INSERT INTO tadditional_service (id, name) VALUES (5, 'TV');
INSERT INTO tadditional_service (id, name) VALUES (6, 'WiFi');
INSERT INTO tadditional_service (id, name) VALUES (7, 'Breakfast');
INSERT INTO tadditional_service (id, name) VALUES (8, 'Half board');
INSERT INTO tadditional_service (id, name) VALUES (9, 'All inclusive');
INSERT INTO tadditional_service (id, name) VALUES (10, 'Full Board');

INSERT INTO taccommodation_category (id, name) VALUES (1, '1');
INSERT INTO taccommodation_category (id, name) VALUES (2, '2');
INSERT INTO taccommodation_category (id, name) VALUES (3, '3');
INSERT INTO taccommodation_category (id, name) VALUES (4, '4');
INSERT INTO taccommodation_category (id, name) VALUES (5, '5');
INSERT INTO taccommodation_category (id, name) VALUES (6, 'Non categorized');

INSERT INTO taccommodation_type (id, name) VALUES (1, 'Hotel');
INSERT INTO taccommodation_type (id, name) VALUES (2, 'Bed&Breakfast');
INSERT INTO taccommodation_type (id, name) VALUES (3, 'Apartment');

INSERT INTO tcancellation (id, days, is_enabled) VALUES (1, 5, true);
INSERT INTO tcancellation (id, days, is_enabled) VALUES (2, 10, true);
INSERT INTO tcancellation (id, days, is_enabled) VALUES (3, 7, true);
INSERT INTO tcancellation (id, days, is_enabled) VALUES (4, 3, true);
INSERT INTO tcancellation (id, days, is_enabled) VALUES (5, 0, false);
INSERT INTO tcancellation (id, days, is_enabled) VALUES (6, 0, false);

INSERT INTO agent (email, name, password, username, company_number, is_accepted, surname ) values ('agent1@yahoo.com', 'Agent','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E' ,'agent1@yahoo.com', 1, true, 'Anic' );
INSERT INTO agent (company_number, email, name, password, surname, username, address_id, is_accepted ) VALUES (2334422, 'marija@yahoo.com', 'Marija', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Jankovic', 'marija@yahoo.com', 7, true );
INSERT INTO agent ( company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (5362734, 'pero@yahoo.com', 'Pero', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Peric', 'pero@yahoo.com', 8, true );
INSERT INTO agent ( company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (7724773, 'maja@yahoo.com', 'Maja', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Djuric', 'maja@yahoo.com', 9, true );
INSERT INTO agent ( company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (1443217, 'sara@yahoo.com', 'Sara', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Djordjevic', 'sara@yahoo.com', 10, true );
INSERT INTO agent ( company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (1443217, 'mika@yahoo.com', 'Mika', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Djordjevic', 'mika@yahoo.com', 10, true );


INSERT INTO pricelist (id) VALUES (1);
INSERT INTO pricelist (id) VALUES (2);
INSERT INTO pricelist (id) VALUES (3);
INSERT INTO pricelist (id) VALUES (4);
INSERT INTO pricelist (id) VALUES (5);
INSERT INTO pricelist (id) VALUES (6);

INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (1, 2, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (2, 3, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (3, 4, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (4, 2, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 120);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (5, 3, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 110);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (6, 4, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (7, 2, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 120);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (8, 3, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 110);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (9, 4, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (10, 2, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (11, 3, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (12, 4, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (13, 2, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (14, 3, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (15, 4, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (16, 2, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (17, 3, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (18, 4, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (19, 2, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 120);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (20, 3, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (21, 4, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (22, 2, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 125);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (23, 3, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 110);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (24, 4, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (25, 2, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (26, 3, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (27, 4, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (28, 2, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (29, 3, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (30, 4, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (31, 2, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 115);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (32, 3, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (33, 4, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (34, 2, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (35, 3, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (36, 4, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (37, 1, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (38, 2, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (39, 3, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (40, 1, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (41, 2, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (42, 3, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (43, 1, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 110);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (44, 2, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (45, 3, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (46, 1, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (47, 2, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (48, 3, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (49, 1, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (50, 2, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (51, 3, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (52, 1, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (53, 2, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 50);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (54, 3, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 45);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (55, 1, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (56, 2, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (57, 3, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (58, 1, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (59, 2, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (60, 3, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (61, 1, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (62, 2, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (63, 3, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (64, 1, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (65, 2, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (66, 3, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (67, 1, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (68, 2, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (69, 3, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 45);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (70, 1, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (71, 2, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (72, 3, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 50);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (73, 4, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (74, 5, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 50);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (75, 4, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (76, 5, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (77, 4, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (78, 5, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (79, 4, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (80, 5, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (81, 4, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (82, 5, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (83, 4, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (84, 5, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 50);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (85, 4, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (86, 5, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (87, 4, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (88, 5, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (89, 4, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (90, 5, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (91, 4, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (92, 5, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (93, 4, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (94, 5, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 45);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (95, 4, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (96, 5, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 45);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (97, 4, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (98, 5, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (99, 4, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (100, 5, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (101, 4, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (102, 5, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (103, 4, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (104, 5, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (105, 4, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (106, 5, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (107, 4, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (108, 5, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 55);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (109, 4, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (110, 5, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (111, 4, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (112, 5, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (113, 4, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (114, 5, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 65);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (115, 4, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (116, 5, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (117, 4, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (118, 5, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 50);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (119, 4, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 60);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (120, 5, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 50);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (121, 1, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (122, 2, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (123, 1, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (124, 2, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (125, 1, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 115);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (126, 2, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (127, 1, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 115);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (128, 2, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (129, 1, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (130, 2, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (131, 1, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (132, 2, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 75);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (133, 1, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (134, 2, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (135, 1, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (136, 2, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (137, 1, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (138, 2, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 85);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (139, 1, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (140, 2, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (141, 1, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (142, 2, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (143, 1, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 80);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (144, 2, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 70);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (145, 2, '2019-06-30 14:45:00', '2019-06-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (146, 2, '2019-07-31 14:45:00', '2019-07-01 14:45:00', 115);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (147, 2, '2019-08-31 14:45:00', '2019-08-01 14:45:00', 125);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (148, 2, '2019-09-30 14:45:00', '2019-09-01 14:45:00', 125);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (149, 2, '2019-10-31 14:45:00', '2019-10-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (150, 2, '2019-11-30 14:45:00', '2019-11-01 14:45:00', 95);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (151, 2, '2019-12-31 14:45:00', '2019-12-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (152, 2, '2020-01-31 14:45:00', '2020-01-01 14:45:00', 110);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (153, 2, '2020-02-29 14:45:00', '2020-02-01 14:45:00', 105);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (154, 2, '2020-03-31 14:45:00', '2020-03-01 14:45:00', 100);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (155, 2, '2020-04-30 14:45:00', '2020-04-01 14:45:00', 90);
INSERT INTO item (id, capacity, end_date_period, start_date_period, price) VALUES (156, 2, '2020-05-31 14:45:00', '2020-05-01 14:45:00', 90);


INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 1);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 2);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 3);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 4);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 5);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 6);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 7);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 8);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 9);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 10);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 11);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 12);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 13);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 14);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 15);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 16);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 17);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 18);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 19);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 20);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 21);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 22);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 23);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 24);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 25);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 26);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 27);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 28);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 29);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 30);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 31);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 32);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 33);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 34);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 35);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 36);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 37);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 38);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 39);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 40);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 41);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 42);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 43);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 44);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 45);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 46);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 47);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 48);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 49);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 50);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 51);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 52);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 53);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 54);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 55);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 56);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 57);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 58);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 59);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 60);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 61);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 62);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 63);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 64);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 65);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 66);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 67);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 68);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 69);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 70);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 71);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 72);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 73);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 74);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 75);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 76);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 77);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 78);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 79);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 80);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 81);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 82);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 83);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 84);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 85);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 86);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 87);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 88);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 89);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 90);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 91);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 92);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 93);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 94);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 95);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (3, 96);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 97);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 98);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 99);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 100);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 101);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 102);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 103);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 104);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 105);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 106);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 107);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 108);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 109);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 110);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 111);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 112);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 113);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 114);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 115);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 116);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 117);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 118);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 119);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (4, 120);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 121);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 122);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 123);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 124);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 125);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 126);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 127);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 128);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 129);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 130);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 131);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 132);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 133);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 134);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 135);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 136);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 137);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 138);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 139);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 140);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 141);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 142);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 143);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (5, 144);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 145);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 146);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 147);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 148);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 149);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 150);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 151);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 152);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 153);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 154);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 155);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (6, 156);


INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );


INSERT INTO accommodation (id, name, description, rate, accommodation_category_id, accommodation_type_id, address_id, cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES (1, 'Houston Towers, Downtown Med Ctr, NRG', 'Nice Bed&Breakfast in Houston', 3.8, 3, 2, 1, 1, 15, 15, 1);
INSERT INTO accommodation (id, name, description, rate, accommodation_category_id, accommodation_type_id, address_id, cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES (2, 'ibis Paris CDG Airport', 'Nice hotel in Roissy-en-France', 4.3, 4, 1, 2,  2, 8, 8, 2);
INSERT INTO accommodation (id, name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES (3, 'Adina Apartment Hotel Frankfurt Neue Oper', 'Nice apartment in Frankfurt', 3.2, 3, 3, 3, 3, 9, 9, 3);
INSERT INTO accommodation (id, name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES (4, 'Apartments Airport, Ifema, Wanda', 'Nice apartment in Madrid', 3.9, 6, 3, 4, 4, 13, 13, 4);
INSERT INTO accommodation (id, name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES (5, 'Buckland Valley Views', 'Nice hotel in Running Creek', 4.0, 5, 1, 5, 5, 5, 5, 5);
INSERT INTO accommodation (id, name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES (6, 'Villa L''Aimée', 'Nice Bed&Breakfast in Nice', 4.8, 2, 2, 6,  6, 4, 4, 6);

INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed1.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed11.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed12.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed13.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed14.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed15.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed16.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed16.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed18.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (2, 'hotel1.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (2, 'hotel11.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (2, 'hotel12.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (3, 'ap1.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (3, 'ap11.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (3, 'ap12.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (3, 'ap13.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (3, 'ap14.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (3, 'ap15.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap2.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap21.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap22.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap23.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap24.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap25.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap26.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap27.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap28.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (4, 'ap29.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel2.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel21.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel22.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel23.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel24.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel25.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel26.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (5, 'hotel27.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (6, 'bed2.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (6, 'bed21.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (6, 'bed22.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (6, 'bed23.jpg');
INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (6, 'bed24.jpg');


INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (1, 100, 2);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (2, 0, 4);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (3, 0, 5);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (4, 0, 8);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (5, 150, 9);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (6, 200, 10);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (7, 0, 1);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (8, 0, 2);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (9, 0, 4);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (10, 0, 5);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (11, 0, 6);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (12, 0, 7);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (13, 150, 9);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (14, 150, 10);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (15, 0, 3);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (16, 0, 4);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (17, 0, 7);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (18, 0, 2);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (19, 0, 6);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (20, 100, 8);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (21, 100, 10);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (22, 0, 1);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (23, 0, 4);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (24, 0, 5);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (25, 0, 7);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (26, 0, 9);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (27, 0, 10);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (28, 0, 2);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (29, 0, 4);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (30, 50, 5);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (31, 0, 6);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (32, 0, 8);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (33, 100, 9);
INSERT INTO tadditional_services_with_prices (id, price, additional_services_id) VALUES (34, 100, 10);

INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (1, 1);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (1, 2);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (1, 3);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (1, 4);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (1, 5);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (1, 6);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 7);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 8);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 9);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 10);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 11);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 12);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 13);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (2, 14);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (3, 15);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (3, 16);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (3, 17);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (4, 18);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (4, 19);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (4, 20);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (4, 21);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (5, 22);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (5, 23);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (5, 24);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (5, 25);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (5, 26);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (5, 27);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 28);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 29);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 30);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 31);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 32);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 33);
INSERT INTO accommodation_additional_services_with_prices (accommodation_id, additional_services_with_prices_id) VALUES (6, 34);

INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 1);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 2);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 3);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 4);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 5);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 6);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 7);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 8);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 9);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (3, 10);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (3, 11);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (4, 12);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (4, 13);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (4, 14);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (5, 15);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (5, 16);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (5, 17);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (6, 18);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (6, 19);


INSERT INTO accommodation_agent (accommodation_id, agent_id) VALUES (1, 1);
INSERT INTO accommodation_agent (accommodation_id, agent_id) VALUES (2, 2);
INSERT INTO accommodation_agent (accommodation_id, agent_id) VALUES (3, 3);
INSERT INTO accommodation_agent (accommodation_id, agent_id) VALUES (4, 4);
INSERT INTO accommodation_agent (accommodation_id, agent_id) VALUES (5, 5);
INSERT INTO accommodation_agent (accommodation_id, agent_id) VALUES (6, 6);

-- INSERT INTO message (user_id, agent_id, content) values (1,1, 'poruka');
-- INSERT INTO message (user_id, agent_id, content) values (1,1, 'poruka1');
-- INSERT INTO message (user_id, agent_id, content) values (1,1, 'poruka2');
-- INSERT INTO message (user_id, agent_id, content) values (1,1, 'poruka3');

INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj','naslov poruke','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj1','naslov poruke1','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj2','naslov poruke2','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj3','naslov poruke3','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj5','naslov poruke5','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj4','naslov poruke4','2019-08-06 01:00:00');

INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 490, '2019-03-02 01:00:00', '2019-03-08 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (4, 1, 200, '2019-09-01 01:00:00', '2019-09-04 01:00:00', 3,'created');
insert into reservation (accommodation_id, arrival_date, departure_date, price, user_id, number_of_days_for_cancellation, status) values (2, '2019-03-05 01:00:00', '2019-05-05 01:00:00', 200, 1, 10,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 720, '2019-08-02 01:00:00', '2019-08-11 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 230, '2018-12-06 01:00:00', '2018-12-12 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 820, '2018-11-06 01:00:00', '2018-11-21 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (2, 1, 450, '2018-12-29 01:00:00', '2019-01-05 01:00:00', 10,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (2, 1, 240, '2019-08-06 01:00:00', '2019-08-16 01:00:00', 10,'created');


insert into reservation_room (reservation_id, room_id) VALUES (1, 1);
insert into reservation_room (reservation_id, room_id) VALUES (1, 5);
insert into reservation_room (reservation_id, room_id) VALUES (2, 12);
insert into reservation_room (reservation_id, room_id) VALUES (3, 6);
insert into reservation_room (reservation_id, room_id) VALUES (4, 7);
insert into reservation_room (reservation_id, room_id) VALUES (5, 8);

INSERT INTO reservation_paid_additional_services (reservation_id, paid_additional_services_id) VALUES (1, 2);

--------------------------------------------------------------------------------------------------------------------

INSERT INTO user (name,email,password, enabled) VALUES ('User1', 'user1@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );
INSERT INTO user (name,email,password, enabled) VALUES ('User2', 'user2@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );
INSERT INTO user (email, name, password,enabled) VALUES ('agent11@yahoo.com', 'Agent11', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (email, name, password, enabled) VALUES ('agent22@yahoo.com', 'Agent22', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E',true );
INSERT INTO user (email, name, password,enabled) VALUES ('agent33@yahoo.com', 'Agent33', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );


INSERT INTO address ( country, city, street, street_number, latitude, longitude) VALUES ( '2United States of America', 'Houston', 'Bellaire Boulevard', '3', 29.6989805, -95.6629681);
INSERT INTO address ( country, city, street, street_number, latitude, longitude) VALUES ( '2France', 'Roissy-en-France', 'Dev de Roissy-en-France', '1', 49.0014595, 2.50757950000002);
INSERT INTO address ( country, city, street, street_number, latitude, longitude) VALUES ( '2Germany', 'Frankfurt am Main', 'Hugo-Eckener-Ring', '1', 50.05316879999999, 8.578212699999995);
INSERT INTO address ( country, city, street, street_number, latitude, longitude) VALUES ( '2Spain', 'Madrid', 'Calle Amador de los Ríos', '3', 40.42707219999999, -3.6915054999999484);
INSERT INTO address ( country, city, street, street_number, latitude, longitude) VALUES ( '2Australia', 'Running Creek', 'Kiewa Valley Highway', '11', -36.6845488, 147.13870659999998);


INSERT INTO agent (company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (7724773, 'agent11@yahoo.com', 'Agent11', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Micic', 'agent11@yahoo.com', 11, true );
INSERT INTO agent (company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (1443217, 'agent22@yahoo.com', 'Agent22', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Klicic', 'agent22@yahoo.com', 12, true );
INSERT INTO agent (company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (1443217, 'agent33@yahoo.com', 'Agent33', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Bicic', 'agent33@yahoo.com', 13, true );


INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 4, 1, 101, 'Accommodation Nice');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 3, 1, 201, 'Accommodation Nice');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 2, 1, 301, 'Accommodation Nice');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 2, 2, 401, 'Accommodation Nice');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 4, 2, 151, 'Accommodation Budapest');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 2, 1, 251,'Accommodation Budapest');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 2, 1, 351,'Accommodation Budapest');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 1, 1, 451,'Accommodation Budapest');
INSERT INTO troom ( capacity, floor, room_number, accommodation_name) VALUES ( 3, 1, 551,'Accommodation Budapest');


INSERT INTO tcancellation ( days, is_enabled) VALUES ( 0, false);
INSERT INTO tcancellation ( days, is_enabled) VALUES ( 0, false);


INSERT INTO pricelist (id) VALUES (7);
INSERT INTO pricelist (id) VALUES (8);

INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );


INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (7, 159);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (7, 160);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (7, 161);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (8, 162);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (8, 163);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (8, 164);

INSERT INTO comment(user_id,date,status,content) values (15,'2019-04-05 14:45:00','accepted','Really good accommodation! I will come again :)');
INSERT INTO comment(user_id,date,status,content) values (16,'2019-04-05 14:45:00','accepted','Awful!');
INSERT INTO comment(user_id,date,status,content) values (15,'2019-04-05 14:45:00','accepted','Not bad');
INSERT INTO comment(user_id,date,status,content) values (16,'2019-04-05 14:45:00','accepted','Nice!');
INSERT INTO comment(user_id,date,status,content) values (15,'2019-04-05 14:45:00','waiting','Not bad');
INSERT INTO comment(user_id,date,status,content) values (16,'2019-04-05 14:45:00','waiting','Nice!');



INSERT INTO accommodation ( name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES ( 'Accommodation Nice', 'Accommodation Nice description', 4.0, 4, 1, 14, 7, 15, 10, 7);
INSERT INTO accommodation ( name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES ( 'Accommodation Budapest', 'Accommodation Budapest description', 4.8, 5, 2, 15,  8, 25, 12, 8);


insert into accommodation_comments(accommodation_id, comments_id) values (7,1);
insert into accommodation_comments(accommodation_id, comments_id) values (7,2);
insert into accommodation_comments(accommodation_id, comments_id) values (8,3);
insert into accommodation_comments(accommodation_id, comments_id) values (8,4);
insert into accommodation_comments(accommodation_id, comments_id) values (2,5);
insert into accommodation_comments(accommodation_id, comments_id) values (2,6);


INSERT INTO accommodation_agent(accommodation_id, agent_id) values (7,7);
INSERT INTO accommodation_agent(accommodation_id, agent_id) values (8,8);




INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 100, 2);
INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 0, 4);
INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 0, 5);
INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 0, 8);


INSERT INTO accommodation_additional_services_with_prices(accommodation_id, additional_services_with_prices_id)  values (7,35);
INSERT INTO accommodation_additional_services_with_prices(accommodation_id, additional_services_with_prices_id)  values (7,36);
INSERT INTO accommodation_additional_services_with_prices(accommodation_id, additional_services_with_prices_id)  values (8,37);
INSERT INTO accommodation_additional_services_with_prices(accommodation_id, additional_services_with_prices_id)  values (8,38);


INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (7, 20);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (7, 21);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (7, 22);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (7, 23);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (7, 24);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (8, 25);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (8, 26);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (8, 27);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (8, 28);


INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (15,7,'Content','Subject','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (15,7,'Content1','Subject1','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (16,7,'Content2','Subject2','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (16,7,'Content3','Subject3','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (16,7,'Content5','Subject5','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (15,7,'Content4','Subject4','2019-08-06 01:00:00');


INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (7, 15, 7.4, '2018-08-06 01:00:00', '2018-08-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (7, 15, 200, '2019-09-01 01:00:00', '2019-09-04 01:00:00', 3,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (8, 15, 7.4, '2019-07-06 01:00:00', '2019-07-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (7, 15, 7.4, '2019-06-06 01:00:00', '2019-06-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (7, 15, 7.4, '2019-05-06 01:00:00', '2019-05-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (8, 15, 7.4, '2019-04-06 01:00:00', '2019-04-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (8, 16, 7.4, '2019-03-06 01:00:00', '2019-03-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (7, 16, 7.4, '2019-02-06 01:00:00', '2019-02-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (7, 16, 7.4, '2018-02-06 01:00:00', '2018-02-16 01:00:00', 5,'created');



insert into reservation_room (reservation_id, room_id) VALUES (9, 20);
insert into reservation_room (reservation_id, room_id) VALUES (10, 21);
insert into reservation_room (reservation_id, room_id) VALUES (11, 22);
insert into reservation_room (reservation_id, room_id) VALUES (12, 23);
insert into reservation_room (reservation_id, room_id) VALUES (13, 24);
insert into reservation_room (reservation_id, room_id) VALUES (14, 25);
insert into reservation_room (reservation_id, room_id) VALUES (15, 26);
insert into reservation_room (reservation_id, room_id) VALUES (16, 27);
insert into reservation_room (reservation_id, room_id) VALUES (17, 20);
