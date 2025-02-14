-- liquibase formatted sql

-- changeset blandon:7
-- actualiza los valores de 'dias_mora' a 4 y 'valor_mora' a 5000 para todos los registros de la tabla 'credito'.

UPDATE credito
SET dias_mora = 4,
    valor_mora = 5000;





