create database informacion; #Creamos la base
use informacion; #Nos ponemos en ella

#creamos la tabla genero
CREATE TABLE `informacion`.`table_genero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `genero` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

#la tabla de informacion
CREATE TABLE `informacion`.`table_informacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `amaterno` VARCHAR(45) NOT NULL,
  `apaterno` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `ser_humano` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

#agregamos los generos que queramos para mostrar en el comboBox
insert into table_genero(genero) values("Masculino");
insert into table_genero(genero) values("Femenino");
insert into table_genero(genero) values("Indefinido");
select * from table_genero;


# Stored Procedures

DELIMITER %% #Definimos el delimiter
CREATE PROCEDURE `sp_getGenero`() #Le damos el nombre
BEGIN #siempre inicia con BEGIN
	select genero from table_genero #seleccionamos la columna genero de la tabla para trear los datos
END %% #finaliza con end

DELIMITER // 

#si va a recibir variables las definimos como parametros en el nombre
CREATE PROCEDURE `sp_altaInformacion`(
	nombrex varchar(40),apellidoPaternox varchar(40),apellidoMaternox varchar(40),
	humanox varchar(40),sexox varchar(40))
BEGIN 
 #hacemos el insert de las variables que recibimos a las variables correspondientes
	INSERT INTO table_informacion (nombre,amaterno,apaterno,sexo,
		ser_humano) 
	VALUES (nombrex,apellidoMaternox,apellidoPaternox,humanox,sexox);
END 
// DELIMITER ;

select * from table_informacion;


