CREATE DATABASE datos_personales;
USE datos_personales;

CREATE TABLE `datos_personales`.`table_informacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `amaterno` VARCHAR(45) NOT NULL,
  `apaterno` VARCHAR(45) NOT NULL,
  `edad` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

DELIMITER // 

CREATE PROCEDURE `sp_altaInformacion`(
	nombrex varchar(40),apellidoPaternox varchar(40),apellidoMaternox varchar(40),
	edadx varchar(40),correox varchar(40))
BEGIN 
	INSERT INTO table_informacion (nombre,amaterno,apaterno,edad,
		correo) 
	VALUES (nombrex,apellidoMaternox,apellidoPaternox,edadx,correox);
END 
// DELIMITER ;