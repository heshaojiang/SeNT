use feelview;

-- ������ڴ洢���̣���ɾ��
drop procedure if exists sp_removeCmlHis;
Delimiter //
CREATE  PROCEDURE  sp_removeCmlHis() 
begin
declare v_targetDate date;
declare v_partition varchar(10);
declare v_tranDate varchar(16);
declare v_removeNum int default 90;
declare v_tableName varchar(30);
     set @time=now();
     select DATE_ADD(@time,INTERVAL 0-v_removeNum day) into v_tranDate;
     select DATE_ADD(@time,INTERVAL 0-v_removeNum day) into v_targetDate;
     select DATE_FORMAT(v_targetDate,'%Y%m%d%H%i%S') into v_tranDate;
     select concat('P_',DATE_FORMAT(v_targetDate,'%m%d')) into v_partition;
     select concat('CML_SENT_INFOS_HIS_',DATE_FORMAT(v_targetDate,'%m%d')) into v_tableName;
     -- ��ֽ�����Ϣ��
     set @strSql = concat('ALTER TABLE CML_TASK_INFOS TRUNCATE PARTITION  ',v_partition );
     prepare p1 from @strSql;
	  execute p1;
	  deallocate prepare p1;
     
     -- ATM������Ϣ��
     set @strSql = concat('ALTER TABLE ATM_TRAN_INFO TRUNCATE PARTITION  ',v_partition );
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;
	
     -- �ӳ����ױ�
     set @strSql = concat('ALTER TABLE CML_LOAD_NOTES_RECORD TRUNCATE PARTITION  ',v_partition );
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;

     -- ���潻�ױ�
     set @strSql = concat('ALTER TABLE CML_COUNTER_RECORD TRUNCATE PARTITION  ',v_partition );
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;
 
     -- ���ֺ��뵼���¼��
     set @strSql = concat('ALTER TABLE CML_IMP_RECORDS TRUNCATE PARTITION  ',v_partition );
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;
     
     -- ֽ�ҹ��ֺ����
     set @strSql = concat('TRUNCATE TABLE ',v_tableName);
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;

     -- ֽ����ת��Ϣ��
     set @strSql = concat('DELETE FROM  CML_NOTEFLOW_INFO WHERE C_CLEARING_DATE<',v_tranDate);
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;
     commit;  

     -- ֽ����ת��Ϣ��ϸ��
     set @strSql = concat('DELETE FROM  CML_NOTEFLOW_DETAIL_INFO WHERE C_DATE<',v_tranDate);
     prepare p1 from @strSql;
	 execute p1;
	 deallocate prepare p1;
     commit;
end;
//
Delimiter ;

