CREATE OR REPLACE TRIGGER auditar_borrado_obra
AFTER DELETE ON obra
FOR EACH ROW
DECLARE
   -- Declaraciones
   v_fecha_hora TIMESTAMP := CURRENT_TIMESTAMP;
BEGIN
   -- Insertar los datos de la obra borrada en la tabla de historial_obras
   INSERT INTO historial_obras (id, titulo, anyo, fecha_borrado)
   VALUES (:OLD.id, :OLD.titulo, :OLD.anyo, v_fecha_hora);
   
   -- Puedes agregar más información a la salida de mensajes si es necesario
   DBMS_OUTPUT.PUT_LINE('Borrado de obra ID ' || :OLD.id || ' auditable. Fecha/Hora: ' || TO_CHAR(v_fecha_hora, 'YYYY-MM-DD HH24:MI:SS'));
END;
/