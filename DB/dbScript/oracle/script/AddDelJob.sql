--删除定时任务
begin
  for v in(select job from user_jobs where what in('SP_REMOVECMLHIS(90);') ) 
  loop
    dbms_job.remove(v.job);
  end loop;
  commit;
end;
/

--定义定时任务
declare
jobno number;
begin 
dbms_job.submit(
jobno,
'SP_REMOVECMLHIS(90);',
sysdate,
'trunc(sysdate)+1+1/24'); 
commit;
end;
/
--启动定时任务
declare
  v_jobid int:=0;
begin
  select job into v_jobid from user_jobs where what='SP_REMOVECMLHIS(90);';
  dbms_job.run(v_jobid);
end;
/
