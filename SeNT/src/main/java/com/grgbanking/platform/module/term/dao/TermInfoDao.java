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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.term.constans.TermInfoConsts;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.sent.utils.CollectionsUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 终端基础信息 Dao<br>
 * 
 * Terminal basal information Dao
 * 
 * @author Jonas
 * 
 */
@Repository
public class TermInfoDao extends BaseDao<TermInfo>
{
	@Autowired
	private OrgInfoDao orgDao;
	
	@Autowired
	private TermModelDao termModelDao;
	
	@Autowired
	private TermTypeDao termTypeDao;
	
	
	private static final String QUERY_BY_TERMINAL_TERMCODE_FUZZILY = " from TermInfo tm where tm.termCode like ? ";

	/**
	 * 根据终端编号查找终端<br>
	 * 
	 * get terminal by terminal code
	 * 
	 * @param termCode
	 *            终端编码
	 * @return TermInfo
	 */
	public TermInfo getByTermCode(String termCode) {
		//return super.findUniqueBy(AppConstants.TERMINAL_TERMCODE, termCode);
		return super.findFirstBy(AppConstants.TERMINAL_TERMCODE, termCode);
	}
	
	public boolean isExistingByTermCode(String termCode)
	{
		String hql = "select 1 from TermInfo tm where tm.termCode = ?";
		Integer n = this.findFirst(hql, termCode);
		if( n==1 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 根据终端编号查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by terminal code and page information
	 * 
	 * @param page
	 *            页对象
	 * @param termCode
	 *            终端编码
	 * @return Page<TermInfo>
	 */
	public Page<TermInfo> getByTermCodeFuzzily(Page<TermInfo> page, String termCode) {
		if (termCode == null || termCode.trim().length() == 0)
			return super.findPage(page);
		return super.findPage(page, QUERY_BY_TERMINAL_TERMCODE_FUZZILY, "%" + termCode + "%");
	}

	/**
	 * 根据参数查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by params and page information
	 * 
	 * @param page
	 *            页对象
	 * @param params
	 *            条件参数
	 * @return Page<TermInfo>
	 */
	public Page<TermInfo> getTermInfoPageByParams(Page<TermInfo> page, Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from TermInfo tm ");
		hql.append(WHERE);
		String flag=(String)params.get("flag");
		for (String key : params.keySet()) {
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("termCode") && !paramValue.equals("")) {
				hql.append(" tm.termCode like :termCode and ");
				param.put("termCode", "%" + paramValue + "%");
			} else if (key.equals("model") && !paramValue.equals("")) {
				hql.append(" tm.model =:model and ");
				param.put("model", paramValue);
			} else if (key.equals("termType") && !paramValue.equals("")) {
				hql.append(" tm.termType =:termType and ");
				param.put("termType", paramValue);
			} else if (key.equals("brand") && !paramValue.equals("")) {
				hql.append(" tm.brand =:brand and ");
				param.put("brand", paramValue);
			} else if (key.equals("netAddr") && !paramValue.equals("")) {
				hql.append(" tm.netAddr =:netAddr and ");
				param.put("netAddr", paramValue);
			} else if (key.equals("userOrgid")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o2.pathCode from OrgInfo o2 where o2.id = tm.orgId ) like :pathCode and ");
				param.put("pathCode", pathCode + "%");
			} else if (key.equals("orgCode") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :orgPathCode and ");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("areaId") && !paramValue.equals("")) {
				hql.append(" (select a.pathCode from Area a where a.id = tm.areaId ) like :areaPathCode and ");
				param.put("areaPathCode", paramValue + "%");
			} else if (key.equals("orgId") && !paramValue.equals("")) {
				if(null == flag || flag.equals("true")){
					String pathCode = orgDao.getPathCodeById(paramValue);
					hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :orgPathCode and ");
					param.put("orgPathCode", pathCode + "%");
				}else{
					String pathCode = orgDao.getPathCodeById(paramValue);
					hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) = :orgPathCode and ");
					param.put("orgPathCode", pathCode + "");
				}
			} else if (key.equals("areaPathCode") && !paramValue.equals("")) {
				hql.append(" (select a.pathCode from Area a where a.id = tm.areaId ) like :areaPathCode and ");
				param.put("areaPathCode", paramValue + "%");
			} else if (key.equals("serviceType")) {
				hql.append(" tm.serviceType =:serviceType and ");
				param.put("serviceType", paramValue);
			} else if (key.equals("isInterATM")) {
				hql.append(" tm.isInterATM =:isInterATM and ");
				param.put("isInterATM", paramValue);
			} else if (key.equals("layType")) {
				hql.append(" tm.layType =:layType and ");
				param.put("layType", paramValue);
			} else if (key.equals("instType")) {
				hql.append(" tm.instType =:instType and ");
				param.put("instType", paramValue);
			} else if (key.equals("today")) {
				hql.append(" tm.activeDate <= :today and ");
				param.put("today", new Date());
			}
			/*
			 * else if (key.equals("orgCode")) {
			 * hql.append(" tm.orgId =:orgCode and "); param.put("orgCode",
			 * paramValue); } else if (key.equals("areaId")) {
			 * hql.append(" tm.areaId =:areaId and "); param.put("areaId",
			 * paramValue); }
			 */
		}
		hql.append(" machineType != :machineType and ");
		param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}

		hql.append(" order by tm.termCode asc ");
		return super.findPage(page, hql.toString(), param);
	}
	
	public List getTermInfoPageByParams(Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from TermInfo tm ");
		hql.append(WHERE);
		for (String key : params.keySet()) {
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("termCode") && !paramValue.equals("")) {
				hql.append(" tm.termCode like :termCode and ");
				param.put("termCode", "%" + paramValue + "%");
			} else if (key.equals("model") && !paramValue.equals("")) {
				hql.append(" tm.model =:model and ");
				param.put("model", paramValue);
			} else if (key.equals("termType") && !paramValue.equals("")) {
				hql.append(" tm.termType =:termType and ");
				param.put("termType", paramValue);
			} else if (key.equals("brand") && !paramValue.equals("")) {
				hql.append(" tm.brand =:brand and ");
				param.put("brand", paramValue);
			} else if (key.equals("netAddr") && !paramValue.equals("")) {
				hql.append(" tm.netAddr =:netAddr and ");
				param.put("netAddr", paramValue);
			} else if (key.equals("userOrgid")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o2.pathCode from OrgInfo o2 where o2.id = tm.orgId ) like :pathCode and ");
				param.put("pathCode", pathCode + "%");
			} else if (key.equals("orgCode") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :orgPathCode and ");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("areaId") && !paramValue.equals("")) {
				hql.append(" (select a.pathCode from Area a where a.id = tm.areaId ) like :areaPathCode and ");
				param.put("areaPathCode", paramValue + "%");
			} else if (key.equals("orgId") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :orgPathCode and ");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("areaPathCode") && !paramValue.equals("")) {
				hql.append(" (select a.pathCode from Area a where a.id = tm.areaId ) like :areaPathCode and ");
				param.put("areaPathCode", paramValue + "%");
			} else if (key.equals("serviceType")) {
				hql.append(" tm.serviceType =:serviceType and ");
				param.put("serviceType", paramValue);
			} else if (key.equals("isInterATM")) {
				hql.append(" tm.isInterATM =:isInterATM and ");
				param.put("isInterATM", paramValue);
			} else if (key.equals("layType")) {
				hql.append(" tm.layType =:layType and ");
				param.put("layType", paramValue);
			} else if (key.equals("instType")) {
				hql.append(" tm.instType =:instType and ");
				param.put("instType", paramValue);
			} else if (key.equals("today")) {
				hql.append(" tm.activeDate <= :today and ");
				param.put("today", new Date());
			}
			/*
			 * else if (key.equals("orgCode")) {
			 * hql.append(" tm.orgId =:orgCode and "); param.put("orgCode",
			 * paramValue); } else if (key.equals("areaId")) {
			 * hql.append(" tm.areaId =:areaId and "); param.put("areaId",
			 * paramValue); }
			 */
		}
		hql.append(" machineType != :machineType and ");
		param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}

		hql.append(" order by tm.termCode asc ");
		return super.findPage(hql.toString(), param);
	}

	/**
	 * 根据终端ID查找终端数据<br>
	 * 
	 * @param page
	 *            页对象
	 * @param params
	 *            条件参数
	 * @return Page<TermInfo>
	 */
	public Page<TermInfo> getTermInfoByTermid(Page<TermInfo> page, Map<String, String> params)
	{
		String termCode = (String)params.get("termCode");
		String model    = (String)params.get("model");
		String brand    = (String)params.get("brand");
		String pathCode = (String)params.get("pathCode");
		String areaid   = (String)params.get("areaid");
		String initOrgStr   = (String)params.get("initOrgStr");
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer(" from TermInfo tm where tm.activeDate <= :today");
		Calendar c = Calendar.getInstance();  
        c.setTime(new Date());   
        c.add(Calendar.DATE, 1); 
        Date date = c.getTime();
		param.put("today", new Date());
		
		// termCode
		if( StringUtil.isNotBlank(termCode) )
		{
			String[] termCodeArr = termCode.split(",");
			if(termCodeArr.length > 0){
				hql.append(" and (");
				for(int i = 0; i < termCodeArr.length; i++){
					if(i == termCodeArr.length - 1)
						hql.append(" tm.termCode like :termCode" + i);
					else
						hql.append(" tm.termCode like :termCode" + i + " or");
					
					param.put("termCode" + i, "%" + termCodeArr[i] + "%");
				}
				hql.append(")");
			}
		}
		// model
		if( StringUtil.isNotBlank(model) )
		{
			hql.append(" and tm.model =:model ");
			param.put("model", model);
		}
		// brand
		if( StringUtil.isNotBlank(brand) )
		{
			hql.append(" and tm.brand =:brand ");
			param.put("brand", brand);
		}
		// pathCode
		if( StringUtil.isNotBlank(pathCode) )
		{
			hql.append(" and (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :pathCode ");
			param.put("pathCode", pathCode + "%");
		}
		
		// initOrgStr 节点机选设备的时候只能选择同个机构下的
		if( StringUtil.isNotBlank(initOrgStr) )
		{
			hql.append(" and (select o.orgCode from OrgInfo o where o.id = tm.orgId ) =:initOrgStr ");
			param.put("initOrgStr", initOrgStr);
		}
		
		// areaid
		if( StringUtil.isNotBlank(areaid) )
		{
			hql.append(" and (select a.id from Area a where a.id = tm.areaId ) like :areaid ");
			param.put("areaid", areaid + "%");
		}
		
		hql.append(" and tm.machineType != :machineType ");
		param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
		
		hql.append(" order by tm.termCode asc ");
		return super.findPage(page, hql.toString(), param);
	}
	
	/**
	 * 根据终端ID查找终端数据
	 * @param termCodes: 多个termCode以','分隔
	 */
	public List<TermInfo> getTermInfoListByTermCodes(String termCodes)
	{
		String[] termCodeArr = StringUtil.splitTrim(termCodes, ",");
		if( termCodeArr.length==0 )
		{
			return new ArrayList<TermInfo>();
		}
		
		List<Object> sqlParams = new ArrayList<Object>();
		
		StringBuffer hql = new StringBuffer(
			" from TermInfo tm" +
			" where tm.termCode in ("+StringUtil.generateMultiPartString("?", termCodeArr.length, ", ")+")"+
			" and tm.machineType!="+TermInfoConsts.MACHINE_TYPE_NODER
		);
		
		CollectionsUtil.addAll(sqlParams, termCodeArr);

		hql.append(" order by tm.termCode asc ");
		
		return this.find(hql.toString(), sqlParams.toArray());
	}
	
	/**
	 * 根据终端code更新节点机信息
	 * @param termCodes
	 */
	public boolean updateTermInfoForTermInfo(String termCode)
	{

		List<Object> sqlParams = new ArrayList<Object>();
		
		StringBuffer hql = new StringBuffer(
			" from TermInfo tm" +
			" where tm.device like '%"+termCode+"%'"+
			" and tm.machineType="+TermInfoConsts.MACHINE_TYPE_NODER
		);
		
		List<TermInfo> termInfos= this.find(hql.toString(), sqlParams.toArray());
		for(TermInfo termInfo:termInfos){
			String updateDeviceStr = "";
			String devicesStr = termInfo.getDevice();
			String[] devices = devicesStr.split(",");
			for(String device:devices){
				if(!termCode.equals(device)){
					updateDeviceStr = updateDeviceStr + device +",";
				}
				
			}
			termInfo.setDevice(updateDeviceStr==""?"":updateDeviceStr.substring(0, updateDeviceStr.length()-1));
			copyUpdate(termInfo);
		}
		
		return true;
	}

	/**
	 * 根据参数查找终端数据<br>
	 * 
	 * @param page
	 *            page对象
	 * @param params
	 *            条件参数
	 * @return Page<TermInfo>
	 */
	public Page<TermInfo> getTermInfoByParams(Page<TermInfo> page, Map<String, String> params)
	{
		Map<String, Object> param = new HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer(" from TermInfo tm ");
		hql.append(WHERE);

		hql.append(" tm.activeDate <= :today and ");
		param.put("today", new Date());

		for (String key : params.keySet())
		{
			if (params.get(key) == null)
			{
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("model") && !paramValue.equals(""))
			{
				hql.append(" tm.model =:model and ");
				param.put("model", paramValue);
			}
			else if (key.equals("brand") && !paramValue.equals(""))
			{
				hql.append(" tm.brand =:brand and ");
				param.put("brand", paramValue);
			}
			else if (key.equals("orgid"))
			{
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :pathCode and ");
				param.put("pathCode", pathCode + "%");
			}
			else if (key.equals("areaid"))
			{
				hql.append(" (select a.id from Area a where a.id = tm.areaId ) like :areaid and ");
				param.put("areaid", paramValue + "%");
			}
		}
		
		hql.append(" tm.machineType != :machineType and ");
		param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
		
		if (hql.toString().endsWith(WHERE))
		{
			hql.delete(hql.length() - WHERE.length(), hql.length());
		}
		else
		{
			hql.delete(hql.length() - 4, hql.length());
		}

		hql.append(" order by tm.termCode asc ");
		return super.findPage(page, hql.toString(), param);
	}

	/**
	 * 联动查找终端类型
	 * 
	 * @param params
	 *            参数
	 * @return 终端数
	 */
	public int getTermSumListByParams(Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from TermInfo t ");
		if (params != null) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("brand") && !paramValue.equals("")) {
					hql.append(" t.brand =:brand and ");
					param.put("brand", paramValue);
				}
				if (key.equals("termType") && !paramValue.equals("")) {
					hql.append(" t.termType =:termType and ");
					param.put("termType", paramValue);
				}
				if (key.equals("model") && !paramValue.equals("")) {
					hql.append(" t.model =:model and ");
					param.put("model", paramValue);
				}
				if (key.equals("orgid")) {
					String pathCode = orgDao.getPathCodeById(paramValue);
					hql.append(" (select o.pathCode from OrgInfo o where o.id = t.orgId ) like :pathCode and ");
					param.put("pathCode", pathCode + "%");
				}
				if (key.equals("areaid")) {
					hql.append(" (select a.id from Area a where a.id = t.areaId ) like :areaid and ");
					param.put("areaid", paramValue + "%");
				}
				
				if (key.equals("machineType") && !paramValue.equals("")) {
					hql.append(" t.machineType =:machineType2 and ");
					param.put("machineType2", paramValue);
				}

			}
			
			hql.append(" t.machineType != :machineType and ");
			param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
			
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		List<TermInfo> list = super.find(hql.toString(), param);
		return list.size();
	}

	/**
	 * 联动查找终端类型
	 * 
	 * @param params
	 *            参数
	 * @return 终端数
	 */
	public List<TermInfo> getTermInfoListByParams(Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from TermInfo t ");
		if (params != null) {
			hql.append(WHERE);
			for (String key : params.keySet()) {
				if (params.get(key) == null) {
					continue;
				}
				String paramValue = params.get(key);
				if (key.equals("brand") && !paramValue.equals("")) {
					hql.append(" t.brand =:brand and ");
					param.put("brand", paramValue);
				}
				if (key.equals("termType") && !paramValue.equals("")) {
					hql.append(" t.termType =:termType and ");
					param.put("termType", paramValue);
				}
				if (key.equals("model") && !paramValue.equals("")) {
					hql.append(" t.model =:model and ");
					param.put("model", paramValue);
				}
				if (key.equals("orgid")) {
					String pathCode = orgDao.getPathCodeById(paramValue);
					hql.append(" (select o.pathCode from OrgInfo o where o.id = t.orgId ) like :pathCode and ");
					param.put("pathCode", pathCode + "%");
				}
				if (key.equals("areaid")) {
					hql.append(" (select a.id from Area a where a.id = t.areaId ) like :areaid and ");
					param.put("areaid", paramValue + "%");
				}

			}
			
			hql.append(" t.machineType != :machineType and ");
			param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
			
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		List<TermInfo> list = super.find(hql.toString(), param);
		return list;
	}
	
	
	public void updateBrandIdAndTypeIdByModelId(String modelId, String brandId, String typeId)
	{
		String hql = "update TermInfo t set t.brand=?, t.termType=? where t.model=?";
		Object[] parameters = new Object[]{brandId, typeId, modelId};
		this.executeUpdate(hql, parameters);
	}
	
	/**
	 * 
	 */
	public String getTermTypeNameByTermCode(String termCode)
	{
		TermInfo termInfo = this.getByTermCode(termCode);
		if(termInfo == null || termInfo.getTermType()==null || "".equals(termInfo.getTermType()))
		{
			return "";
		}
		TermType termType = termTypeDao.get(termInfo.getTermType());
		if( termType==null )
		{
			return "";
		}
		return termType.getTypeName();
	}
	
}



