use feelview;

--
create or replace view v_usr_roleprivi_info as
(
	select up.c_id as c_priviid, up.c_menuid as c_parentid, si1.c_name as c_parentname, up.c_buttonid as c_childid,
		   si.c_name as c_childname, si.c_language, '1' as c_isbutton
	from menu_button mb, sys_i18n si,usr_privilege up, sys_i18n si1
	where mb.c_id = si.c_referenceid
		  and mb.c_id = up.c_buttonid
		  and up.c_menuid = si1.c_referenceid
		  and si.c_language = si1.c_language)
	union
	(select up.c_id as c_priviid, mi.c_parentid, si1.c_name as c_parentname, mi.c_id as c_childid,
		   si.c_name as c_childname, si.c_language, '0' as c_isbutton
	from usr_privilege up, menu_info mi left outer join sys_i18n si on mi.c_id = si.c_referenceid
		 left outer join sys_i18n si1 on mi.c_parentid = si1.c_referenceid and si.c_language = si1.c_language
	where mi.c_id = up.c_menuid
		  and up.c_buttonid is null
);


--
create or replace view v_usr_userallrole as
(
	select distinct ug.C_USERID, gr.C_ROLEID from USR_GRPROLE gr, USR_USERGRP ug
	where gr.C_GRPID = ug.C_GRPID
)
union
(
	select ur.c_userid, ur.C_ROLEID from USR_USERROLE ur
);




--
create or replace view v_usr_userinfo as
(
	select distinct ur.C_USERID, rp.c_priviid as c_priviId
	from v_usr_userallrole ur
	left outer join USR_ROLEPRIVI rp on ur.C_ROLEID = rp.C_ROLEID
);
