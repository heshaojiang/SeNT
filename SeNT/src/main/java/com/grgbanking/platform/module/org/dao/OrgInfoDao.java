/**
 * 文件名：OrgInfoDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.org.dao;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.area.entity.Area;
import com.grgbanking.platform.module.org.entity.OrgInfo;




/**
 * OrgInfo Management Dao<br>
 * 机构管理Dao
 * 
 * @author hyuan
 * 
 */

@Repository
@SuppressWarnings("unchecked")
public class OrgInfoDao extends BaseDao<OrgInfo> {

	/**
	 * 根据父id（是'0'）获取根节点
	 * 
	 */
	public List<OrgInfo> getDirectSubOrg(String parentId) {

		List<OrgInfo> list = find(
				"from OrgInfo m where m.status='Y' and m.parentId = ?",
				parentId);
		return list;
	}
	
	/** 
	    * 根据机构id返回机构编码 
	    * 
	    * @param id 
	    *            机构Id 
	    * @return 机构路径标识码 
	    */ 
	   public String getOrgCodeById(Object id) 
	   { 
	      OrgInfo orgInfo = get(id.toString()); 
	      if( orgInfo!=null ) 
	      { 
	         return orgInfo.getOrgCode(); 
	      } 
	      else 
	      { 
	         return null; 
	      } 
	   }

	/**
	 * get root orgInfo<br>
	 * 得到顶级的机构信息实体
	 * 
	 * @return
	 */
	public OrgInfo getRootOrg() {
		List list = find("from OrgInfo m where m.parentId = '0'");
		return (OrgInfo) list.get(0);
	}

	@Deprecated
	public List<OrgInfo> getAllOrgInfoList(String orgInfoId) {
		return super.findBy(AppConstants.ID, orgInfoId);
	}

	@Deprecated
	public Collection<OrgInfo> getByOrgName(String orgName) {
		return super.findBy(AppConstants.C_ORGNAME, orgName);
	}

	/**
	 * getByOrgId OrgId can not be duplicated <br>
	 * 根据机构代码查找机构信息
	 * 
	 * @param orgId
	 * @return OrgInfo
	 */
	public OrgInfo getByOrgCode(String orgCode) {
		return super.findUniqueBy(AppConstants.ORG_CODE, orgCode);
	}
	
	public OrgInfo getByPathCode(String orgCode) {
		return super.findUniqueBy(AppConstants.PATH_CODE, orgCode);
	}
	
	/**
	 * 根据机构名称获取机构id
	 */
	public OrgInfo getInfoByOrgName(String orgName){
		return super.findUniqueBy(AppConstants.C_ORGNAME, orgName);
	}
	/**
	 * 
	 * get detail by parentId <br>
	 * 根据父id查询子机构列表
	 * 
	 * @param orgParentId
	 * @return Collection<OrgInfo>
	 */
	public Collection<OrgInfo> getByParentId(String orgParentId) {
		return super.findBy(AppConstants.PARENT_ID, orgParentId);
	}
	
	public List<OrgInfo> getByParentId2(String orgParentId) {
		return super.findBy(AppConstants.PARENT_ID, orgParentId);
	}

	/**
	 * 
	 * check if orgCode or orgName is duplicated when add a new org <br>
	 * 验证：增加机构时机构代码与机构名称不能重复 1:有重复:0没有重复
	 * 
	 * @param orgInfo
	 * @return String
	 */

	public String checkAddorgInfo(OrgInfo orgInfo) {
		StringBuffer hql = new StringBuffer(
				"from OrgInfo info where info.orgCode=? or info.orgFullName=?");
		Object values[] = new Object[] { orgInfo.getOrgCode(), orgInfo.getOrgFullName() };
		List list = this.find(hql.toString(), values);
		if (list.isEmpty())
			return "0";
		return "1";
	}

	/**
	 * 
	 * check if orgCode or orgName is duplicated when update a org <br>
	 * 验证：修改机构时机构代码与机构名称不能重复 1:有重复:0没有重复
	 * 
	 * @param orgInfo
	 * @return String
	 */
	public String checkModifyOrgInfo(OrgInfo orgInfo) {
		StringBuffer hql = new StringBuffer(
				" from OrgInfo  info where  info.id<>?  and info.orgCode=?");
		Object values[] = new Object[] { orgInfo.getId(), orgInfo.getOrgCode() };

		List list = this.find(hql.toString(), values);
		if (list.isEmpty())
			return "0";
		return "1";
	}

	/**
	 * @deprecated 根据父id（不是'0'),级联查询所有子机构列表
	 */
	@Deprecated
	public List<OrgInfo> getLeavesByRootId(String parentId) {
		List<OrgInfo> list = super
		// .find("from OrgInfo m where 1 = 1 and m.parentId = '0' and m.status='Y' order by m.order");
				.find("from OrgInfo m where m.parentId != ? order by m.order",
						parentId);
		return list;
	}

	/**
	 * get org list by root node id<br>
	 * 根据父节点id级联查询子机构列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<OrgInfo> getLeavesByParentId(String parentId) {
		OrgInfo info = get(parentId);
		List<OrgInfo> list = super
				.find("from OrgInfo m where m.pathCode like ? order by m.orgName asc",
						info.getPathCode() + "%");
		return list;
	}

	/**
	 * get org list by root node id<br>
	 * 根据父节点id级联查询未禁用子机构列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<OrgInfo> getEnabledLeavesByParentId(String parentId)
	{
		OrgInfo info = get(parentId);
		List<OrgInfo> list = null;
		if( info == null )
		{
			list = super.find("from OrgInfo m where m.status='Y' order by m.order");
		}
		else
		{
			list = super.find("from OrgInfo m where m.status='Y' and m.pathCode like ? order by m.order", info.getPathCode() + "%");
		}
		
		for( OrgInfo orgInfo : list )
		{
			orgInfo.setLabel(orgInfo.getOrgName());
		}
		
		return list;
	}

	/**
	 * get max pathCode of sub org by parent node pathCode<br>
	 * 根据父节点id查询子机构id最大值
	 * 
	 * @param parentId
	 * @return
	 */
	public String getMaxPathCodeByParentId(String parentId, int from) {
		StringBuffer hql = new StringBuffer(
				"select max(o.pathCode) from OrgInfo o where parentId=?");
		List maxorders = this.find(hql.toString(), parentId);
		if (maxorders.get(0) != null) {
			String maxorder = maxorders.get(0).toString();
			maxorder = maxorder.substring(from, maxorder.length());
			Integer max = Integer.valueOf(maxorder) + 1;
			return String.valueOf(max);
		}
		return null;
	}

	/**
	 * 根据机构id返回机构路径标识码
	 * 
	 * @param id
	 *            机构Id
	 * @return 机构路径标识码
	 */
	public String getPathCodeById(Object id)
	{
		OrgInfo orgInfo = get(id.toString());
		if( orgInfo!=null )
		{
			return orgInfo.getPathCode();
		}
		else
		{
			return null;
		}
	}
	public List<Object[]> getFatherIdAndChildrenIdByParentId(String parentId) {
		OrgInfo info = get(parentId);
		List<Object[]> list = super
				.find(
						"select a.orgCode ,b.orgCode as parentId, a.orgName, a.orgFullName, a.contact, a.tel, a.address, a.status,a.note, a.order from OrgInfo a ,OrgInfo b  where a.parentId=b.id and  b.pathCode like ? order by b.level asc,b.order asc,b.orgName asc",
						info.getPathCode() + "%");
		return list;
	}
	
	public OrgInfo getByKey(String id) {

		return super.get(id);
	}
	
	public String getPathCodeByOrgCode(String orgCode)
	{
		OrgInfo orgInfo = this.getByOrgCode(orgCode) ;
		if( orgInfo!=null )
		{
			return orgInfo.getPathCode();
		}
		else
		{
			return null;
		}
	}
}
