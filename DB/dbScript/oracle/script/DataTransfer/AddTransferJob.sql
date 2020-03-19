declare
	jobno number;
begin 
	dbms_job.submit(
		jobno,
		'SP_TRANSFER_BUSIDATE(to_number(to_char(sysdate-1/1440,''mi'')), 5);',
		sysdate,
		'trunc(sysdate,''mi'')+5/1440'); 
	commit;
end;
/

--启动定时任务
declare
  v_jobid int:=0;
begin
  select job into v_jobid from dba_jobs where what='SP_TRANSFER_BUSIDATE(to_number(to_char(sysdate-1/1440,''mi'')), 5);';
  dbms_job.run(v_jobid);
end;
/