-- Tabla Usuario
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(10),
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    contraseña VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla Obra
CREATE TABLE obra (
    id_obra INT AUTO_INCREMENT PRIMARY KEY,
    titulo_obra VARCHAR(100),
    descripcion_obra TEXT,
    imagen_obra VARCHAR(255),
    precio DECIMAL(10,2),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla Sala
CREATE TABLE sala (
    id_sala INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    capacidad INT,
    imagen_sala VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla Obra_Sala (Nueva tabla intermedia)
CREATE TABLE obra_sala (
    id_obra_sala INT AUTO_INCREMENT PRIMARY KEY,
    id_obra INT,
    id_sala INT,
    fecha DATE,
    hora TIME,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_obra) REFERENCES obra(id_obra),
    FOREIGN KEY (id_sala) REFERENCES sala(id_sala)
);

-- Tabla Compra
CREATE TABLE compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATE,
    precio DECIMAL(10,2),
    id_obra_sala INT,
    id_usuario INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_obra_sala) REFERENCES obra_sala(id_obra_sala),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla Valoracion
CREATE TABLE valoracion (
    id_valoracion INT AUTO_INCREMENT PRIMARY KEY,
    valoracion INT,
    id_obra INT,
    id_usuario INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_obra) REFERENCES obra(id_obra),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);




INSERT INTO usuario (dni, nombre, apellidos, telefono, email, contraseña)
VALUES
    ('123456789', 'Juan', 'Pérez', '123456789', 'juan.perez@email.com', 'contraseña123'),
    ('987654321', 'María', 'Gómez', '987654321', 'maria.gomez@email.com', 'password456'),
    ('456789012', 'Luis', 'Martínez', '456789012', 'luis.martinez@email.com', 'securepass789'),
    ('789012345', 'Laura', 'Sánchez', '789012345', 'laura.sanchez@email.com', 'pass1234'),
    ('234567890', 'Carlos', 'Hernández', '234567890', 'carlos.hernandez@email.com', 'password5678'),
    ('890123456', 'Ana', 'López', '890123456', 'ana.lopez@email.com', 'securepass901'),
    ('345678901', 'David', 'Ramírez', '345678901', 'david.ramirez@email.com', 'pass5678'),
    ('567890123', 'Sofía', 'García', '567890123', 'sofia.garcia@email.com', 'password9012'),
    ('123890456', 'Miguel', 'Díaz', '123890456', 'miguel.diaz@email.com', 'securepass345'),
    ('456123789', 'Elena', 'Rodríguez', '456123789', 'elena.rodriguez@email.com', 'pass9012'),
    ('789234012', 'Javier', 'Fernández', '789234012', 'javier.fernandez@email.com', 'password345'),
    ('234567890', 'Isabel', 'Santos', '234567890', 'isabel.santos@email.com', 'securepass678'),
    ('890123456', 'Diego', 'Luna', '890123456', 'diego.luna@email.com', 'pass1239'),
    ('345678901', 'Carmen', 'Ruiz', '345678901', 'carmen.ruiz@email.com', 'password6789'),
    ('567890123', 'Pablo', 'Ortega', '567890123', 'pablo.ortega@email.com', 'securepass234'),
    ('123890456', 'Rocío', 'Cabrera', '123890456', 'rocio.cabrera@email.com', 'pass7890'),
    ('456123789', 'Hugo', 'Gutiérrez', '456123789', 'hugo.gutierrez@email.com', 'password234'),
    ('789234012', 'Natalia', 'Moreno', '789234012', 'natalia.moreno@email.com', 'securepass567'),
    ('234567890', 'Francisco', 'Vega', '234567890', 'francisco.vega@email.com', 'pass2345'),
    ('890123456', 'Raquel', 'Jiménez', '890123456', 'raquel.jimenez@email.com', 'password678'),
    ('345678901', 'Gabriel', 'Pardo', '345678901', 'gabriel.pardo@email.com', 'securepass890');


INSERT INTO obra (titulo_obra, descripcion_obra, imagen_obra)
VALUES
    ('Romeo y Julieta', 'Tragedia romántica de William Shakespeare', 'imagen1.jpg'),
    ('La Casa de Bernarda Alba', 'Drama de Federico García Lorca', 'imagen2.jpg'),
    ('Don Juan Tenorio', 'Drama religioso de Tirso de Molina', 'imagen3.jpg'),
    ('Esperando a Godot', 'Obra absurda de Samuel Beckett', 'imagen4.jpg'),
    ('La Celestina', 'Comedia trágica de Fernando de Rojas', 'imagen5.jpg'),
    ('El Tartufo', 'Comedia satírica de Molière', 'imagen6.jpg'),
    ('Hamlet', 'Tragedia de William Shakespeare', 'imagen7.jpg'),
    ('El Burlador de Sevilla y Convidado de Piedra', 'Drama de Tirso de Molina', 'imagen8.jpg'),
    ('Las Preciosas Ridículas', 'Comedia de Molière', 'imagen9.jpg'),
    ('La Vida es Sueño', 'Drama filosófico de Calderón de la Barca', 'imagen10.jpg');


INSERT INTO sala (nombre,capacidad)
VALUES
    ('Sala A',100),
    ('Sala B',80),
    ('Sala C',120),
    ('Sala D',90),
    ('Sala E',110),
    ('Sala F',150);  

-- Generación de registros adicionales para obra_sala
INSERT INTO obra_sala (id_obra, id_sala, fecha, hora)
VALUES
    (1, 1, '2023-01-15', '20:00:00'),
    (2, 2, '2023-02-20', '18:30:00'),
    (3, 3, '2023-03-10', '15:45:00'),
    (4, 4, '2023-04-05', '21:15:00'),
    (5, 5, '2023-05-12', '19:30:00'),
    (6, 6, '2023-06-18', '17:00:00'),
    (7, 1, '2023-07-22', '16:15:00'),
    (8, 2, '2023-08-30', '14:45:00'),
    (9, 3, '2023-09-08', '22:00:00'),
    (10, 4, '2023-10-14', '19:00:00'),
    (1, 2, '2023-01-20', '19:30:00'),
    (2, 3, '2023-02-25', '20:45:00'),
    (3, 4, '2023-03-15', '16:30:00'),
    (4, 5, '2023-04-10', '22:30:00'),
    (5, 6, '2023-05-15', '18:45:00'),
    (6, 1, '2023-06-20', '15:30:00'),
    (7, 2, '2023-07-25', '17:45:00'),
    (8, 3, '2023-08-31', '21:00:00'),
    (9, 4, '2023-09-10', '20:15:00'),
    (10, 5, '2023-10-20', '19:30:00'),
    (1, 3, '2023-01-25', '18:00:00'),
    (2, 4, '2023-02-28', '19:15:00'),
    (3, 5, '2023-03-20', '20:30:00'),
    (4, 6, '2023-04-15', '21:45:00'),
    (5, 1, '2023-05-20', '22:00:00'),
    (6, 2, '2023-06-25', '18:30:00'),
    (7, 3, '2023-07-30', '16:00:00'),
    (8, 4, '2023-08-31', '19:15:00'),
    (9, 5, '2023-09-15', '20:30:00'),
    (10, 6, '2023-10-25', '21:45:00');

-- Generación de registros adicionales para compra
INSERT INTO compra (fecha_compra, precio, id_obra_sala, id_usuario)
VALUES
    ('2023-01-15', 20.00, 1, 1),
    ('2023-02-20', 25.00, 2, 2),
    ('2023-03-10', 30.00, 3, 3),
    ('2023-04-05', 15.00, 4, 4),
    ('2023-05-12', 18.00, 5, 5),
    ('2023-06-18', 22.00, 6, 6),
    ('2023-07-22', 27.00, 7, 7),
    ('2023-08-30', 35.00, 8, 8),
    ('2023-09-08', 40.00, 9, 9),
    ('2023-10-14', 32.00, 10, 10),
    ('2023-01-20', 25.00, 11, 11),
    ('2023-02-25', 30.00, 12, 12),
    ('2023-03-15', 18.00, 13, 13),
    ('2023-04-10', 20.00, 14, 14),
    ('2023-05-15', 22.00, 15, 15),
    ('2023-06-20', 28.00, 16, 16),
    ('2023-07-25', 25.00, 17, 17),
    ('2023-08-31', 30.00, 18, 18),
    ('2023-09-10', 18.00, 19, 19),
    ('2023-10-20', 22.00, 20, 20),
    ('2023-01-25', 30.00, 21, 1),
    ('2023-02-28', 22.00, 22, 2),
    ('2023-03-20', 28.00, 23, 3),
    ('2023-04-15', 35.00, 24, 4),
    ('2023-05-20', 40.00, 25, 5),
    ('2023-06-25', 32.00, 26, 6),
    ('2023-07-30', 18.00, 27, 7),
    ('2023-08-31', 20.00, 28, 8),
    ('2023-09-15', 22.00, 29, 9),
    ('2023-10-25', 28.00, 30, 10);

-- Generación de registros adicionales para valoracion
INSERT INTO valoracion (valoracion, id_obra, id_usuario)
VALUES
    (5, 1, 1),
    (4, 2, 2),
    (3, 3, 3),
    (5, 4, 4),
    (4, 5, 5),
    (5, 6, 6),
    (3, 7, 7),
    (4, 8, 8),
    (5, 9, 9),
    (3, 10, 10),
    (4, 1, 11),
    (5, 2, 12),
    (3, 3, 13),
    (4, 4, 14),
    (5, 5, 15),
    (4, 6, 16),
    (3, 7, 17),
    (5, 8, 18),
    (4, 9, 19),
    (5, 10, 20),
    (5, 1, 1),
    (4, 2, 2),
    (3, 3, 3),
    (5, 4, 4),
    (4, 5, 5),
    (5, 6, 6),
    (3, 7, 7),
    (4, 8, 8),
    (5, 9, 9),