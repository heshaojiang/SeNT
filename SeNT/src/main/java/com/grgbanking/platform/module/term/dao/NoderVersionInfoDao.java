/**
 * 文件名：TermInfoDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.term.entity.NoderVersionInfo;

/**
 * 终端基础信息 Dao<br>
 * 
 * Terminal basal information Dao
 * 
 * @author Jonas
 * 
 */
@Repository
public class NoderVersionInfoDao extends BaseDao<NoderVersionInfo>
{

	@Autowired
	private OrgInfoDao orgDao;
	@Autowired
	private UserDao userInfoDao ;

	/**
	 * 根据参数查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by params and page information
	 * 
	 * @param page
	 *            页对象
	 * @param params
	 *            条件参数
	 * @return Page<NoderInfo>
	 */
	public Page<NoderVersionInfo> getNoderVersionInfoPageByParams(Page<NoderVersionInfo> page, Map<String,String> params) {
		
//		updateRunningStatus();//刷新节点机状态
		System.out
				.println("NoderVersionInfoDao.getNoderVersionInfoPageByParams()");
		Map<String, Object> param = new HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer(" from NoderVersionInfo tm ");
		hql.append(WHERE);
		for (String key : params.keySet()) {
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("version_status") && !paramValue.equals("")) {
				hql.append(" tm.status = :status and ");
				param.put("status", paramValue);
			}
			
			if (key.equals("noderType") && !paramValue.equals("")) {
				hql.append(" tm.noderType = :noderType and ");
				param.put("noderType", paramValue);
			}
			
//			else if (key.equals("userOrgid")) {
//				String pathCode = orgDao.getPathCodeById(paramValue);
//				hql.append(" (select o2.pathCode from OrgInfo o2 where o2.id = tm.orgId ) like :pathCode and ");
//				param.put("pathCode", pathCode + "%");
//			} 
		}
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}
		Page resultPage = super.findPage(page, hql.toString(), param);
		List<NoderVersionInfo> resultVersion = resultPage.getResult() ;
		for(NoderVersionInfo nvi : resultVersion) {
			String orgCode = nvi.getOrgCode() ;
			String createUserId = nvi.getCreateUserId() ;
			String checkUserId = nvi.getCheckUserId() ;
			if(StringUtils.isNotBlank(orgCode)) {
				OrgInfo oi = orgDao.getByOrgCode(orgCode) ;
				if(oi != null) {
					nvi.setOrgName(oi.getOrgName()) ;
				}
			}
			if(StringUtils.isNotBlank(createUserId)) {
				User u = userInfoDao.get(createUserId) ;
				if(u != null) {
					nvi.setCreateUserCode(u.getUserCode()) ;
				} 
				
			}
			if(StringUtils.isNotBlank(checkUserId)) {
				User u = userInfoDao.get(checkUserId) ;
				if(u != null) {
					nvi.setCheckUserCode(u.getUserCode()) ;
				} 
			}
		} 
		resultPage.setResult(resultVersion) ;
		return resultPage ;
	}
	
	public int getNewVersionNum() {
		StringBuffer hql = new StringBuffer(" select max(tm.version) from NoderVersionInfo tm ");
		Object obj = this.findUnique(hql.toString()) ;
		if(obj == null) {
			return 1 ;
		}
		else {
			return Integer.parseInt(obj.toString())+1 ;
		}
	}
	
	public List<Integer> getVersionList(){
		String sql = "select nvi.version from NoderVersionInfo nvi" ;
		return this.find(sql) ;
	}
}
