use feelview;

delete from sys_param where C_ID='dbversion' and C_KEY='dbversion';

insert into sys_param (C_ID, C_PARENTID, C_KEY, C_NOTE, C_STATUS, C_VALUE, C_ENCRYPT_STATUS)
values (
	'dbversion', 
	'8a81db832fb8a525012fb8c47bc40021',
	'dbversion', 
	'version of structure of db tables', 
	'Y', 
	'BuildVersion', 
	'N'
);
commit;