CREATE OR REPLACE PACKAGE BODY BiblioTK AS

CREATE OR REPLACE FUNCTION alta_obra(p_titulo VARCHAR, p_anyo INTEGER DEFAULT NULL)
RETURN VARCHAR IS
   -- Declaraciones
   id_obra VARCHAR(5);
BEGIN
   -- Generar un identificador alfanumérico de 5 caracteres
   id_obra := DBMS_RANDOM.STRING('X', 5);

   -- Insertar la nueva obra
   BEGIN
      INSERT INTO obra (id, titulo, anyo) VALUES (id_obra, p_titulo, p_anyo);
   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, devolver -1
         RETURN '-1';
   END;

   -- Devolver el ID asignado
   RETURN id_obra;
END;
/
CREATE OR REPLACE FUNCTION borrado_obra(p_id VARCHAR) RETURN INTEGER IS
   -- Declaraciones
   v_existencia INTEGER;
BEGIN
   v_existencia := 0;
   -- Verificar si existe la obra con el id proporcionado
   SELECT COUNT(*) INTO v_existencia
   FROM obra
   WHERE id = p_id;

   -- Realizar el borrado si la obra existe
   IF v_existencia > 0 THEN
      DELETE FROM obra WHERE id = p_id;
      RETURN 1; -- Borrado efectuado
   ELSE
      RETURN 0; -- No existe el id
   END IF;
 
   EXCEPTION
	WHEN OTHERS THEN
	   RETURN -1;
END;
/


CREATE OR REPLACE FUNCTION alta_autor(p_nombre VARCHAR, p_apellidos VARCHAR, p_nacimiento DATE DEFAULT NULL)
RETURN VARCHAR IS
   -- Declaraciones
   id_autor CHAR(4);
BEGIN
   -- Generar un identificador alfanumérico de 4 caracteres
   id_autor := DBMS_RANDOM.STRING('X', 4);
	
   -- Insertar la nueva obra
   BEGIN
      INSERT INTO autor (id, nombre, apellidos, nacimiento) VALUES (id_autor, p_nombre, p_apellidos, p_nacimiento);
   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, devolver -1
         RETURN '-1';
   END;

   -- Devolver el ID asignado
   RETURN id_autor;
END;
/
CREATE OR REPLACE FUNCTION borrado_autor(p_id VARCHAR) RETURN INTEGER IS
   -- Declaraciones
   v_existencia INTEGER ;

BEGIN
    v_existencia := 0;
   -- Verificar si existe la autor con el id proporcionado
   SELECT COUNT(*) INTO v_existencia
   FROM autor
   WHERE id = p_id;

   -- Intentar borrar el autor
 	IF v_existencia > 0 THEN
      DELETE FROM autor WHERE id = p_id;
      RETURN 1; -- Borrado efectuado
   ELSE
      RETURN 0; -- No existe el id
   END IF;
 
   EXCEPTION
	WHEN OTHERS THEN
	   RETURN -1;
      
END;
/
CREATE OR REPLACE FUNCTION vincular_autor_obra(p_id_autor VARCHAR, p_id_obra VARCHAR) RETURN INTEGER IS
   -- Declaraciones
   v_resultado INTEGER := 1;  -- Por defecto, asumimos que la operación se realiza sin errores.

BEGIN
   -- Intentar vincular el autor a la obra
   BEGIN
      INSERT INTO autor_obra (id_autor, id_obra) VALUES (p_id_autor, p_id_obra);
      
      COMMIT;  -- Confirmar la transacción si la inserción fue exitosa

   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, asignar -1 al resultado y realizar un rollback
         v_resultado := -1;
         ROLLBACK;
   END;

   -- Devolver el resultado
   RETURN v_resultado;
END;
/
CREATE OR REPLACE FUNCTION desvincular_autor_obra(p_id_autor VARCHAR, p_id_obra VARCHAR)
RETURN INTEGER IS
   -- Declaraciones
   v_resultado INTEGER := 0;  -- Por defecto, asumimos que no existe el vínculo.

BEGIN
   -- Intentar desvincular el autor de la obra
   BEGIN
      DELETE FROM autor_obra
      WHERE id_autor = p_id_autor AND id_obra = p_id_obra;

      -- Verificar si se eliminó alguna fila
      IF SQL%ROWCOUNT > 0 THEN
         -- Si se eliminó al menos una fila, asignar 1 al resultado
         v_resultado := 1;
      END IF;
      
      COMMIT;  -- Confirmar la transacción

   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, asignar -1 al resultado y realizar un rollback
         v_resultado := -1;
         ROLLBACK;
   END;

   -- Devolver el resultado
   RETURN v_resultado;
END;
/

CREATE OR REPLACE FUNCTION alta_edicion(p_id_obra VARCHAR, p_isbn VARCHAR, p_anyo INTEGER DEFAULT NULL)
RETURN VARCHAR IS
   -- Declaraciones
   v_id_edicion CHAR(6);
BEGIN
   -- Generar un identificador alfanumérico de 5 caracteres para la edición
   v_id_edicion := DBMS_RANDOM.STRING('X', 6);
	
   -- Insertar la nueva edición
   BEGIN
      INSERT INTO edicion (id, id_obra, isbn, anyo) VALUES (v_id_edicion, p_id_obra, p_isbn, p_anyo);
      
      COMMIT;  -- Confirmar la transacción

   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, devolver '-1'
         RETURN '-1';
   END;

   -- Devolver el ID asignado
   RETURN v_id_edicion;
END;
/
CREATE OR REPLACE FUNCTION borrado_edicion(p_id VARCHAR)
RETURN INTEGER IS
   -- Declaraciones
   v_resultado INTEGER := 0;  -- Por defecto, asumimos que no se encontró el ID.

BEGIN
   -- Intentar borrar la edición por su ID
   BEGIN
      DELETE FROM edicion WHERE id = p_id;

      -- Verificar si se eliminó alguna fila
      IF SQL%ROWCOUNT > 0 THEN
         -- Si se eliminó al menos una fila, asignar 1 al resultado
         v_resultado := 1;
      END IF;
      
      COMMIT;  -- Confirmar la transacción

   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, asignar 0 al resultado y realizar un rollback
         v_resultado := 0;
         ROLLBACK;
   END;

   -- Devolver el resultado
   RETURN v_resultado;
END;
/
CREATE SEQUENCE SEQ_EJEMPLAR
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE OR REPLACE FUNCTION alta_ejemplar(p_id_edicion VARCHAR) RETURN INTEGER IS
   -- Declaraciones
   v_numero_ejemplar INTEGER;
BEGIN
   -- Verificar si la edición con el ID proporcionado existe en la tabla edicion
   SELECT COUNT(*)
   INTO v_numero_ejemplar
   FROM edicion
   WHERE id = p_id_edicion;

   -- Si no se encuentra la edición, devolver -1
   IF v_numero_ejemplar = 0 THEN
      RETURN -1;
   END IF;

   -- Generar el número de ejemplar utilizando una secuencia
   SELECT SEQ_EJEMPLAR.NEXTVAL INTO v_numero_ejemplar FROM DUAL;

   -- Insertar el nuevo ejemplar
   BEGIN
      INSERT INTO ejemplar (id_edicion, numero, alta) VALUES (p_id_edicion, v_numero_ejemplar, SYSDATE);
      
      COMMIT;  -- Confirmar la transacción

   EXCEPTION
      WHEN OTHERS THEN
         -- Si ocurre un error, devolver -1
         RETURN -1;
   END;

   -- Devolver el número de ejemplar asignado
   RETURN v_numero_ejemplar;
END;
/
CREATE OR REPLACE FUNCTION borrado_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) RETURN INTEGER IS
   -- Declaraciones
   v_fecha_alta DATE;
   v_fecha_baja DATE;
   v_max_numero INTEGER;
BEGIN
   -- Obtener la fecha de alta y fecha de baja del ejemplar
   SELECT alta, baja
   INTO v_fecha_alta, v_fecha_baja
   FROM ejemplar
   WHERE id_edicion = p_id_edicion AND numero = p_numero;

   -- Verificar si existe el ejemplar
   IF v_fecha_alta IS NULL THEN
      -- No existe el ejemplar
      RETURN 0;
   END IF;

   -- Obtener el número máximo de ejemplar para la edición dada
   SELECT COALESCE(MAX(numero), 0)
   INTO v_max_numero
   FROM ejemplar
   WHERE id_edicion = p_id_edicion;

   -- Verificar si el ejemplar cumple con la cláusula 21 (último ejemplar sin fecha de baja y no han pasado más de 30 días)
   IF p_numero = v_max_numero AND v_fecha_baja IS NULL AND SYSDATE - v_fecha_alta <= 30 THEN
      -- Borrar el ejemplar
      BEGIN
         DELETE FROM ejemplar
         WHERE id_edicion = p_id_edicion AND numero = p_numero;

         COMMIT;  -- Confirmar la transacción

      EXCEPTION
         WHEN OTHERS THEN
            -- Si ocurre un error, devolver -1
            RETURN -1;
      END;

      -- Devolver 1 para indicar que el borrado fue efectuado
      RETURN 1;
   ELSE
      -- El ejemplar no cumple con la cláusula 21
      RETURN -1;
   END IF;
END;
/

CREATE OR REPLACE FUNCTION baja_ejemplar(p_id_edicion VARCHAR, p_numero INTEGER) RETURN INTEGER IS
   -- Declaraciones
   v_fecha_baja DATE;
   v_fecha_alta DATE;
BEGIN
   -- Obtener la fecha de alta y fecha de baja del ejemplar
   SELECT alta, baja
   INTO v_fecha_alta, v_fecha_baja
   FROM ejemplar
   WHERE id_edicion = p_id_edicion AND numero = p_numero;

   -- Verificar si existe el ejemplar
   IF v_fecha_alta IS NULL THEN
      -- No existe el ejemplar
      RETURN 0;
   ELSE
       -- Verificar si el ejemplar cumple con la cláusula 25 (no tiene fecha de baja)
       IF v_fecha_baja IS NULL THEN
          -- Establecer la fecha de baja como la fecha del sistema
          BEGIN
             UPDATE ejemplar
             SET baja = SYSDATE
             WHERE id_edicion = p_id_edicion AND numero = p_numero;
    
             COMMIT;  -- Confirmar la transacción
    
          EXCEPTION
             WHEN OTHERS THEN
                -- Si ocurre un error, devolver -1
                RETURN -1;
          END;
    
          -- Devolver 1 para indicar que la baja fue efectuada
          RETURN 1;
       ELSE
          -- El ejemplar ya tiene fecha de baja, por lo tanto, no cumple con la cláusula 25
          RETURN -1;
       END IF;

   END IF;


END;
/
    
END BiblioTK;
/