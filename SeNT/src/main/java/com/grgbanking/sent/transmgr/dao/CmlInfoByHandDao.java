package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlInfoByHand;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;
@Repository
public class CmlInfoByHandDao extends BaseDao<CmlInfoByHand> {
	private static final String QUERY_CML_INFO_BYHAND_SQL = "select cibh,o.orgName " +
	"from CmlInfoByHand cibh, OrgInfo o where cibh.pathCode = o.pathCode ";
	
	@Autowired
	OrgInfoDao orgInfoDao;
/**
* 人工清分管理
* 
* @param page
*            页面信息
* @param conditions
*            查询条件
*/
	public Page findListByConditions(Page<CmlInfoByHand> page, Map<String, String> conditions)
	{	
		StringBuffer hql = new StringBuffer(QUERY_CML_INFO_BYHAND_SQL);
		String startTime    = DateUtil.dateFormatTohms(conditions.get("startTime"));
		String endTime      = DateUtil.dateFormatTohms(conditions.get("endTime"));
		String pathCode     = orgInfoDao.getByKey(conditions.get("pathCode")).getPathCode();
		String flag               =  (String)conditions.get("flag");
		List<String> parameterList = new ArrayList<String>();
		
		
	if (StringUtil.isNotBlank(pathCode)) {
		if(null == flag || flag.equals("true")){
			parameterList.add(pathCode + "%");
			hql.append("and cibh.pathCode like ? ");
		}else{
			parameterList.add(pathCode + "");
			hql.append("and cibh.pathCode = ? ");
		}
	}
	
	// 开始时间
	if (StringUtil.isNotBlank(startTime)) {
		parameterList.add(startTime);
		hql.append("and cibh.tranTime >= ? ");
	}
	// 结束时间
	if (StringUtil.isNotBlank(endTime)) {
		parameterList.add(endTime);
		hql.append("and cibh.tranTime <= ? ");
	}
	
	
	// 返回查询结果
	return super.findPage(page, hql.toString(), parameterList.toArray());
	
	}
	public boolean existCmlInfoByHand(String orgId){
		List list = super.findBy("orgId", orgId);
		if (list != null && list.size() > 0){
			return true;
		}
		return false;
	}
	public CmlInfoByHand getCmlInfoByHandByPathcode(String pathcode)
	{
		String hql = 	" select cibh " +
						" from CmlInfoByHand cibh" +
						" where cibh.pathCode = ?";
		return this.findFirst(hql, pathcode);
	}

}
