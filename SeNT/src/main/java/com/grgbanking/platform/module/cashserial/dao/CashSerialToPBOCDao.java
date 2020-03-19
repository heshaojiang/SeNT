/**
 * 文件名：UserDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */

package com.grgbanking.platform.module.cashserial.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.module.cashserial.entity.CashSerialToPBOC;
import com.grgbanking.platform.module.menu.entity.Button;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.sent.utils.StringUtil;

/**
 * user entity Dao<br>
 * 用户管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class CashSerialToPBOCDao extends BaseDao<CashSerialToPBOC> {
	@Autowired
	OrgInfoDao orgInfoDao;

	// Method 1 (HQL): Create View UserInfo
	private static final String QUERY_USER_INFO_BY_USER_ID = "select userId, priviId from UserInfo where userId = ? ";

	/**
	 * Get the User Detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public CashSerialToPBOC getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the User Detail by User Code
	 * 
	 * @param userCode
	 * @return
	 */
	public CashSerialToPBOC getByUserCode(String userCode) {
		return super.findUniqueBy(AppCoreConstants.USER_CODE, userCode);
	}

	/**
	 * Get the User Group, Role and Privilege
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Object> getUserInfoByUserId(String userId) {
		// Method 1 (HQL): Create View UserInfo
		List<Object> userInfoList = super.find(QUERY_USER_INFO_BY_USER_ID, userId);

		// Method 2 (SQL): SQL statement
		// Query query =
		// getSession().createSQLQuery(QUERY_USER_INFO_BY_USER_ID);
		// query.setString(0, userId);
		// query.setString(1, userId);
		// List userInfoList = query.list();

		return userInfoList;
	}

	/**
	 * Check the new User name is not already exist when return 0 means is not
	 * exists when return 1 means exists
	 * 
	 * @param user
	 * @return
	 */
	public String checkAddUser(User user) {
		StringBuffer hql = new StringBuffer("");
		List<User> list = null;
		if (user.getId() == null) {
			hql.append("from User b where b.userCode = ?");
			list = this.find(hql.toString(), user.getUserCode());
		} else {
			hql.append("from User b where b.userName = ? and b.id <> ?");
			list = this.find(hql.toString(), user.getUserName(), user.getId());
		}
		if (list.isEmpty())
			return "0";
		return "1";
	}

	public Page<CashSerialToPBOC> getCashSerialToPBOCPage(final Page<CashSerialToPBOC> page, Map<String, String> condition)
	{
		StringBuffer hql = new StringBuffer("from CashSerialToPBOC c where 1=1");
		String serverName = StringUtil.trim(condition.get("serverName"));
		String serverIp    = StringUtil.trim(condition.get("serverIp"));
		String serverPort = StringUtil.trim(condition.get("serverPort"));
		String handlePerson    = StringUtil.trim(condition.get("handlePerson"));
		

		List<Object> parameterList = new ArrayList<Object>();
		
		if( StringUtil.isNotBlank(serverName) )
		{
			hql.append(" and c.serverName like ?");
			parameterList.add("%"+serverName+"%");
		}
		if( StringUtil.isNotBlank(serverIp) )
		{
			hql.append(" and c.serverIp like ?");
			parameterList.add("%"+serverIp+"%");
		}
		if( StringUtil.isNotBlank(serverPort) )
		{
			hql.append(" and c.serverPort like ?");
			parameterList.add("%"+serverPort+"%");
		}
		if( StringUtil.isNotBlank(handlePerson) )
		{
			hql.append(" and c.handlePerson like ?");
			parameterList.add("%"+handlePerson+"%");
		}
		
		
		return super.findPage(page, hql.toString(), parameterList.toArray());
		

	}
	
	public List getUserPageForExport(Map<String, String> condition)
	{
		String userName = StringUtil.trim(condition.get("LIKES_userName"));
		String orgId    = StringUtil.trim(condition.get("EQS_orgId"));
		
		StringBuffer hql = new StringBuffer(" from User u where 1=1");
		List<Object> parameterList = new ArrayList<Object>();
		
		if( StringUtil.isNotBlank(userName) )
		{
			hql.append(" and u.userName like ?");
			parameterList.add("%"+userName+"%");
		}
		
		if( StringUtil.isNotBlank(orgId) )
		{
			hql.append(" and (select o.pathCode from OrgInfo o where o.id = u.orgId ) like ? ");
			parameterList.add(StringUtil.trim(orgInfoDao.getPathCodeById(orgId)) + "%");
		}
		
		return super.findPageForExport(hql.toString(), parameterList.toArray());
	}

	public List<Object[]> getButtonsOfUser(String userId) {
		StringBuffer hql = new StringBuffer(
				"select p.menuId, b "
				+ "from Button b, Privilege p, UserInfo u "
						+ "where b.buttonType=? and b.id=p.buttonId and p.id = u.priviId and u.userId = ? order by p.menuId, b.order");

		return this.find(hql.toString(), new Object[] { Button.BUTTON_TYPE,
				userId });
	}

	public List<Object[]> getIconsOfUser(String userId) {
		StringBuffer hql = new StringBuffer(
				"select p.menuId, b "
				+ "from Button b, Privilege p, UserInfo u "
						+ "where b.buttonType=? and b.id=p.buttonId and p.id = u.priviId and u.userId = ? order by p.menuId, b.order");

		return this.find(hql.toString(), new Object[] { Button.ICON_TYPE,
				userId });
	}

	public List<Object[]> getPrivisOfUser(String userId) {
		StringBuffer hql = new StringBuffer(
				"select p.menuId, b "
						+ "from Button b, Privilege p, UserInfo u "
						+ "where b.buttonType=? and b.id=p.buttonId and p.id = u.priviId and u.userId = ? order by p.menuId, b.order");

		return this.find(hql.toString(), new Object[] { Button.PRIVI_TYPE,
				userId });
	}
}
