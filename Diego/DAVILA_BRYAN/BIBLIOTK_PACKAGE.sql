-- Crear usuario C##BIBLIOTK_ADMIN
CREATE USER C##BIBLIOTK_ADMIN IDENTIFIED BY admin;

-- Conceder todos los privilegios al usuario C##BIBLIOTK_ADMIN
GRANT ALL PRIVILEGES TO C##BIBLIOTK_ADMIN;

-- Crear usuario C##BIBLIOTK_USER
CREATE USER C##BIBLIOTK_USER IDENTIFIED BY user;

-- Conceder todos los privilegios al usuario C##BIBLIOTK_USER
GRANT ALL PRIVILEGES TO C##BIBLIOTK_USER;

CONNECT C##BIBLIOTK_ADMIN/admin



CREATE OR REPLACE PACKAGE BiblioTK AS
    FUNCTION alta_obra(p_titulo VARCHAR, p_anyo INTEGER DEFAULT NULL) RETURN VARCHAR;
    FUNCTION borrado_obra(p_id VARCHAR) RETURN INTEGER;
    FUNCTION alta_autor(p_nombre VARCHAR, p_apellidos VARCHAR, p_nacimiento DATE DEFAULT NULL) RETURN VARCHAR;
    FUNCTION borrado_autor(p_id VARCHAR) RETURN INTEGER;
    FUNCTION vincular_autor_obra(p_id_autor VARCHAR, p_id_obra VARCHAR) RETURN INTEGER;
    FUNCTION desvincular_autor_obra(p_id_autor VARCHAR, p_id_obra VARCHAR) RETURN INTEGER;
    FUNCTION alta_edicion(p_id_obra VARCHAR, p_isbn VARCHAR, p_anyo INTEGER DEFAULT NULL) RETURN VARCHAR;
    FUNCTION borrado_edicion(p_id VARCHAR) RETURN INTEGER;
    FUNCTION alta_ejemplar(p_id_edicion VARCHAR) RETURN INTEGER;
    FUNCTION borrado_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) RETURN INTEGER;
    FUNCTION baja_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) RETURN INTEGER;
    FUNCTION apertura_prestamo(p_id_socio CHAR,p_id_edicion CHAR,p_numero_ejemplar INTEGER) RETURN INTEGER
    FUNCTION cierre_prestamo(p_id_prestamo CHAR) RETURN INTEGER


END BiblioTK;
/