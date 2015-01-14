create database informacion;
use informacion;

CREATE TABLE `informacion`.`table_genero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `genero` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `informacion`.`table_informacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `amaterno` VARCHAR(45) NOT NULL,
  `apaterno` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `ser_humano` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


insert into table_genero(genero) values("Masculino");
insert into table_genero(genero) values("Femenino");
insert into table_genero(genero) values("Indefinido");
select * from table_genero;


# Stored Procedures

DELIMITER %% 
CREATE PROCEDURE `sp_getGenero`()
BEGIN
	select genero from table_genero;
END %%

DELIMITER // 
CREATE PROCEDURE `sp_altaInformacion`(
	nombrex varchar(40),apellidoPaternox varchar(40),apellidoMaternox varchar(40),
	humanox varchar(40),sexox varchar(40))
BEGIN 
	INSERT INTO table_informacion (nombre,amaterno,apaterno,sexo,
		ser_humano) 
	VALUES (nombrex,apellidoMaternox,apellidoPaternox,humanox,sexox);
END 
// DELIMITER ;

select * from table_informacion;


