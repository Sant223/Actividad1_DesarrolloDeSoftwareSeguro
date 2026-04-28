USE actividad_1;

INSERT INTO tipo_documento (nombre) VALUES 
('Cédula de Ciudadanía'),
('Cédula de Extranjería'),
('Pasaporte'),
('Tarjeta de Identidad');

INSERT INTO estado_civil (nombre) VALUES 
('Soltero(a)'),
('Casado(a)'),
('Unión Libre'),
('Divorciado(a)'),
('Viudo(a)');

-- id_tipo_docu 1 = CC, id_estado_civil 1 = Soltero, 2 = Casado
INSERT INTO funcionario (documento, nombres, apellidos, fecha_nacimiento, direccion, telefono, id_tipo_docu, id_estado_civil) VALUES 
(10203040, 'Juan Carlos', 'Pérez Restrepo', '1990-05-15', 'Calle 50 #10-20, Medellín', '3001234567', 1, 1),
(50607080, 'María Paula', 'Gómez Cano', '1985-11-22', 'Carrera 43 #5-12, Envigado', '3109876543', 1, 2),
(90102030, 'Carlos Alberto', 'Ruiz Marín', '1992-03-08', 'Circular 4 #70-10, Laureles', '3204567890', 1, 3);

-- Relacionamos los títulos con el ID del funcionario (suponiendo que Juan es ID 1 y María es ID 2)
INSERT INTO formacion_academica (titulo_obtenido, institucion, fecha_graduacion, id_funcionario) VALUES 
('Ingeniero de Sistemas', 'IU Digital de Antioquia', '2015-12-10', 1),
('Especialista en Logística', 'Universidad de Antioquia', '2018-06-20', 1),
('Administradora de Empresas', 'SENA', '2010-11-30', 2),
('Magíster en Gerencia', 'EAFIT', '2020-05-15', 2);

INSERT INTO grupo_familiar (nombre_completo, parentesco, id_funcionario) VALUES 
('Elena Restrepo', 'Madre', 1),
('Sonia Cano', 'Cónyuge', 2),
('Samuel Gómez', 'Hijo', 2),
('Jorge Ruiz', 'Padre', 3);

