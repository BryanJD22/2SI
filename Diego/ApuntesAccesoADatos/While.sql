La sentencia WHILE repite un conjunto de sentencias SQL siempre que una expresión especificada sea verdadera. La condición se evalúa inmediatamente antes de cada entrada en el cuerpo del bucle.

Invocación
Esta sentencia se puede incluir en un procedimiento, función o sentencia de bloque anónimo de PL/SQL.

Autorización
No se necesitan privilegios para invocar la sentencia WHILE; sin embargo, el ID de autorización de la sentencia debe tener los privilegios necesarios para invocar las sentencias SQL que están incorporadas en la sentencia WHILE.

Sintaxis
Read syntax diagramSkip visual syntax diagram
WHILE
expression
LOOP
statements
END LOOP
Descripción
expresión
Especifica una expresión que se evalúa inmediatamente antes de cada entrada en el cuerpo del bucle para determinar si se va a ejecutar o no el bucle. Si la expresión es lógicamente verdadera, se ejecuta el bucle. Si la expresión es lógicamente falsa, el proceso de bucle finaliza. Se puede utilizar una sentencia EXIT para terminar el bucle mientras la expresión es verdadera.
sentencias
Especifica las sentencias PL/SQL y SQL que se ejecutan cada vez que se procesa el bucle.
Ejemplo
El ejemplo siguiente muestra una sentencia WHILE básica dentro de un bloque anónimo:
DECLARE
  sum INTEGER := 0;
BEGIN
  WHILE sum < 11 LOOP
    sum := sum + 1;
  END LOOP;
END

La sentencia WHILE dentro de este bloque anónimo se ejecuta hasta que sum es igual a 11; el proceso de bucle finaliza y el proceso del bloque anónimo continúa hasta su finalización.