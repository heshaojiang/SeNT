package com.grgbanking.platform.module.msg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.msg.entity.MsgEventDef;

/**
 * Description： 消息事件定义
 */

@Repository
@Transactional
public class MsgEventDefDao extends BaseDao<MsgEventDef> {

	public Page<MsgEventDef> getMsgEventDefPageByParams(final Page<MsgEventDef> page, Map<String, String> params) {
		StringBuffer hql = new StringBuffer(" from MsgEventDef med ");
		Map<String, Object> param = new HashMap<String, Object>();
		if (params.size() > 0) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("eventType") && !paramValue.equals("")) {
					hql.append(" med.eventType = :eventType and ");
					param.put("eventType", paramValue);
				} else if (key.equals("informManner")) {
					hql.append(" med.informManner = :informManner and ");
					param.put("informManner", paramValue);
				} else if (key.equals("sourceId")) {
					hql.append(" ( med.sourceId like :sourceId or ((select o.orgName from OrgInfo o where o.id = med.sourceId ) like :orgName )) and ");
					param.put("sourceId", "%" + paramValue + "%");
					param.put("orgName", paramValue + "%");
				} else if (key.equals("orgLevelCode")) {
					// hql +=
					// " and (select o.levelCode from OrgInfo o where o.id = tm.orgId ) like '"
					// + paramValue + "%";
				}
			}
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		return super.findPage(page, hql.toString(), param);
	}

	/**
	 * 按模板ID来查找事件定义
	 * 
	 * @param p_id
	 * @return
	 */
	public List<MsgEventDef> findMsgEventByTemplateId(String p_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		String hql = " from MsgEventDef med where med.msgTemplate = :tempId";
		param.put("tempId", p_id);
		return find(hql, param);
	}
}
