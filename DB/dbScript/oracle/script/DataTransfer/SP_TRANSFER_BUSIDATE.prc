CREATE OR REPLACE PROCEDURE SP_TRANSFER_BUSIDATE(
                 iCurMinute IN  NUMBER,         --当前分钟数(0-59)
                 iTraMinutes IN	NUMBER					--需要转移分钟数(1-50)
)
AS
		--定义变量
		v_Var  NUMBER;
		v_Minute integer;
    v_str varchar2(50);
BEGIN
		v_Var :=  iCurMinute - iTraMinutes;
    --循环调用
    WHILE v_Var < iCurMinute LOOP
    	v_Minute := v_Var;
    	IF v_Minute < 0 THEN
    		v_Minute := v_Minute+60;
    	END IF;
    	v_str:=dispateMimitueData(v_Minute);
    	v_Var := v_Var+1;
    END LOOP;
    --发生异常时返回错误码
		EXCEPTION
			WHEN OTHERS THEN
			DBMS_OUTPUT.PUT_LINE(SQLCODE||'---'||SQLERRM);
END;
/
