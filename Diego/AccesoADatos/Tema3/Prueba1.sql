DECLARE
  v_dept99 NUMBER(2);

BEGIN 
  SELECT COUNT(*) INTO v_dept99 FROM DEPART WHERE dept_no=99;

  IF (v_dept99 = 0)
    THEN
  INSERT INTO DEPART VALUES (99,'TEMPORTAL','TEMPORAL');
  END IF;
  
  UPDATE EMPLE SET DEPT_NO = 99 WHERE DEPT_NO = 10;
  
  DELETE FROM DEPART WHERE DEPT_NO = 10;


END;
/

