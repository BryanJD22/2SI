--La tabla obra contiene la información de las obras literarias.

CREATE TABLE obra (
id CHAR(5),
titulo VARCHAR(100),
anyo INTEGER,
CONSTRAINT PK_obra PRIMARY KEY (id),
CONSTRAINT NN_titulo CHECK (titulo IS NOT NULL)
);


--La tabla autor contiene la información de los autores de las obras.

CREATE TABLE autor (
id CHAR(4),
nombre VARCHAR(30),
apellidos VARCHAR(60),
nacimiento DATE,
CONSTRAINT PK_autor PRIMARY KEY (id),
CONSTRAINT NN_nombre CHECK (nombre IS NOT NULL),
CONSTRAINT NN_apellidos CHECK (apellidos IS NOT NULL)
);


--La tabla autor_obra contiene la relación de autores y obras.

CREATE TABLE autor_obra (
id_autor CHAR(4),
id_obra CHAR(5),
CONSTRAINT PK_autor_obra PRIMARY KEY (id_autor, id_obra),
CONSTRAINT FK_autor_obra_id_autor FOREIGN KEY (id_autor) REFERENCES
autor(id),
CONSTRAINT FK_autor_obra_id_obra FOREIGN KEY (id_obra)
REFERENCES obra(id)
);



--La tabla edicion contiene la información de las ediciones publicadas de las obras.

CREATE TABLE edicion (
id CHAR(6),
id_obra CHAR(5),
isbn VARCHAR(20),
anyo INTEGER,
CONSTRAINT PK_edicion PRIMARY KEY (id),
CONSTRAINT NN_id_obra CHECK (id_obra IS NOT NULL),
CONSTRAINT NN_isbn CHECK (isbn IS NOT NULL),
CONSTRAINT FK_edicion FOREIGN KEY (id_obra) REFERENCES
obra(id)
);




--La tabla ejemplar contiene la información de los ejemplares adquiridos por labiblioteca.

CREATE TABLE ejemplar (
id_edicion CHAR(6),
numero INTEGER,
alta DATE,
baja DATE,
CONSTRAINT PK_ejemplar PRIMARY KEY (id_edicion, numero),
CONSTRAINT FK_ejemplar FOREIGN KEY (id_edicion) REFERENCES
edicion(id),
CONSTRAINT NN_alta CHECK (alta IS NOT NULL)
);

--Tabla para guardar los borrados (se utiliza en el punto 9.1)

CREATE TABLE historial_obras (
   id CHAR(5),
   titulo VARCHAR(100),
   anyo INTEGER,
   fecha_borrado TIMESTAMP,
   CONSTRAINT PK_historial_obras PRIMARY KEY (id, fecha_borrado)
);