/**
 * 文件名：AreaService.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.area.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.dao.PropertyFilter;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.area.dao.AreaDao;
import com.grgbanking.platform.module.area.entity.Area;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.exproperty.service.ExPropertyService;
import com.grgbanking.platform.module.param.dao.ParamDao;

/**
 * area management service<br>
 * 区域管理服务类
 * 
 * @author hyuan
 * 
 */
@Service
@Transactional
public class AreaService extends BaseService {
	/** 扩展属性 */
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Autowired
	AreaDao areaDao;

	@Autowired
	private ParamDao paramDao;

	@Autowired
	public void loadExproperty(ExPropertyService service, ExtendPropertyDao exPropertyDao) {
		List<ExtendProperty> exPropertyList = service.getExtendPropertyList(Area.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList) {
			exPropertyMap.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}

	/**
	 * get detail by id<br>
	 * 根据id查询区域
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Area getArea(String id) {
		return areaDao.get(id);
	}

	/**
	 * newArea Used for save the data for Create a new area<br>
	 * 新增保存区域
	 * 
	 * @param area
	 * @return boolean
	 */
	public boolean newArea(Area area) {
		validateArea(area);

		if (area.getId() != null) {
			area.setId(null);
		}

		String areaName = area.getAreaName();
		List<Area> existedAreas = areaDao.getByAreaName(areaName, area.getParentId());

		Area existedArea = null;
		if (existedAreas != null && existedAreas.size() > 0) {
			existedArea = existedAreas.get(0);
		}
		/*
		 * Area Name can not be duplicated.
		 */
		if (existedArea != null)
			throw new AppException(MessageKeyConstants.AREA_EXISTED,
					"The Area Name already existed. Please change the Area Name and submit again.");
		String pid = area.getParentId();
		Area parentArea = areaDao.get(pid);
		if (parentArea != null) {
			int levelCodeLength = 5;
			try {
				String strLevelCodeLength = paramDao.getValueByPath(AppConstants.ORG_LEVELCODE_LENGTH_PATH);
				levelCodeLength = Integer.parseInt(strLevelCodeLength);
			} catch (NumberFormatException e) {
				logger.error("Param {} is setting error!", AppConstants.ORG_LEVELCODE_LENGTH_PATH);
			}

			String maxPathCode = areaDao.getMaxPathCodeByParentId(pid, parentArea.getPathCode().length() + 1);
			if (maxPathCode == null) {
				maxPathCode = "1";
			}
			maxPathCode = org.apache.commons.lang.StringUtils.leftPad(maxPathCode, levelCodeLength, '0');
			area.setPathCode(parentArea.getPathCode() + maxPathCode);
			area.setId(area.getPathCode());
		} else {
			logger.error("can not find parent organization!");
		}

		areaDao.save(area);
		return true;
	}

	/**
	 * Update the existed area. Area name can not be duplicated.<br>
	 * 更新保存区域
	 * 
	 * @param area
	 * @return boolean
	 */
	public boolean updateArea(Area area) {
		validateArea(area);
		validateId(area.getId());

		String areaName = area.getAreaName();
		List<Area> existedAreas = areaDao.getByAreaName(areaName, area.getParentId());

		Area existedArea = null;
		if (existedAreas != null && existedAreas.size() > 0) {
			existedArea = existedAreas.get(0);
		}

		/*
		 * Area Name can not be duplicated. Validate for following cases: 1: New
		 * Area case 2: Update Area
		 */
		if (existedArea != null && !existedArea.getId().equals(area.getId()))
			throw new AppException(MessageKeyConstants.AREA_EXISTED,
					"The Area Name already existed. Please change the Area Name and submit again.");

		areaDao.copyUpdate(area);

		return true;
	}

	/**
	 * Delete the Area by area id. Can not delete the area when it contain
	 * children area(s)<br>
	 * 删除区域
	 * 
	 * @param areaId
	 * @return boolean
	 */
	public boolean deleteArea(String areaId) {
		validateId(areaId);

		Collection<Area> childAreaList = getChildrenList(areaId);
		if (childAreaList != null && childAreaList.size() > 0)
			throw new AppException(MessageKeyConstants.AREA_CHILDREN_NOT_NULL,
					"This Area contain children area. Please delete all the children area first. ");

		areaDao.delete(areaId);

		return true;
	}

	/**
	 * 
	 * Batch delete all the selected areas. Can not delete the area when it
	 * contain children area(s)<br>
	 * 批量删除区域
	 * 
	 * @param areaIds
	 * @return boolean
	 */
	public boolean batchDelete(Collection<String> areaIds) {
		if (areaIds == null || areaIds.size() == 0)
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected.");

		for (String areaId : areaIds) {
			deleteArea(areaId);
		}

		return true;
	}

	/**
	 * search by parameter by page object and filter<br>
	 * 根据分页参数和过滤条件分页查询区域列表
	 * 
	 * @param page
	 * @param property
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Area> getByCondition(final Page<Area> page, final List<PropertyFilter> property) {
		return areaDao.findPage(page, property);
	}

	/**
	 * get children by areaId<br>
	 * 根据区域id查询子区域
	 * 
	 * @param areaId
	 * @return
	 */
	public Collection<Area> getChildrenList(String areaId) {
		return areaDao.getByParentId(areaId);
	}

	/**
	 * get area tree by root node id <br>
	 * 根据区域根节点id获得区域树xml字符串
	 * 
	 * @return
	 */
	public String getAreaTree(String rootId) {

		Area root = new Area();
		List<Area> areas = new ArrayList<Area>();

		if (rootId == null) {
			root = areaDao.getRootArea();
			rootId = root.getId();
		} else {
			root = areaDao.get(rootId);
		}
		areas = areaDao.getLeavesByParentId(rootId);

		String[] fields = { AppConstants.ID, AppConstants.AREA_NAME, AppConstants.NOTE, AppConstants.LEVEL,
				AppConstants.ORDER, "pathCode" };
		String srt = XmlUtil.genreatorTreeXml(root, AppConstants.ID, AppConstants.AREA_NAME, AppConstants.PARENT_ID,
				fields, areas);

		return srt;
	}

	/**
	 * get area tree by root node id <br>
	 * 根据区域根节点id获得区域树xml字符串（只查询未禁用区域）
	 * 
	 * @return
	 */
	public String getEnabledAreaTree(String rootId) {

		Area root = new Area();
		List<Area> areas = new ArrayList<Area>();

		if (rootId == null) {
			root = areaDao.getRootArea();
			rootId = root.getId();
		} else {
			root = areaDao.get(rootId);
		}
		areas = areaDao.getEnabledLeavesByParentId(rootId);

		String[] fields = { AppConstants.ID, AppConstants.AREA_NAME, AppConstants.NOTE, AppConstants.LEVEL, AppConstants.ORDER, "pathCode" };
		String srt = XmlUtil.genreatorTreeXml(root, AppConstants.ID, AppConstants.AREA_NAME, AppConstants.PARENT_ID, fields, areas);

		return srt;
	}

	/**
	 * 
	 * get max order+1<br>
	 * 根据父id查询子区域中最大顺序编号,然后加1
	 * 
	 * @param parentId
	 * @return Integer
	 */
	public Integer getMaxOrderValue(String parentId) {
		Integer maxOrder = areaDao.findUnique(
				"select max(m.order) from Area m where m.parentId = ? ",
				parentId);
		if (maxOrder != null)
			return maxOrder+1;
		else
			return null;
	}

	/**
	 * search by parameter by page object and filter and parent node id<br>
	 * 根据分页参数、过滤条件、父id分页查询区域列表
	 * 
	 * @param page
	 * @param filterParamMap
	 * @param parentId
	 * @return
	 */
	public Page<Area> getAreaPage(final Page<Area> page, Map<String, Object> propertyFilterMap, String parentId) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, Object>();
		}
		propertyFilterMap.put("EQS_parentId", parentId);
		page.setOrderBy("order");
		return areaDao.findPageNew(page, propertyFilterMap);
	}

	/**
	 * search by parameter by page object and filter and area name<br>
	 * 根据分页参数、过滤条件、区域名称分页查询区域列表
	 * 
	 * @param page
	 * @param areaName
	 * @param filterParamMap
	 * @return
	 */
	public Page<Area> searchAreaByAreaName(final Page<Area> page, String areaName, Map<String, Object> propertyFilterMap) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, Object>();
		}
		propertyFilterMap.put("LIKES_areaName", areaName);
		page.setOrderBy("id");
		return areaDao.findPageNew(page, propertyFilterMap);
	}

	/**
	 * 
	 * get all area <br>
	 * 获取全部区域
	 * 
	 * @return List<Area>
	 */
	public List<Area> getAllArea() {
		return areaDao.getAll();
	}

	/**
	 * 日期：2011-5-13<br>
	 * 版本：V1.0<br>
	 * 描述：validateId Use for validating the Area Id when modify the Area <br>
	 * 主要方法：<br>
	 * ===============================================<br>
	 * 创建日期：2011-5-13 上午11:36:20 <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-13<br>
	 * 修改人 Vinson<br>
	 * 修改描述 validateId Use for validating the Area Id when modify the Area <br>
	 * ===============================================<br>
	 * 
	 * @param areaId
	 * @return boolean
	 * @Exception 异常对象 <br>
	 */
	private boolean validateId(String areaId) {
		if (!StringUtils.hasText(areaId))
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected.");

		return true;
	}

	/**
	 * 日期：2011-5-13<br>
	 * 版本：V1.0<br>
	 * 描述：validateArea Use for validating the submit form of Area Module <br>
	 * 主要方法：<br>
	 * ===============================================<br>
	 * 创建日期：2011-5-13 上午11:36:25 <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-13<br>
	 * 修改人 Vinson<br>
	 * 修改描述 validateArea Use for validating the submit form of Area Module <br>
	 * ===============================================<br>
	 * 
	 * @param area
	 * @return boolean
	 * @Exception 异常对象 <br>
	 */
	private boolean validateArea(Area area) {
		if (area == null)
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again.");

		if (!StringUtils.hasText(area.getParentId()))
			throw new AppException(MessageKeyConstants.AREA_PARENT_NOT_NULL,
					"The Parent Area can not be left empty. Please select Parent Area and submit again. ");
		if (!StringUtils.hasText(area.getAreaName()))
			throw new AppException(MessageKeyConstants.AREA_NAME_NOT_NULL,
					"The Area Name can not be left empty. Please input the Area Name and submit again. ");

		return true;
	}

}
