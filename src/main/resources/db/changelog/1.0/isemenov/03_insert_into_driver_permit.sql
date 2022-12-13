-- liquibase formatted sql
--changeset Ivan:2 labels:insert into driver
INSERT INTO driver_permit (driver_id, permit_id) VALUES
(1, '123'),
(2, '345'),
(1, '234');