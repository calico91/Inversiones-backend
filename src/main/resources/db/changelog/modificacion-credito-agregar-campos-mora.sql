-- liquibase formatted sql

-- changeset blandon:6

/*
    En esta actualización se agregan dos nuevas columnas a la tabla `credito`:
    - `dias_mora`: Número de días en mora, con un valor por defecto de 0.
    - `valor_mora`: Valor acumulado de la mora, con un valor por defecto de 0.
*/

ALTER TABLE credito
    ADD COLUMN dias_mora INT NOT NULL DEFAULT 0,
    ADD COLUMN valor_mora DOUBLE NOT NULL DEFAULT 0;





