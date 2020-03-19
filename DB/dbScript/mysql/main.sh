#!/bin/sh
mysql --default-character-set=utf8 << EOF
select 'start running main.sh' as '';
select '#########################################';
select 'running drop.sql ...... ' as '';
source ./script/drop.sql  
select 'drop.sql successed ' as '';

select 'running drop_CML_SENT_INFOS_HIS.sql ......' as '';
source ./script/drop_CML_SENT_INFOS_HIS.sql  
select 'drop_CML_SENT_INFOS_HIS.sql successed ' as '';

select 'running create.sql ......' as '';
source ./script/create.sql  
select 'create.sql successed ' as '';

select 'running create_CML_SENT_INFOS_HIS.sql ......' as '';
source ./script/create_CML_SENT_INFOS_HIS.sql  
select 'create_CML_SENT_INFOS_HIS.sql successed ' as '';

select 'running create_view.sql ......' as '';
source ./script/create_view.sql
select 'create_view.sql successed ' as '';

select 'running ddl_chage.sql ......' as '';
source ./script/ddl_chage.sql
select 'ddl_chage.sql successed ' as '';

select 'running init.sql ......' as '';
source ./script/init.sql
select 'init.sql successed ' as '';

select 'running version.sql ......' as '';
source ./script/version.sql  
select 'version.sql successed ' as '';

select 'running create_procedure.sql ......' as '';
source ./script/create_procedure.sql  
select 'create_procedure.sql successed' as '';

select 'running create_procedure_event.sql ......' as '';
source ./script/create_procedure_event.sql  
select 'create_procedure_event.sql successed' as '';

select '#########################################' as '';
select 'database init successed ' as '';

EOF
