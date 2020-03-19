#!/bin/sh

#创建表空间目录
#root 用户操作  单独执行
#mkdir -p /data/datafiles
#chown oracle  /data/datafiles 
#chgrp oracle  /data/datafiles 

# 切换到oracle 用户 单独执行
#su - oracle
#
#sqlplus / as sysdba << !
#@./script/create_talespace.sql
#exit;
#!
export NLS_LANG=AMERICAN_AMERICA.AL32UTF8
sqlplus feelview/feelview << EOF

@./script/drop.sql

@./script/drop_CML_SENT_INFOS_HIS.sql

@./script/create.sql

@./script/ddl_chage.sql

@./script/create_CML_SENT_INFOS_HIS.sql

@./script/create_view.sql

@./script/create_procedure.sql

@./script/init.sql

@./script/version.sql

@./script/AddDelJob.sql

@./script/alterTableFNoder.sql

@./script/init_noderType.sql

exit;
EOF
