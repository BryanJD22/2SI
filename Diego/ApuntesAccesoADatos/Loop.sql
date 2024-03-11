La sentencia LOOP ejecuta una secuencia de sentencias dentro de un bloque de código PL/SQL varias veces.

Invocación
Esta sentencia se puede incluir en un procedimiento, función o sentencia de bloque anónimo de PL/SQL.

Autorización
No se requieren privilegios para invocar la sentencia LOOP. Sin embargo, el ID de autorización de la sentencia debe tener los privilegios necesarios para invocar las sentencias SQL que están incorporadas en la sentencia LOOP.

Sintaxis
Read syntax diagramSkip visual syntax diagram
LOOP
statements
END
LOOP
Descripción
sentencias
Especifica una o más sentencias PL/SQL o SQL. Estas sentencias se ejecutan durante cada iteración del bucle.
Ejemplo
El ejemplo siguiente muestra una sentencia LOOP básica dentro de un bloque anónimo:
DECLARE
  sum INTEGER := 0;
BEGIN
  LOOP
    sum := sum + 1;
    IF sum > 10 THEN
       EXIT;
    END IF;
  END LOOP;
END   