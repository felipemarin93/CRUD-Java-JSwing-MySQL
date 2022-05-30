create database empresaIUD;

use empresaIUD;

create table empleados(
    cedula varchar(50) not null,
    nombre varchar (100) not null,
    apellido varchar(100) not null,
    correo varchar(100) not null,
    cargo varchar(100) not null,
    primary key(cedula)
);

-- JDBC