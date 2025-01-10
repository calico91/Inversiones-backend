-- liquibase formatted sql

-- changeset blandon:3

ALTER TABLE imagenes_cliente
    ADD COLUMN base64_data MEDIUMTEXT NOT NULL;





