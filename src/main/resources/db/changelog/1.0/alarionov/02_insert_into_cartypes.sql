-- liquibase formatted sql
--changeset Andrey:2 labels:insert into car_type
INSERT INTO car_type (name, kind, load_capacity, volume, length, width, height) VALUES
('Газель', null, 1.5, 9.0, 2.8, 1.8, 1.7),
('ЗИЛ-Бычок', null, 3.5, 17.0, 3.7, 2.1, 2.2);