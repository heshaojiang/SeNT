--执行时以‘/’为语句终止字符
CREATE OR REPLACE PROCEDURE sp_removeCmlHis(in removeNum  integer)
BEGIN
		DECLARE v_targetDate TIMESTAMP;
		DECLARE v_partition varchar(10);
		DECLARE v_tranDate varchar(16);
		DECLARE v_sql varchar(1000);
    DECLARE v_montnday varchar(4);
		DECLARE v_tableName varchar(30);
		DECLARE v_removeNum integer; 
		DECLARE st STATEMENT; 
		SET v_removeNum =removeNum;
     SET v_targetDate = CURRENT TIMESTAMP - v_removeNum DAY;
     SET v_tranDate = to_char(v_targetDate,'yyyymmddhh24miss');
     SET v_montnday = to_char(v_targetDate,'mmdd'); 
     SET v_partition = 'P_'||v_montnday;
     SET v_tableName = 'CML_SENT_INFOS_HIS_'||v_montnday;
   
     ---清分交易信息表
		 set v_sql ='ALTER TABLE CML_TASK_INFOS DETACH PARTITION '||v_partition||' INTO T_TASK_INFOS';
		 PREPARE st FROM v_sql; 
     execute st;
     set v_sql ='ALTER TABLE CML_TASK_INFOS ADD PARTITION '||v_partition||' STARTING '||v_montnday||' ENDING '||v_montnday;
     PREPARE st FROM v_sql; 
     execute st;
     DROP TABLE T_TASK_INFOS;
     
     
     ---ATM交易信息表
     set v_sql ='ALTER TABLE ATM_TRAN_INFO DETACH PARTITION '||v_partition||' INTO T_TRAN_INFO';
     PREPARE st FROM v_sql; 
     execute st;
     set v_sql ='ALTER TABLE ATM_TRAN_INFO ADD PARTITION '||v_partition||' STARTING '||v_montnday||' ENDING '||v_montnday;
     PREPARE st FROM v_sql; 
     execute st;
     DROP TABLE T_TRAN_INFO;
     
     --柜台交易表
     set v_sql ='ALTER TABLE CML_COUNTER_RECORD DETACH PARTITION '||v_partition||' INTO T_COUNTER_RECORD';
     PREPARE st FROM v_sql; 
     execute st;
     set v_sql ='ALTER TABLE CML_COUNTER_RECORD ADD PARTITION '||v_partition||' STARTING '||v_montnday||' ENDING '||v_montnday;
     PREPARE st FROM v_sql; 
     execute st;
     DROP TABLE T_COUNTER_RECORD;
     
     ---加钞交易表
     set v_sql ='ALTER TABLE CML_LOAD_NOTES_RECORD DETACH PARTITION '||v_partition||' INTO T_LOAD_NOTES_RECORD';
     PREPARE st FROM v_sql; 
     execute st;
     set v_sql ='ALTER TABLE CML_LOAD_NOTES_RECORD ADD PARTITION '||v_partition||' STARTING '||v_montnday||' ENDING '||v_montnday;
     PREPARE st FROM v_sql; 
     execute st;
     DROP TABLE T_LOAD_NOTES_RECORD;
     
     ---冠字号码导入记录表
     set v_sql ='ALTER TABLE CML_IMP_RECORDS DETACH PARTITION '||v_partition||' INTO T_IMP_RECORDS';
     PREPARE st FROM v_sql; 
     execute st;
     set v_sql ='ALTER TABLE CML_IMP_RECORDS ADD PARTITION '||v_partition||' STARTING '||v_montnday||' ENDING '||v_montnday;
     PREPARE st FROM v_sql; 
     execute st;
     DROP TABLE T_IMP_RECORDS;
     
     ---纸币冠字号码表
     set v_sql ='ALTER TABLE '||v_tableName||' ACTIVATE NOT LOGGED INITIALLY WITH EMPTY TABLE';
     PREPARE st FROM v_sql; 
     execute st;
     
     ---纸币流转信息表
     DELETE FROM  CML_NOTEFLOW_INFO WHERE C_CLEARING_DATE<v_tranDate;
     commit;   
     
     ---纸币流转信息详细表
     DELETE FROM  CML_NOTEFLOW_DETAIL_INFO WHERE C_DATE < v_tranDate;
     commit;
END
/
