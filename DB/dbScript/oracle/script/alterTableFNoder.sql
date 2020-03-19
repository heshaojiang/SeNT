-- Add/modify columns 
alter table NODER_INFO add c_noder_type VARCHAR2(15);
-- Add comments to the columns 
comment on column NODER_INFO.c_noder_type  is '节点类型 0 地市server,1 标准版节点机,2 柜面节点机,3 节点机管理端';

-- Add/modify columns 
alter table NODER_VERSION_INFO add c_noder_type VARCHAR2(15);
-- Add comments to the columns 
comment on column NODER_VERSION_INFO.c_noder_type  is '节点类型 0 地市server,1 标准版节点机,2 柜面节点机,3 节点机管理端';

update NODER_INFO set c_noder_type='1';
update NODER_VERSION_INFO set c_noder_type='1';
commit;