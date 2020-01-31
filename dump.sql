drop database seguro;
create database seguro;
use seguro;

DROP TABLE IF EXISTS seguro;
CREATE TABLE IF NOT EXISTS seguro (
  id int NOT NULL AUTO_INCREMENT,
  nif varchar(255) NOT NULL UNIQUE,
  nombre varchar(255) DEFAULT NULL,
  ape1 varchar(255) DEFAULT NULL,
  ape2 varchar(255) DEFAULT NULL,
  edad int DEFAULT NULL,
  sexo int DEFAULT NULL,
  casado char(1) DEFAULT NULL,
  numHijos int DEFAULT NULL,
  embarazada char(1) DEFAULT NULL,
  coberturaId int DEFAULT NULL,
  enfermedadId int DEFAULT NULL,
  fechaCreacion date DEFAULT NULL,
  PRIMARY KEY (id)
) ;

DROP TABLE IF EXISTS enfermedad;
CREATE TABLE IF NOT EXISTS enfermedad (
  id int NOT NULL AUTO_INCREMENT,
  corazon char(1) not null default "N",
  estomacal char(1) not null default "N",
  rinyones char(1) not null default "N",
  alergia char(1) not null default "N",
  nombreAlergia varchar(50) null,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS cobertura;
CREATE TABLE IF NOT EXISTS cobertura (
  id int NOT NULL AUTO_INCREMENT,
  oftalmologia char(1) not null default "F",
  dental char(1) not null default "F",
  fecundacionInVitro char(1) not null default "F",
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS asistencia;
CREATE TABLE IF NOT EXISTS asistencia (
  id int NOT NULL AUTO_INCREMENT,
  seguroId int NOT NULL,
  descripcion varchar(255),
  lugar varchar(50),
  explicacion blob,
  tipoAsistencia varchar(50),
  fecha date,
  hora time,
  importe decimal(10,2),
  PRIMARY KEY (id)
);

ALTER TABLE asistencia
ADD CONSTRAINT fk_seguro
FOREIGN KEY (seguroId) REFERENCES seguro (id);

ALTER TABLE seguro
ADD CONSTRAINT fk_cobertura
FOREIGN KEY (coberturaId) REFERENCES cobertura (id);

ALTER TABLE seguro
ADD CONSTRAINT fk_enfermedad
FOREIGN KEY (enfermedadId) REFERENCES enfermedad (id);

insert into cobertura (oftalmologia,dental,fecundacionInVitro) values ('F','T','T');
insert into enfermedad (corazon,estomacal,rinyones,alergia,nombreAlergia) values ('Y','N','Y','N',null);

insert into seguro(id, nif,coberturaId,enfermedadId,nombre,ape1,ape2,edad,sexo,embarazada,casado,numHijos,fechaCreacion)
  values(1, '9784563J',1,1,'maria','garcia','lozano',39,0,true,false,5,'2015-10-30');
insert into asistencia (seguroId,descripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe)
  values(1,'descripcion a','Pozuelo','explicacion a','DOMICILIARIA','2015-11-23','12:47:00',15000);
insert into asistencia (seguroId,descripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe)
  values(1,'descripcion a','Alcobendas','explicacion b','HOSPITALARIA','2015-12-1','14:23:00',25000);

INSERT INTO seguro
	(id, nif, nombre, ape1, ape2, edad, sexo, casado, numHijos, embarazada, fechaCreacion)
VALUES
	(2, '17546586R', 'JOAQUIM', 'SORIA', 'SORIA', 19, 1, 'Y', 0, 'N', '2013-04-22 19:05:11'),
	(3, '22737883Z', 'FELIX EDUARDO', 'EVA EUGENIA', 'IVORRA', 40, 1, 'Y', 3, 'N','2013-04-22 19:05:12'),
	(4, '41179582Z', 'MARIA INES', 'MARCO', 'LIBEROS', 26, 1, 'Y', 2, 'N', '2013-04-22 19:05:12'),
	(5, '55386997F', 'NURIA', 'PUERTO', 'VILLANOVA', 46, 1, 'Y', 2, 'N', '2013-04-22 19:05:12'),
	(6, '66738365R', 'JOAQUIN', 'SAYAS', 'SENABRE', 25, 0, 'N', 1, 'N', '2013-04-22 19:05:12'),
	(7, '42749118F', 'JOSEF BENANTZIO', 'SAVALL', 'RABASCO', 40, 1, 'N', 2, 'N', '2013-04-22 19:05:12'),
	(8, '78172651K', 'CRISTINA', 'PEREZ', 'HARILLO', 56, 0,'Y', 1, 'N', '2013-04-22 19:05:12'),
	(9, '51256964S', 'MARIA SANDRA', 'CASES', 'ROIG', 58, 1, 'N', 3, 'N', '2013-04-22 19:05:12');

