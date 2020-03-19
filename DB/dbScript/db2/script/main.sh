#安装db2用户名为 feelview
db2set DB2CODEPAGE=1208
db2set DB2_EVALUNCOMMITTED=ON
db2set DB2_SKIPDELETED=ON
db2set DB2_SKIPINSERTED=ON
db2set DB2_CAPTURE_LOCKTIMEOUT=ON
db2 force applications all
db2 deactive db FEELVIEW
db2 drop database FEELVIEW
db2 CREATE DATABASE FEELVIEW ON /home/feelview USING CODESET UTF-8 TERRITORY CN pagesize 8192
db2 connect to FEELVIEW

db2 -tvf createdb.sql -l createdb.log
db2 terminate
db2stop force
db2start

db2 connect to FEELVIEW
db2 grant dbadm on database to user feelview
db2 commit
db2 connect reset

db2 connect to FEELVIEW user feelview using feelview
db2 set current schema FEELVIEW
db2 -tvf DB_DDL.sql -l DB_DDL.log
db2 -td/ -vf DB_DDL_2.sql -l DB_DDL_2.log
db2 -tvf DB_DATA.sql -l DB_DATA.log
db2 -tvf dll_chage.sql -l dll_chage.log
db2 commit work
db2 terminate
