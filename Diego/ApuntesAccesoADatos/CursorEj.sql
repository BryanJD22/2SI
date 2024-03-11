SET SERVEROUTPUT ON

DECLARE
  CURSOR v_cur1 IS 
    SELECT dnombre, loc FROM DEPART;
  v_nombre DEPART.dnombre%TYPE;
  v_localidad DEPART.loc%TYPE; 
BEGIN
  OPEN v_cur1;
  LOOP
    FETCH v_cur1 INTO v_nombre, v_localidad;
    EXIT WHEN v_cur1%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(v_nombre||' * '||v_localidad);
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE(v_cur1%ROWCOUNT||' DEPARTAMENTOS LISTADOS');
  CLOSE v_cur1;
END;

--Cursores parametrizados

SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE ver_emple_por_dpto(dep VARCHAR2) AS
  v_dept EMPLE.dept_no%TYPE;
  CURSOR v_cur1 IS 
    SELECT apellido FROM EMPLE
    WHERE dept_no = v_dept;
  v_apellido EMPLE.apellido%TYPE;

BEGIN
  v_dept := dep;
  OPEN v_cur1;
  FETCH v_cur1 INTO v_apellido;
  WHILE v_cur1%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE(v_apellido);
    FETCH v_cur1 INTO v_apellido;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE(v_cur1%ROWCOUNT||' EMPLEADOS LISTADOS');
  CLOSE v_cur1;
END;

SET SERVEROUTPUT ON
DROP PROCEDURE ver_emple_por_dpto;

CREATE OR REPLACE PROCEDURE ver_emple_por_dpto(dep VARCHAR2) AS
  v_dept EMPLE.dept_no%TYPE;
  CURSOR v_cur1 IS 
    SELECT emp_no, apellido FROM EMPLE
    WHERE dept_no = dep;
  v_num_emple EMPLE.emp_no%TYPE;
  v_apellido EMPLE.apellido%TYPE;

BEGIN
  v_dept := dep;
  OPEN v_cur1;
  FETCH v_cur1 INTO v_num_emple, v_apellido;
  WHILE v_cur1%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE(v_num_emple||' '||v_apellido);
    FETCH v_cur1 INTO v_num_emple,v_apellido;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE(v_cur1%ROWCOUNT||' EMPLEADOS LISTADOS');
  CLOSE v_cur1;
END;


--Cursor para update 
SET SERVEROUTPUT ON
rem Procedimiento que recibe el número de dpto y el porcentaje a incrementar 
rem y sube el sueldo a TODOS los empleados de ese dpto dado.

DROP PROCEDURE actualiza_salario_emple_por_dpto;

CREATE OR REPLACE PROCEDURE actualiza_salario_emple_por_dpto(dept VARCHAR2, subida NUMBER) AS
  CURSOR v_cur1 IS 
    SELECT * FROM EMPLE
    WHERE dept_no = dept FOR UPDATE;

  v_emple EMPLE%ROWTYPE;
  v_inc EMPLE.SALARIO%TYPE;

BEGIN
  OPEN v_cur1;
  FETCH v_cur1 INTO v_emple;
  WHILE v_cur1%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE('Empleado '||v_emple.emp_no||' '||v_emple.apellido);
    DBMS_OUTPUT.PUT_LINE('con salario '||v_emple.salario||' modificado a ');
    v_inc := v_emple.salario + ((v_emple.salario*subida)/100);
    DBMS_OUTPUT.PUT_LINE('nuevo salario '||v_inc);
    UPDATE EMPLE SET salario = v_inc WHERE CURRENT OF v_cur1;
    FETCH v_cur1 INTO v_emple;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE(v_cur1%ROWCOUNT||' EMPLEADOS LISTADOS');
  CLOSE v_cur1;
  COMMIT;
END;