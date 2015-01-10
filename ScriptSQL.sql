-- Creamos la base de Datos
create database bd_crud;
-- Usamos la Base de Datos
use bd_crud;

-- Creamos Nuestra Tabla
create table contactos(
   id int auto_increment,
   nombres varchar(100) not null,
   apellidos varchar(100) not null,
   numeros varchar(100) not null,
   primary key (id)
);

-- Insertamos unos Registros de prueba
insert into contactos
	values(null,'David Miguel','Rivero','0426-949.36-60'),
	(null,'El Programador','Llanero','0424-110.11.00');

-- Fin del Script :D
