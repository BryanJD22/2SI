CASE
Palabra clave que introduce la primera cláusula WHEN en la sentencia CASE .
WHEN expresión-booleana
Especifica una expresión que se evalúa cuando el flujo de control entra en la cláusula WHEN en la que se define la expresión. Si expresión-booleana se evalúa como TRUE, se ejecutan las sentencias de la cláusula THEN correspondiente. Si expresión-booleana no se evalúa como TRUE, se ejecutan las sentencias de la cláusula ELSE correspondiente.
THEN
Palabra clave que introduce las sentencias que se van a ejecutar cuando la expresión booleana correspondiente se evalúa como TRUE.
sentencias
Especifica una o más sentencias SQL o PL/SQL, cada una terminada con un punto y coma.
ELSE
Palabra clave que introduce las mayúsculas y minúsculas predeterminadas de la sentencia CASE .

El ejemplo siguiente utiliza una sentencia CASE buscada para asignar un nombre de departamento y una ubicación a una variable basada en el número de departamento.
DECLARE
    v_empno         emp.empno%TYPE;
    v_ename         emp.ename%TYPE;
    v_deptno        emp.deptno%TYPE;
    v_dname         dept.dname%TYPE;
    v_loc           dept.loc%TYPE;
    CURSOR emp_cursor IS SELECT empno, ename, deptno FROM emp;
BEGIN
    OPEN emp_cursor;
    DBMS_OUTPUT.PUT_LINE('EMPNO    ENAME     DEPTNO    DNAME     '
        || '     LOC');
    DBMS_OUTPUT.PUT_LINE('-----    -------   ------    ----------'
        || '     ---------');
    LOOP
        FETCH emp_cursor INTO v_empno, v_ename, v_deptno;
        EXIT WHEN emp_cursor%NOTFOUND;
        CASE
            WHEN v_deptno = 10 THEN v_dname := 'Accounting';
                                    v_loc   := 'New York';
            WHEN v_deptno = 20 THEN v_dname := 'Research';
                                    v_loc   := 'Dallas';
            WHEN v_deptno = 30 THEN v_dname := 'Sales';
                                    v_loc   := 'Chicago';
            WHEN v_deptno = 40 THEN v_dname := 'Operations';
                                    v_loc   := 'Boston';
            ELSE v_dname := 'unknown';
                                    v_loc   := '';
        END CASE;
        DBMS_OUTPUT.PUT_LINE(v_empno || '     ' || RPAD(v_ename, 10) ||
            '  ' || v_deptno || '      ' || RPAD(v_dname, 14) || ' ' ||
            v_loc);
    END LOOP;
    CLOSE emp_cursor;
END;

Este programa devuelve la siguiente salida de ejemplo:
EMPNO    ENAME     DEPTNO    DNAME          LOC
-----    -------   ------    ----------     ---------
7369     SMITH       20      Research       Dallas
7499     ALLEN       30      Sales          Chicago
7521     WARD        30      Sales          Chicago
7566     JONES       20      Research       Dallas
7654     MARTIN      30      Sales          Chicago
7698     BLAKE       30      Sales          Chicago
7782     CLARK       10      Accounting     New York
7788     SCOTT       20      Research       Dallas
7839     KING        10      Accounting     New York
7844     TURNER      30      Sales          Chicago
7876     ADAMS       20      Research       Dallas
7900     JAMES       30      Sales          Chicago
7902     FORD        20      Research       Dallas
7934     MILLER      10      Accounting     New York