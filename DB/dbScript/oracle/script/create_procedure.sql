
create or replace procedure sp_removeCmlHis(removeNum in int) as
v_targetDate date;
v_partition varchar(10);
v_tranDate varchar(16);
v_sql varchar2(1000) :='';
v_removeNum int:=removeNum;
v_tableName varchar2(30);
begin
     select trunc(sysdate)-v_removeNum v_tranDate into v_targetDate from dual;
     v_tranDate:=to_char(v_targetDate,'yyyymmddhh24miss');
     v_partition:='P_'||to_char(v_targetDate,'mmdd');
     v_tableName:='CML_SENT_INFOS_HIS_'||to_char(v_targetDate,'mmdd');
   
     ---清分交易信息表
     v_sql :='ALTER TABLE CML_TASK_INFOS TRUNCATE PARTITION  '||v_partition ||' update global indexes ';
     execute immediate v_sql;
     
     ---ATM交易信息表
     v_sql :='ALTER TABLE ATM_TRAN_INFO TRUNCATE PARTITION  '||v_partition ||' update global indexes ';
     execute immediate v_sql;
     
     ---加钞交易表
     v_sql :='ALTER TABLE CML_LOAD_NOTES_RECORD TRUNCATE PARTITION  '||v_partition ||' update global indexes ';
     execute immediate v_sql;
     commit;
     
     ---柜面交易表
     v_sql :='ALTER TABLE CML_COUNTER_RECORD TRUNCATE PARTITION  '||v_partition ||' update global indexes ';
     execute immediate v_sql;
     commit;
     
     ---冠字号码导入记录表
     v_sql :='ALTER TABLE CML_IMP_RECORDS TRUNCATE PARTITION  '||v_partition ||' update global indexes';
     execute immediate v_sql;
     
     ---纸币冠字号码表
     v_sql :='TRUNCATE TABLE '||v_tableName;
     execute immediate v_sql;
     
     ---纸币流转信息表
     v_sql :='DELETE FROM  CML_NOTEFLOW_INFO WHERE C_CLEARING_DATE<'||v_tranDate;
     execute immediate v_sql;
     commit;   
     
     ---纸币流转信息详细表
     v_sql :='DELETE FROM  CML_NOTEFLOW_DETAIL_INFO WHERE C_DATE<'||v_tranDate;
     execute immediate v_sql;
     commit;
end;
/
