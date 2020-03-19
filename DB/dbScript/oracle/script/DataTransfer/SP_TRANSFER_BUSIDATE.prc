CREATE OR REPLACE PROCEDURE SP_TRANSFER_BUSIDATE(
                 iCurMinute IN  NUMBER,         --��ǰ������(0-59)
                 iTraMinutes IN	NUMBER					--��Ҫת�Ʒ�����(1-50)
)
AS
		--�������
		v_Var  NUMBER;
		v_Minute integer;
    v_str varchar2(50);
BEGIN
		v_Var :=  iCurMinute - iTraMinutes;
    --ѭ������
    WHILE v_Var < iCurMinute LOOP
    	v_Minute := v_Var;
    	IF v_Minute < 0 THEN
    		v_Minute := v_Minute+60;
    	END IF;
    	v_str:=dispateMimitueData(v_Minute);
    	v_Var := v_Var+1;
    END LOOP;
    --�����쳣ʱ���ش�����
		EXCEPTION
			WHEN OTHERS THEN
			DBMS_OUTPUT.PUT_LINE(SQLCODE||'---'||SQLERRM);
END;
/
