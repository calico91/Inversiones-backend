-- liquibase formatted sql

-- changeset blandon:5

ALTER TABLE imagenes_cliente MODIFY COLUMN base64_data LONGBLOB NOT NULL;





