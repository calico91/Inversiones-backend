-- liquibase formatted sql

-- changeset blandon:2

/*ALTER TABLE `permisos`
    ADD COLUMN `endpoint` VARCHAR(50) NULL AFTER `descripcion`;*/

create table imagenes_cliente
(
    id          integer not null auto_increment,
    descripcion varchar(100),
    id_cliente  integer,
    primary key (id)
) engine=InnoDB;

alter table imagenes_cliente
    add constraint FKaep8h59p2fk0xoll7uovpm3ey
        foreign key (id_cliente)
            references cliente (id_cliente);





