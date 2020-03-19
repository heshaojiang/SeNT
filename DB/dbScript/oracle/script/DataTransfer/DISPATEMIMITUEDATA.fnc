CREATE OR REPLACE FUNCTION DISPATEMIMITUEDATA(IMINUTE INTEGER) RETURN VARCHAR2
IS
    --声明结构体
    TYPE RE_SENT_INFOS IS RECORD(
      ID         CML_SENT_INFOS_HOUR.C_ID%type,
      TRAN_ID    CML_SENT_INFOS_HOUR.C_TRAN_ID%type,
      TERMID     CML_SENT_INFOS_HOUR.C_TERMID%type,
      JOURNAL_NO    CML_SENT_INFOS_HOUR.C_JOURNAL_NO%type,
      IMAGE_TYPE     CML_SENT_INFOS_HOUR.C_IMAGE_TYPE%type,
      SEQUENCE    CML_SENT_INFOS_HOUR.I_SEQUENCE%type,
      FILENAME         CML_SENT_INFOS_HOUR.C_FILENAME%type,
      BARCODE_FLOWNUM    CML_SENT_INFOS_HOUR.C_BARCODE_FLOWNUM%type,
      NOTE_FLAG         CML_SENT_INFOS_HOUR.C_NOTE_FLAG%type,
      NOTE_TYPE    CML_SENT_INFOS_HOUR.C_NOTE_TYPE%type,
      CURRENCY         CML_SENT_INFOS_HOUR.C_CURRENCY%type,
      DENOMINATION    CML_SENT_INFOS_HOUR.C_DENOMINATION%type,
      VERSION_NUM     CML_SENT_INFOS_HOUR.C_VERSION_NUM%type,
      SERIA_NO    CML_SENT_INFOS_HOUR.C_SERIA_NO%type,
      ERROR_CODE     CML_SENT_INFOS_HOUR.C_ERROR_CODE%type,
      RESERVE    CML_SENT_INFOS_HOUR.C_RESERVE%type,
      TRAN_DATE         CML_SENT_INFOS_HOUR.C_TRAN_DATE%type,
      TRAN_MONTHDAY    CML_SENT_INFOS_HOUR.C_TRAN_MONTHDAY%type,
      TRAN_MINUTE		CML_SENT_INFOS_HOUR.C_TRAN_MINUTE%type,
      TERM_TYPE         CML_SENT_INFOS_HOUR.C_TERM_TYPE%type,
      PATHCODE    CML_SENT_INFOS_HOUR.C_PATHCODE%type,
      MACHINESNO         CML_SENT_INFOS_HOUR.C_MACHINESNO%type
    );

    --定义变量
    v_SentInfo RE_SENT_INFOS;
    TYPE EMP_CUR IS REF CURSOR;
    myCusor EMP_CUR;
    v_BatchNum  INTEGER;
    v_sql varchar2(2000);
    sPartName varchar2(5);
     X NUMBER;
BEGIN
     DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')||'proc begin '||IMINUTE||'..');
     SELECT COUNT(1) INTO X FROM USER_TABLES WHERE TABLE_NAME='TMP_MINIYUE_DATA';
     IF X>0 THEN
        DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')||'drop 临时表..');
        v_sql := 'DROP TABLE TMP_MINIYUE_DATA';
        EXECUTE IMMEDIATE v_sql;
     END IF;
     DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')||'create 临时表..');
     v_sql := 'CREATE TABLE TMP_MINIYUE_DATA AS SELECT * FROM CML_SENT_INFOS_HOUR WHERE 1=2';
     EXECUTE IMMEDIATE v_sql;
     DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')||'交换分区..');
     sPartName:='P_'||trim(TO_CHAR(iMinute, '09'));
     v_sql := 'ALTER TABLE CML_SENT_INFOS_HOUR EXCHANGE PARTITION '||sPartName||' WITH TABLE TMP_MINIYUE_DATA';
     EXECUTE IMMEDIATE v_sql;
      --开始使用游标取数据
      DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')||'分发数据...');
      v_BatchNum := 0;
      BEGIN
        OPEN myCusor FOR 'SELECT C_ID, C_TRAN_ID, C_TERMID, C_JOURNAL_NO, C_IMAGE_TYPE, I_SEQUENCE, C_FILENAME,'||
          ' C_BARCODE_FLOWNUM, C_NOTE_FLAG, C_NOTE_TYPE, C_CURRENCY, C_DENOMINATION, C_VERSION_NUM, C_SERIA_NO,'||
          ' C_ERROR_CODE, C_RESERVE, C_TRAN_DATE, C_TRAN_MONTHDAY, C_TRAN_MINUTE, C_TERM_TYPE, C_PATHCODE, '
          ||'C_MACHINESNO FROM TMP_MINIYUE_DATA';

        LOOP
          FETCH myCusor INTO v_SentInfo;
          --游标取不到数据则退出
          EXIT WHEN myCusor%NOTFOUND;

          --备份数据
          BEGIN
          v_sql := 'INSERT /*+APPEND*/ INTO CML_SENT_INFOS_HIS_'||v_SentInfo.TRAN_MONTHDAY||
                '(C_ID, C_TRAN_ID, C_TERMID, C_JOURNAL_NO, C_IMAGE_TYPE, I_SEQUENCE, C_FILENAME,'||
                'C_BARCODE_FLOWNUM, C_NOTE_FLAG, C_NOTE_TYPE, C_CURRENCY, C_DENOMINATION, C_VERSION_NUM, C_SERIA_NO,'||
                'C_ERROR_CODE, C_RESERVE, C_TRAN_DATE, C_TRAN_MONTHDAY, C_TRAN_MINUTE, C_TERM_TYPE, C_PATHCODE, C_MACHINESNO)'||
                'VALUES(:v1,:v2,:v3,:v4,:v5,:v6,:v7,:v8,:v9,:v10,:v11,:v12,:v13,:v14,:v15,:v16,:v17,:v18,:v19,:v20,:v21,:v22)';
          --DBMS_OUTPUT.PUT_LINE('备份数据SQL='||v_sql);
          EXECUTE IMMEDIATE v_sql USING v_SentInfo.ID,v_SentInfo.TRAN_ID,v_SentInfo.TERMID,v_SentInfo.JOURNAL_NO,
            v_SentInfo.IMAGE_TYPE,v_SentInfo.SEQUENCE,v_SentInfo.FILENAME,v_SentInfo.BARCODE_FLOWNUM,v_SentInfo.NOTE_FLAG,
            v_SentInfo.NOTE_TYPE,v_SentInfo.CURRENCY,v_SentInfo.DENOMINATION,v_SentInfo.VERSION_NUM,v_SentInfo.SERIA_NO,
            v_SentInfo.ERROR_CODE,v_SentInfo.RESERVE,v_SentInfo.TRAN_DATE,v_SentInfo.TRAN_MONTHDAY,v_SentInfo.TRAN_MINUTE,
            v_SentInfo.TERM_TYPE,v_SentInfo.PATHCODE,v_SentInfo.MACHINESNO;
          --发生异常时返回错误码
          EXCEPTION
             WHEN Dup_val_on_index THEN
                  --DBMS_OUTPUT.PUT_LINE('主键已经存在 C_ID:'||v_SentInfo.ID);
                  GOTO nextloop;
             WHEN OTHERS THEN
                  RAISE;
          END INEER1;
          v_BatchNum := v_BatchNum + 1;

          --批量提交
          IF MOD(v_BatchNum,12000) = 0 THEN
             COMMIT;
           END IF;
          <<nextloop>>
            null;
        END LOOP;
        CLOSE myCusor;
        EXCEPTION
          WHEN OTHERS THEN
            CLOSE myCusor;
            RAISE;
      END myCusor;

     --最后一次提交
     IF MOD(v_BatchNum,12000) <> 0 THEN
        COMMIT;
     END IF;
     DBMS_OUTPUT.PUT_LINE(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')||'proc end '||IMINUTE||'..');

     RETURN '';
    --发生异常时返回错误码
    EXCEPTION
      WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE(SQLCODE||'---'||SQLERRM);
      ROLLBACK;
      RETURN '';
END;
/
