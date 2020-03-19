-- Create table
--create table NODER_INFO
--(
--  c_id             VARCHAR2(32) not null,
--  c_orgcode        VARCHAR2(64) not null,
--  i_version        NUMBER(8) not null,
--  c_noderip        VARCHAR2(15) not null,
--  c_running_status VARCHAR2(2),
--  c_status_time    DATE,
--  c_parameter      VARCHAR2(256),
--  c_device         VARCHAR2(256),
--  c_install_dir    VARCHAR2(256),
--  c_midlevel_ip    VARCHAR2(15),
--  c_info_version   VARCHAR2(32)
--) tablespace TRAN_DATA;
-- Add comments to the table 
comment on table NODER_INFO
  is '节点机信息表';
-- Add comments to the columns 
comment on column NODER_INFO.c_id
  is '主键';
comment on column NODER_INFO.c_orgcode
  is '机构编号';
comment on column NODER_INFO.i_version
  is '节点机版本号 从0开始，后续的版本号，逐渐增加';
comment on column NODER_INFO.c_noderip
  is '节点机IP';
comment on column NODER_INFO.c_running_status
  is '节点机状态 0-正常 1-故障';
comment on column NODER_INFO.c_status_time
  is '节点机状态 更新时间';
comment on column NODER_INFO.c_parameter
  is '参数信息 形如(uploadtime:00:00:00-23:59:00,bandwidth:1000)';
comment on column NODER_INFO.c_device
  is '设备信息 形如(00000001,00000002)';
comment on column NODER_INFO.c_install_dir
  is '节点机安装目录';
comment on column NODER_INFO.c_midlevel_ip
  is '中间层IP';
comment on column NODER_INFO.c_info_version
  is '节点机版本信息(节点机本身的版本)';
-- Create/Recreate indexes 
--create index IDX_NODER_INFO_ORGCODE on NODER_INFO (C_ORGCODE) tablespace TRAN_INDX;
-- Create/Recreate primary, unique and foreign key constraints 
--alter table NODER_INFO
--  add constraint PK_NODER_INFO primary key (c_id) USING INDEX tablespace TRAN_INDX;

-- Create table
--create table NODER_VERSION_INFO
--(
--  c_id            VARCHAR2(32) not null,
--  i_version       NUMBER(8) not null,
--  c_package_name  VARCHAR2(128) not null,
--  i_relay_version  NUMBER(8),
--  c_orgcode       VARCHAR2(64),
--  c_status        VARCHAR2(2),
--  d_create_time   DATE,
--  c_create_userid VARCHAR2(32),
--  d_check_time    DATE,
--  c_check_userid  VARCHAR2(32),
--  c_check_notice  VARCHAR2(100),
--  c_remark        VARCHAR2(256)
--) tablespace TRAN_DATA;
-- Add comments to the table 
comment on table NODER_VERSION_INFO
  is '节点机版本信息表';
-- Add comments to the columns 
comment on column NODER_VERSION_INFO.c_id
  is '主键';
comment on column NODER_VERSION_INFO.i_version
  is '版本号 从0开始递增';
comment on column NODER_VERSION_INFO.c_package_name
  is '版本包名称';
comment on column NODER_VERSION_INFO.i_relay_version
  is '依赖的版本号 为空时，表示无依赖的版本，可以直接升级';
comment on column NODER_VERSION_INFO.c_orgcode
  is '升级的机构号';
comment on column NODER_VERSION_INFO.c_status
  is '状态 00-	初始状态，等待审核 01-审核通过 02-	审核失败';
comment on column NODER_VERSION_INFO.d_create_time
  is '创建时间';
comment on column NODER_VERSION_INFO.c_create_userid
  is '创建人员';
comment on column NODER_VERSION_INFO.d_check_time
  is '审核时间';
comment on column NODER_VERSION_INFO.c_check_userid
  is '审核人员';
comment on column NODER_VERSION_INFO.c_check_notice
  is '审核意见';
comment on column NODER_VERSION_INFO.c_remark
  is '备注';
-- Create/Recreate indexes 
--create index IDX1_NODER_VERSION_INFO on NODER_VERSION_INFO (C_ORGCODE) tablespace TRAN_INDX;
-- Create/Recreate primary, unique and foreign key constraints 
--alter table NODER_VERSION_INFO
--  add constraint PK_NODER_VERSION_INFO primary key (c_id) USING INDEX tablespace TRAN_INDX;

-- Create table
--create table NODER_FILE
--(
--  c_id          VARCHAR2(32) not null,
--  c_noderid     VARCHAR2(32) not null,
--  c_orgcode     VARCHAR2(64) not null,
--  c_filetype    VARCHAR2(2),
--  c_tran_data   VARCHAR2(128),
--  d_operdate    DATE,
--  c_filename    VARCHAR2(256),
--  c_status      VARCHAR2(2),
--  c_midlevel_ip VARCHAR2(15)
--) tablespace TRAN_DATA;
-- Add comments to the table 
comment on table NODER_FILE
  is '节点机文件表';
-- Add comments to the columns 
comment on column NODER_FILE.c_id
  is '序号 递增序列';
comment on column NODER_FILE.c_noderid
  is '节点机编号';
comment on column NODER_FILE.c_orgcode
  is '机构编号';
comment on column NODER_FILE.c_filetype
  is '文件类型 1-配置文件 2-日志文件 3-其它文件 4-文件夹';
comment on column NODER_FILE.c_tran_data
  is '交易数据';
comment on column NODER_FILE.d_operdate
  is '操作时间';
comment on column NODER_FILE.c_filename
  is '文件名';
comment on column NODER_FILE.c_status
  is '状态 0-初始状态 1-获取文件成功 2-获取文件失败';
comment on column NODER_FILE.c_midlevel_ip
  is '中间层IP';
-- Create/Recreate indexes 
--create index IDX2_NODER_FILE on NODER_FILE (C_ORGCODE) tablespace TRAN_INDX;
-- Create/Recreate primary, unique and foreign key constraints 
--alter table NODER_FILE
--  add constraint PK_NODER_FILE primary key (c_id) USING INDEX tablespace TRAN_INDX;
--alter table NODER_FILE
--  add constraint IDX1_NODER_FILE unique (C_NODERID, C_FILETYPE, C_TRAN_DATA) USING INDEX tablespace TRAN_INDX;
  
-- Add/modify columns 
--alter table TML_INFO add c_teller_ip Varchar2(15);
-- Add comments to the columns 
comment on column TML_INFO.c_teller_ip  is '柜面IP信息 A类点钞机对应的柜面IP信息，为空时不对应';
  
-- Add/modify columns 
--alter table CML_IMP_RECORDS add c_getimage_falg VARCHAR2(2);
--alter table CML_IMP_RECORDS add c_source_ip VARCHAR2(20);
--alter table CML_IMP_RECORDS add c_upload_flag VARCHAR2(2);
-- Add comments to the columns 
comment on column CML_IMP_RECORDS.c_getimage_falg
  is '获取图像标识 0 未获取图像文件 1 已经获取图像文件 其它 不用获取图像';
comment on column CML_IMP_RECORDS.c_source_ip
  is '上传的源IP';
comment on column CML_IMP_RECORDS.c_upload_flag
  is '上传服务器标识';
  
 -- Create table
--create table TELLER_TRAN_INFO
--(
--  transeq      VARCHAR2(32) not null,
--  bankno       VARCHAR2(12),
--  tellerno     VARCHAR2(12),
--  account      VARCHAR2(24),
--  customname   VARCHAR2(24),
--  idtype       VARCHAR2(2),
--  idnum        VARCHAR2(24),
--  trancode     VARCHAR2(12),
--  tranname     VARCHAR2(36),
--  tranmoneysum NUMBER(10),
--  trantime     DATE,
--  tellerip     VARCHAR2(15)
--) tablespace TRAN_DATA;
-- Add comments to the table 
comment on table TELLER_TRAN_INFO
  is '柜面交易信息表';
-- Add comments to the columns 
comment on column TELLER_TRAN_INFO.transeq
  is '交易流水号';
comment on column TELLER_TRAN_INFO.bankno
  is '行所号';
comment on column TELLER_TRAN_INFO.tellerno
  is '柜员号';
comment on column TELLER_TRAN_INFO.account
  is '客户账号';
comment on column TELLER_TRAN_INFO.customname
  is '客户名称';
comment on column TELLER_TRAN_INFO.idtype
  is '证件类型码 01-身份证、02-军官证等';
comment on column TELLER_TRAN_INFO.idnum
  is '证件号码';
comment on column TELLER_TRAN_INFO.trancode
  is '交易码';
comment on column TELLER_TRAN_INFO.tranname
  is '交易名称';
comment on column TELLER_TRAN_INFO.tranmoneysum
  is '交易金额，单位分';
comment on column TELLER_TRAN_INFO.trantime
  is '交易时间';
comment on column TELLER_TRAN_INFO.tellerip
  is '柜台IP';
-- Create/Recreate indexes 
--create index IDX1_TELLER_TRAN_INFO on TELLER_TRAN_INFO (TELLERIP, TRANTIME) tablespace TRAN_INDX;
-- Create/Recreate primary, unique and foreign key constraints 
--alter table TELLER_TRAN_INFO
--  add constraint P_TELLER_TRAN_INFO primary key (TRANSEQ) USING INDEX tablespace TRAN_INDX;



COMMIT;