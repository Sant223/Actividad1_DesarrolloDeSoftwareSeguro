CREATE DATABASE actividad_1;

USE actividad_1;
CREATE TABLE tipo_documento (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200)
);

CREATE TABLE estado_civil (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200)
);

CREATE TABLE funcionario (
	id INT AUTO_INCREMENT PRIMARY KEY,
    documento INT UNIQUE NOT NULL,
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    fecha_namiento DATE,
    direccion VARCHAR(120),
    telefono VARCHAR(50),
    id_tipo_docu INT,
    id_estado_civil INT,
    FOREIGN KEY (id_tipo_docu) REFERENCES tipo_documento(id),
    FOREIGN KEY (id_estado_civil) REFERENCES estado_civil(id)
);

CREATE TABLE formacion_academica (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo_obtenido VARCHAR(250),
    institucion VARCHAR(300),
    fecha_graduacion DATE,
    id_funcionario INT,
	FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)

);

CREATE TABLE grupo_familiar(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(230),
    parentesco VARCHAR(200),
    id_funcionario INT,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);


