-- liquibase formatted sql
--changeset Ivan:2 labels:insert into driver
INSERT INTO driver (full_name, phone, passport, passport_issued_by) VALUES
('Водитель 1', '123', '0000-0001', 'bla'),
('Водитель 2', '234', '0000-0002', 'bla');