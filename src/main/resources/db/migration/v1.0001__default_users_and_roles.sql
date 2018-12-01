insert into user_roles(role_id, role_name) values(1,'ADMIN');
insert into user_roles(role_id, role_name) values(2,'DBA');
insert into user_roles(role_id, role_name) values(3,'DEVELOPER');
insert into user_roles(role_id, role_name) values(3,'USER');

insert into user_details(user_id, email_id, enabled, first_name, last_name, user_name, lastpasswordresetdate, password) values(1,'admin@test.com','Y','admin','user','admin@test.com','2018-11-30','$2a$10$Jh5hq5rIO80hvsGFr.gac.A3sI5NkfdxjbgpNKSK06lOvW0TQV/cW');
insert into user_details(user_id, email_id, enabled, first_name, last_name, user_name, lastpasswordresetdate, password) values(2,'dba@test.com','Y','admin','user','dba@test.com','2018-11-30','$2a$10$Jh5hq5rIO80hvsGFr.gac.A3sI5NkfdxjbgpNKSK06lOvW0TQV/cW');

insert into user_roles_mapper(user_id, role_id) values(1,1);
insert into user_roles_mapper(user_id, role_id) values(2,2);