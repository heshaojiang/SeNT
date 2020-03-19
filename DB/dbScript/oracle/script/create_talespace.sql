--创建用户默认表空间, 临时表空间
CREATE  TABLESPACE USER_DATA DATAFILE  '/data/datafiles/user_data.dbf' SIZE 1G AUTOEXTEND ON NEXT 100M;
CREATE  TEMPORARY TABLESPACE USER_TEMP TEMPFILE  '/data/datafiles/user_temp.dbf' SIZE 1G AUTOEXTEND ON NEXT 100M;

-- 创建用户  feelview
-- drop user feelview cascade;
create user feelview
  identified by feelview
  default tablespace USER_DATA
  temporary tablespace USER_TEMP
  profile DEFAULT;
-- Grant/Revoke role privileges 
grant connect to feelview;
grant dba to feelview with admin option;
grant resource to feelview with admin option;
-- Grant/Revoke system privileges 
grant create any table to feelview;
grant create table to feelview;
grant unlimited tablespace to feelview with admin option;

--创建数据库表空间
CREATE BIGFILE TABLESPACE TRAN_DATA DATAFILE  '/data/datafiles/tran_data.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_DATA_01 DATAFILE  '/data/datafiles/gzhm_data_01.dbf' SIZE 10G AUTOEXTEND ON NEXT  2G;
CREATE BIGFILE TABLESPACE GZHM_DATA_02 DATAFILE  '/data/datafiles/gzhm_data_02.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_DATA_03 DATAFILE  '/data/datafiles/gzhm_data_03.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_DATA_04 DATAFILE  '/data/datafiles/gzhm_data_04.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;

--创建索数据库表引表空间
CREATE BIGFILE TABLESPACE TRAN_INDX DATAFILE  '/data/datafiles/tran_indx.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_INDX_01 DATAFILE  '/data/datafiles/gzhm_indx_01.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_INDX_02 DATAFILE  '/data/datafiles/gzhm_indx_02.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_INDX_03 DATAFILE  '/data/datafiles/gzhm_indx_03.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
CREATE BIGFILE TABLESPACE GZHM_INDX_04 DATAFILE  '/data/datafiles/gzhm_indx_04.dbf' SIZE 10G AUTOEXTEND ON NEXT 2G;
