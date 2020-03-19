/**
 * 文件名：AreaDao.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.area.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.area.entity.Area;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;

/**
 * Area entity Dao<br>
 * 区域管理Dao
 * 
 * @author yrliang
 * 
 */
@Repository
public class AreaDao extends BaseDao<Area> {
	ExtendPropertyDao extendPropertyDao;

	/**
	 * @deprecated use getRootArea() instead<br>
	 *             根据父id（是'0'）获取根节点
	 * 
	 * @return
	 */

	@Deprecated
	@SuppressWarnings("unchecked")
	public Area getRootByParentId(String parentId) {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> param = new HashMap<String, Object>();
		hql.append("from Area m where m.parentId =:parentId ");
		param.put("parentId", parentId);
		List<Area> list = find(hql.toString(), param);
		return (Area) list.get(0);
	}

	/**
	 * get root Area<br>
	 * 得到顶级的区域信息实体
	 * 
	 * @return
	 */
	public Area getRootArea() {
		List<Area> list = find("from Area m where m.parentId = '0'");
		return list.get(0);
	}

	/**
	 * use get(String id) instead
	 */
	@Deprecated
	public Area getByKey(String id) {

		return super.get(id);
	}

	/**
	 * get Area list by areaParentId<br>
	 * 根据父id查询下一级子区域列表
	 * 
	 * return area object
	 * 
	 * @param parentId
	 * @return
	 */
	public Collection<Area> getByParentId(String areaParentId) {
		return super.findBy(AppConstants.PARENT_ID, areaParentId);

	}
	
	public List<Area> getByParentId2(String areaParentId) {
		return super.findBy(AppConstants.PARENT_ID, areaParentId);

	}

	/**
	 * get Area list by name and parent id<br>
	 * 根据区域名称和父id查询下一级子区域列表
	 * 
	 * @param name
	 * @param parentId
	 * @return
	 * 
	 */
	public List<Area> getByAreaName(String name, String parentId) {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> param = new HashMap<String, Object>();
		hql.append("from Area m where m.areaName =:areaName and m.parentId =:parentId ");
		param.put("areaName", name);
		param.put("parentId", parentId);
		return super.find(hql.toString(), param);
	}

	/**
	 * @deprecated 根据父id（不是'0'),级联查询所有子区域列表
	 */
	@Deprecated
	public List<Area> getLeavesByRootId(String parentId) {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> param = new HashMap<String, Object>();
		hql.append("from Area m where m.parentId !=:parentId order by m.order");
		param.put("parentId", parentId);
		List<Area> list = super.find(hql.toString(), param);
		return list;
	}

	/**
	 * get Area list by root node id<br>
	 * 根据父节点id级联查询子区域列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Area> getLeavesByParentId(String parentId) {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> param = new HashMap<String, Object>();
		Area area = get(parentId);
		hql.append("from Area m where m.pathCode like :pathCode order by m.areaName asc");
		param.put("pathCode", area.getPathCode() + "%");
		List<Area> list = super.find(hql.toString(), param);
		return list;
	}

	/**
	 * get Area list by root node id<br>
	 * 根据父节点id级联查询未禁用子区域列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Area> getEnabledLeavesByParentId(String parentId) {
		StringBuffer hql = new StringBuffer("");
		Map<String, Object> param = new HashMap<String, Object>();
		Area area = get(parentId);
		hql.append("from Area m where m.status= 'Y' and m.pathCode like :pathCode order by m.order");
		param.put("pathCode", area.getPathCode() + "%");
		List<Area> list = super.find(hql.toString(), param);
		return list;
	}

	/**
	 * get max id of sub Area by parent node id<br>
	 * 根据父节点id查询子区域id最大值
	 * 
	 * @param parentId
	 * @return
	 */
	public String getMaxPathCodeByParentId(String parentId, int from) {
		String hql = "select max(o.pathCode) from Area o where parentId=?";
		List maxorders = this.find(hql.toString(), parentId);
		if (maxorders.get(0) != null) {
			String maxorder = maxorders.get(0).toString();
			maxorder = maxorder.substring(from, maxorder.length());
			Integer max = Integer.valueOf(maxorder) + 1;
			return String.valueOf(max);
		}
		return null;
	}

}
