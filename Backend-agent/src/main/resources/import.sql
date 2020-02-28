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


INSERT INTO user (name,email,password, enabled) VALUES ('User1', 'user1@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );
INSERT INTO user (name,email,password, enabled) VALUES ('User2', 'user2@yahoo.com','$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );

INSERT INTO user (email, name, password,enabled) VALUES ('agent11@yahoo.com', 'Agent11', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true);
INSERT INTO user (email, name, password, enabled) VALUES ('agent22@yahoo.com', 'Agent22', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E',true );
INSERT INTO user (email, name, password,enabled) VALUES ('agent33@yahoo.com', 'Agent33', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', true );

INSERT INTO role (name ) VALUES ('ROLE_AGENT');

INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (1, 'United States of America', 'Houston', 'Bellaire Boulevard', '3', 29.6989805, -95.6629681);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (2, 'France', 'Roissy-en-France', 'Dev de Roissy-en-France', '1', 49.0014595, 2.50757950000002);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (3, 'Germany', 'Frankfurt am Main', 'Hugo-Eckener-Ring', '1', 50.05316879999999, 8.578212699999995);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (4, 'Spain', 'Madrid', 'Calle Amador de los Ríos', '3', 40.42707219999999, -3.6915054999999484);
INSERT INTO address (id, country, city, street, street_number, latitude, longitude) VALUES (5, 'Australia', 'Running Creek', 'Kiewa Valley Highway', '11', -36.6845488, 147.13870659999998);


INSERT INTO agents (company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (7724773, 'agent11@yahoo.com', 'Agent11', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Micic', 'agent11@yahoo.com', 1, true );
INSERT INTO agents (company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (1443217, 'agent22@yahoo.com', 'Agent22', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Klicic', 'agent22@yahoo.com', 2, true );
INSERT INTO agents (company_number, email, name, password, surname, username, address_id, is_accepted) VALUES (1443217, 'agent33@yahoo.com', 'Agent33', '$argon2i$v=19$m=65536,t=2,p=1$zhnA1rxWP8VawiICutflhQ$evRAwV+uGTn8hjnfref5cVEoql0l4Gld6a+EzTRXd1E', 'Bicic', 'agent33@yahoo.com', 3, true );


INSERT INTO privilege (id, name) VALUES (1, 'ALL_MESSAGES');
INSERT INTO privilege (id, name) VALUES (2, 'ALL_RESERVATIONS');
INSERT INTO privilege (id, name) VALUES (3, 'ADD_ROOM');
INSERT INTO privilege (id, name) VALUES (4, 'UPDATE_ROOM');
INSERT INTO privilege (id, name) VALUES (5, 'DELETE_ROOM');
INSERT INTO privilege (id, name) VALUES (6, 'CREATE_RESERVATION');
INSERT INTO privilege (id, name) VALUES (7, 'SENT_MESSAGE');
INSERT INTO privilege (id, name) VALUES (8, 'ALL_ACCOMMODATIONS');
INSERT INTO privilege (id, name) VALUES (9, 'GET_ACCOMMODATION');
INSERT INTO privilege (id, name) VALUES (10, 'CHANGE_STATUS');
INSERT INTO privilege (id, name) VALUES (11, 'GET_ROOM');


INSERT INTO roles_privileges(role_id, privilege_id) values (1,1);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,2);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,3);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,4);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,5);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,6);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,7);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,8);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,9);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,10);
INSERT INTO roles_privileges(role_id, privilege_id) values (1,11);




INSERT INTO agent_role(agent_id, role_id) values (1,1);
INSERT INTO agent_role(agent_id, role_id) values (2,1);
INSERT INTO agent_role(agent_id, role_id) values (3,1);



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


INSERT INTO pricelist (id) VALUES (1);
INSERT INTO pricelist (id) VALUES (2);

INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );
INSERT INTO item(capacity, end_date_period, price, start_date_period) values (4, '2019-04-05 14:45:00', 50.5,'2019-04-01 14:45:00' );


INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 1);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 2);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (1, 3);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 4);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 5);
INSERT INTO pricelist_item (pricelist_id, item_id) VALUES (2, 6);


INSERT INTO tcomment(user_id,date,status,content) values (1,'2019-04-05 14:45:00','accepted','Really good accommodation! I will come again :)');
INSERT INTO tcomment(user_id,date,status,content) values (2,'2019-04-05 14:45:00','accepted','Awful!');
INSERT INTO tcomment(user_id,date,status,content) values (1,'2019-04-05 14:45:00','accepted','Not bad');
INSERT INTO tcomment(user_id,date,status,content) values (2,'2019-04-05 14:45:00','accepted','Nice!');


INSERT INTO accommodation ( name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES ( 'Accommodation Nice', 'Accommodation Nice description', 4.0, 4, 1, 4, 1, 15, 10, 1);
INSERT INTO accommodation ( name, description, rate, accommodation_category_id, accommodation_type_id, address_id,  cancellation_id, capacity, number_of_people_capacity, pricelist_id) VALUES ( 'Accommodation Budapest', 'Accommodation Budapest description', 4.8, 5, 2, 5,  2, 25, 12, 2);


insert into accommodation_comments(accommodation_id, comments_id) values (1,1);
insert into accommodation_comments(accommodation_id, comments_id) values (1,2);
insert into accommodation_comments(accommodation_id, comments_id) values (2,3);
insert into accommodation_comments(accommodation_id, comments_id) values (2,4);


INSERT INTO accommodation_agent(accommodation_id, agent_id) values (1,1);
INSERT INTO accommodation_agent(accommodation_id, agent_id) values (2,2);


-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed1.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed11.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed12.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed13.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed14.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed15.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed16.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed16.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (1, 'bed18.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (2, 'hotel1.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (2, 'hotel11.jpg');
-- INSERT INTO accommodation_picture (accommodation_id, picture) VALUES (2, 'hotel12.jpg');



INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 100, 2);
INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 0, 4);
INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 0, 5);
INSERT INTO tadditional_services_with_prices ( price, additional_services_id) VALUES ( 0, 8);


INSERT INTO accommodation_additional_service_with_prices(accommodation_id, additional_service_with_prices_id) values (1,1);
INSERT INTO accommodation_additional_service_with_prices(accommodation_id, additional_service_with_prices_id) values (1,2);
INSERT INTO accommodation_additional_service_with_prices(accommodation_id, additional_service_with_prices_id) values (2,3);
INSERT INTO accommodation_additional_service_with_prices(accommodation_id, additional_service_with_prices_id) values (2,4);



INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 1);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 2);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 3);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 4);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (1, 5);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 6);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 7);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 8);
INSERT INTO accommodation_room (accommodation_id, room_id) VALUES (2, 9);


INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj','naslov poruke','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj1','naslov poruke1','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (2,1,'sadrzaj2','naslov poruke2','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (2,1,'sadrzaj3','naslov poruke3','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (2,1,'sadrzaj5','naslov poruke5','2019-08-06 01:00:00');
INSERT INTO message(user_id,agent_id,content,subject,date_of_sending) values (1,1,'sadrzaj4','naslov poruke4','2019-08-06 01:00:00');


INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 7.4, '2018-08-06 01:00:00', '2018-08-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 200, '2019-09-01 01:00:00', '2019-09-04 01:00:00', 3,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (2, 1, 7.4, '2019-07-06 01:00:00', '2019-07-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 7.4, '2019-06-06 01:00:00', '2019-06-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 1, 7.4, '2019-05-06 01:00:00', '2019-05-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (2, 1, 7.4, '2019-04-06 01:00:00', '2019-04-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (2, 2, 7.4, '2019-03-06 01:00:00', '2019-03-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 2, 7.4, '2019-02-06 01:00:00', '2019-02-16 01:00:00', 5,'created');
INSERT INTO reservation (accommodation_id, user_id, price, arrival_date, departure_date, number_of_days_for_cancellation, status) values (1, 2, 7.4, '2018-02-06 01:00:00', '2018-02-16 01:00:00', 5,'created');



insert into reservation_room (reservation_id, room_id) VALUES (1, 1);
insert into reservation_room (reservation_id, room_id) VALUES (2, 2);
insert into reservation_room (reservation_id, room_id) VALUES (3, 3);
insert into reservation_room (reservation_id, room_id) VALUES (4, 4);
insert into reservation_room (reservation_id, room_id) VALUES (5, 9);
insert into reservation_room (reservation_id, room_id) VALUES (6, 6);
insert into reservation_room (reservation_id, room_id) VALUES (7, 7);
insert into reservation_room (reservation_id, room_id) VALUES (8, 8);
insert into reservation_room (reservation_id, room_id) VALUES (9, 1);