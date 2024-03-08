set SERVEROUTPUT on;
--Antes de probar los procedimientos, asegúrate de haber ejecutado los scripts de creación de tablas, funciones y triggers. 
--Y cambiar los valores de las variables según sea necesario. 
--Por ejemplo en el caso de borrado de obra lo mas seguro es que no se pueda borrar la obra por que el id obra no existe.


--Alta obra
DECLARE
   id_obr VARCHAR(5);
BEGIN
   -- Supongamos que se quiere insertar una obra con el título 'Cinco semanas en globo'
   id_obr := alta_obra('Cinco semanas en globo',2022);

   -- Verificar si la operación fue exitosa
   IF id_obr = '-1' THEN
      DBMS_OUTPUT.PUT_LINE('Error al insertar la obra. No se pudo asignar un ID.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('ID asignado: ' || id_obr);
   END IF;
END;
/

--Borrado obra

DECLARE
   resultado INTEGER;
   id_obr VARCHAR(5);
BEGIN
   -- Supongamos que ya existe una obra con el ID 'ABCDE'
   id_obr := 'XXXXX';

   -- Llamada a la función borrado_obra
   resultado := borrado_obra(id_obr);

   -- Mostrar el resultado
   CASE resultado
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('La obra se ha borrado exitosamente.');
      WHEN 0 THEN
         DBMS_OUTPUT.PUT_LINE('No existe una obra con el ID proporcionado.');
      WHEN -1 THEN
         DBMS_OUTPUT.PUT_LINE('Ha ocurrido un error durante el borrado de la obra.');
      ELSE
         DBMS_OUTPUT.PUT_LINE('Resultado desconocido.');
   END CASE;
END;
/


--Alta autor
DECLARE
   id_autor VARCHAR(4);
BEGIN
   -- Supongamos que se quiere insertar un autor con el nombre 'Julio' y apellidos 'Cesar'
   -- y se proporciona el año de nacimiento como 2022
   id_autor := alta_autor('Julio', 'Cesar', DATE '2022-01-01');

   -- Verificar si la operación fue exitosa
   IF id_autor = '-1' THEN
      DBMS_OUTPUT.PUT_LINE('Error al insertar el autor. No se pudo asignar un ID.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('ID asignado: ' || id_autor);
   END IF;
END;
/

--Borrado autor
DECLARE
   resultado INTEGER;
   id_autor VARCHAR(4); 

BEGIN
    id_autor := 'XXXX';
    resultado := borrado_autor(id_autor);

   -- Verificar el resultado y mostrar un mensaje adecuado
   CASE resultado
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('Autor borrado exitosamente.');
      WHEN 0 THEN
         DBMS_OUTPUT.PUT_LINE('No existe un autor con ese ID.');
      WHEN -1 THEN
         DBMS_OUTPUT.PUT_LINE('Error al intentar borrar el autor.');
   END CASE;
END;
/

--Vincular autor obra

DECLARE
   resultado INTEGER;
   id_autor CHAR(4) ; 
   id_obra CHAR(5) ;  

BEGIN
    id_autor :='XXXX';
    id_obra :='XXXXX';
   resultado := vincular_autor_obra(id_autor, id_obra);

   -- Verificar el resultado y mostrar un mensaje adecuado
   CASE resultado
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('Vinculación exitosa.');
      WHEN -1 THEN
         DBMS_OUTPUT.PUT_LINE('Error al intentar vincular el autor a la obra.');
   END CASE;
END;
/


--Desvincular autor obra

DECLARE
   resultado INTEGER;
   id_autor VARCHAR(4) := 'XXXX';  
   id_obra VARCHAR(5) := 'XXXXX';  

BEGIN
   resultado := desvincular_autor_obra(id_autor, id_obra);

   -- Verificar el resultado y mostrar un mensaje adecuado
   CASE resultado
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('Desvinculación exitosa.');
      WHEN 0 THEN
         DBMS_OUTPUT.PUT_LINE('No existe un vínculo entre el autor y la obra.');
      WHEN -1 THEN
         DBMS_OUTPUT.PUT_LINE('Error al intentar desvincular el autor de la obra.');
   END CASE;
END;
/


--Alta edicion

DECLARE
   id_edicion CHAR(6);
   id_obra CHAR(5) := 'XXXXX';  -- Reemplaza 'XXXX' con el ID de la obra
   isbn_edicion CHAR(20) := '1234567890123';  -- Reemplaza con un ISBN válido
   anyo_edicion INTEGER := 2022;  -- Reemplaza con el año que desees

BEGIN
   id_edicion := alta_edicion(id_obra, isbn_edicion, anyo_edicion);

   -- Verificar el resultado y mostrar un mensaje adecuado
   IF id_edicion = '-1' THEN
      DBMS_OUTPUT.PUT_LINE('Error al dar de alta la edición. No se pudo asignar un ID.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('ID de la edición asignado: ' || id_edicion);
   END IF;
END;
/

--Borrado edicion

DECLARE
   resultado INTEGER;
   id_edicion_a_borrar VARCHAR(6) := 'XXXXXXX';  

BEGIN
   resultado := borrado_edicion(id_edicion_a_borrar);

   
   CASE resultado
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('Borrado de edición exitoso.');
      WHEN 0 THEN
         DBMS_OUTPUT.PUT_LINE('No existe una edición con ese ID.');
   END CASE;
END;
/

--Alta ejemplar

DECLARE
   numero_ejemplar_asignado INTEGER;
   id_edicion_existente VARCHAR(6) := 'XXXXXX';  -- Reemplaza 'XXXXXX' con un ID de edición existente

BEGIN
   -- Probar con una edición existente
   numero_ejemplar_asignado := alta_ejemplar(id_edicion_existente);

   -- Verificar el resultado y mostrar un mensaje adecuado
   IF numero_ejemplar_asignado = -1 THEN
      DBMS_OUTPUT.PUT_LINE('No existe la edición con ese ID. No se pudo dar de alta el ejemplar.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Número de ejemplar asignado: ' || numero_ejemplar_asignado);
   END IF;

END;
/

--Borrado ejemplar


DECLARE
   resultado_borrado INTEGER;
   id_edicion VARCHAR(6) := 'XXXXX';  -- Reemplaza con un ID de edición existente
   numero_ejemplar INTEGER := 2;        -- Reemplaza con el número de ejemplar existente

BEGIN
   -- Probar borrado de un ejemplar existente
   resultado_borrado := borrado_ejemplar(id_edicion, numero_ejemplar);

   -- Verificar el resultado y mostrar un mensaje adecuado
   CASE resultado_borrado
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('Ejemplar borrado exitosamente.');
      WHEN 0 THEN
         DBMS_OUTPUT.PUT_LINE('No existe el ejemplar con ese ID y número.');
      WHEN -1 THEN
         DBMS_OUTPUT.PUT_LINE('No se pudo borrar el ejemplar. Verifica si cumple que es el último de su serie, no tiene fecha de baja y
         además no han pasado más de 30 días desde la fecha de alta.');
      ELSE
         DBMS_OUTPUT.PUT_LINE('Resultado desconocido.');
   END CASE;
END;
/


--Baja ejemplar

DECLARE
   resultado_baja INTEGER;
   id_edicion VARCHAR(6) := 'XXXXXX';  -- Reemplaza con un ID de edición existente
   numero_ejemplar INTEGER := 4;        -- Reemplaza con el número de ejemplar existente

BEGIN
   -- Probar baja de un ejemplar existente
   resultado_baja := baja_ejemplar(id_edicion, numero_ejemplar);

   -- Verificar el resultado y mostrar un mensaje adecuado
   CASE resultado_baja
      WHEN 1 THEN
         DBMS_OUTPUT.PUT_LINE('Baja de ejemplar efectuada exitosamente.');
      WHEN 0 THEN
         DBMS_OUTPUT.PUT_LINE('No existe el ejemplar con ese ID y número.');
      WHEN -1 THEN
         DBMS_OUTPUT.PUT_LINE('No se pudo dar de baja el ejemplar. Verifica las condiciones de baja.');
      ELSE
         DBMS_OUTPUT.PUT_LINE('Resultado desconocido.');
   END CASE;
END;
/

