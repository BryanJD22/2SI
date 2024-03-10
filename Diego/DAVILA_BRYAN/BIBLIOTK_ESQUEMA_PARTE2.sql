--Tabla para guardar los socios de la biblioteca
CREATE TABLE socio(
   id_socio CHAR (5)PRIMARY KEY,
   nombre VARCHAR(30) NOT NULL,
   apellidos VARCHAR(60) NOT NULL,
   fecha_inscripcion DATE

);



--Tabla para guardar los préstamos de ejemplares a los socios
CREATE TABLE prestamo(
   id_prestamo CHAR(7) PRIMARY KEY,
   id_socio CHAR(5),
   id_edicion CHAR(6),
   numero_ejemplar INTEGER,
   fecha_inicio DATE ,
   fecha_fin DATE,
   CONSTRAINT FK_prestamo_id_socio FOREIGN KEY (id_socio) REFERENCES socio(id_socio),
   CONSTRAINT FK_prestamo_id_ejemplar FOREIGN KEY (id_edicion, numero_ejemplar) REFERENCES ejemplar(id_edicion, numero),
   CONSTRAINT NN_id_socio CHECK (id_socio IS NOT NULL),
   CONSTRAINT NN_id_edicion CHECK (id_edicion IS NOT NULL),
   CONSTRAINT NN_numero_ejemplar CHECK (numero_ejemplar IS NOT NULL)
    
);
