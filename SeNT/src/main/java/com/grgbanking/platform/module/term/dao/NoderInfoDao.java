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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.constans.TermInfoConsts;
import com.grgbanking.platform.module.term.entity.NoderInfo;
import com.grgbanking.platform.module.term.entity.TermInfo;
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
public class NoderInfoDao extends BaseDao<NoderInfo> {
	@Autowired
	private OrgInfoDao orgDao;

	@Autowired
	private TermModelDao termModelDao;

	@Autowired
	private TermInfoDao termInfoDao;

	@Autowired
	private TermTypeDao termTypeDao;

	@Autowired
	private ParamDao paramDao;

	private static final String QUERY_BY_TERMINAL_TERMCODE_FUZZILY = " from NoderInfo tm where tm.termCode like ? ";

	/**
	 * 根据终端编号查找终端<br>
	 * 
	 * get terminal by terminal code
	 * 
	 * @param termCode
	 *            终端编码
	 * @return NoderInfo
	 */
	// public NoderInfo getByTermCode(String termCode) {
	// //return super.findUniqueBy(AppConstants.TERMINAL_TERMCODE, termCode);
	// return super.findFirstBy(AppConstants.TERMINAL_TERMCODE, termCode);
	// }
	public boolean getByExistNoderIp(String nodeIp,String noderType,String noderId) {
		// return super.findUniqueBy(AppConstants.TERMINAL_TERMCODE, termCode);
		String hql = "from NoderInfo where noderIP='"+nodeIp+"' and noderType = '"+noderType+"'";
		if(!noderId.equals("")){
			hql += " and id<>'"+noderId+"'";
		}
//		return super.findFirstBy(AppConstants.NODER_IP, nodeIp);
		if(this.find(hql)!=null&&this.find(hql).size()>0){
			return true;
		}else{
			return false;
		}
//		return (NoderInfo) this.find(hql).get(0);
	}

	public boolean isExistingByTermCode(String termCode) {
		String hql = "select 1 from NoderInfo tm where tm.termCode = ?";
		Integer n = this.findFirst(hql, termCode);
		if (n == 1) {
			return true;
		} else {
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
	 * @return Page<NoderInfo>
	 */
	public Page<NoderInfo> getByTermCodeFuzzily(Page<NoderInfo> page,
			String termCode) {
		if (termCode == null || termCode.trim().length() == 0)
			return super.findPage(page);
		return super.findPage(page, QUERY_BY_TERMINAL_TERMCODE_FUZZILY, "%"
				+ termCode + "%");
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
	 * @return Page<NoderInfo>
	 */
	public Page<NoderInfo> getNoderInfoPageByParams(Page<NoderInfo> page,
			Map<String, String> params) {

		updateRunningStatus();// 刷新节点机状态

		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from NoderInfo tm ");
		hql.append(WHERE);
		for (String key : params.keySet()) {
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("noderIP") && !paramValue.equals("")) {
				hql.append(" tm.noderIP =:noderIP and ");
				param.put("noderIP", paramValue);
			} else if (key.equals("noderType") && !paramValue.equals("")) {
				hql.append(" tm.noderType =:noderType and ");
				param.put("noderType", paramValue);
			} else if (key.equals("orgCode") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("orgId") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("runningStatus") && !paramValue.equals("")
					&& paramValue != null) {
				hql.append(" tm.runningStatus =:runningStatus and ");
				param.put("runningStatus", paramValue);
			}
		}

		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}

		// hql.append(" order by tm.termCode asc ");
		return super.findPage(page, hql.toString(), param);
	}

	public List<NoderInfo> getNoderInfoListByParams(Map<String, String> params) {

		updateRunningStatus();// 刷新节点机状态

		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer(" from NoderInfo tm ");
		hql.append(WHERE);
		for (String key : params.keySet()) {
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("noderType") && !paramValue.equals("")) {
				hql.append(" tm.noderType =:noderType and ");
				param.put("noderType", paramValue);
			} else if (key.equals("noderIP") && !paramValue.equals("")) {
				hql.append(" tm.noderIP =:noderIP and ");
				param.put("noderIP", paramValue);
			} else if (key.equals("orgCode") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("orgId") && !paramValue.equals("")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" tm.orgCode in (select oi.orgCode from OrgInfo oi where oi.pathCode like :orgPathCode) and");
				param.put("orgPathCode", pathCode + "%");
			} else if (key.equals("runningStatus") && !paramValue.equals("")
					&& paramValue != null) {
				hql.append(" tm.runningStatus =:runningStatus and ");
				param.put("runningStatus", paramValue);
			}
		}

		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
			hql.delete(hql.length() - 4, hql.length());
		}

		// hql.append(" order by tm.termCode asc ");
		return super.findPage(hql.toString(), param);
	}

	// public List getNoderInfoPageByParams(Map<String, String> params) {
	//
	// updateRunningStatus(); //刷新节点机状态
	// Map<String, Object> param = new HashMap<String, Object>();
	// StringBuffer hql = new StringBuffer(" from NoderInfo tm ");
	// hql.append(WHERE);
	// for (String key : params.keySet()) {
	// if (params.get(key) == null) {
	// continue;
	// }
	// String paramValue = params.get(key);
	// if (key.equals("termCode") && !paramValue.equals("")) {
	// hql.append(" tm.termCode like :termCode and ");
	// param.put("termCode", "%" + paramValue + "%");
	// } else if (key.equals("model") && !paramValue.equals("")) {
	// hql.append(" tm.model =:model and ");
	// param.put("model", paramValue);
	// } else if (key.equals("termType") && !paramValue.equals("")) {
	// hql.append(" tm.termType =:termType and ");
	// param.put("termType", paramValue);
	// } else if (key.equals("brand") && !paramValue.equals("")) {
	// hql.append(" tm.brand =:brand and ");
	// param.put("brand", paramValue);
	// } else if (key.equals("netAddr") && !paramValue.equals("")) {
	// hql.append(" tm.netAddr =:netAddr and ");
	// param.put("netAddr", paramValue);
	// } else if (key.equals("userOrgid")) {
	// String pathCode = orgDao.getPathCodeById(paramValue);
	// hql.append(" (select o2.pathCode from OrgInfo o2 where o2.id = tm.orgId ) like :pathCode and ");
	// param.put("pathCode", pathCode + "%");
	// } else if (key.equals("orgCode") && !paramValue.equals("")) {
	// String pathCode = orgDao.getPathCodeById(paramValue);
	// hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :orgPathCode and ");
	// param.put("orgPathCode", pathCode + "%");
	// } else if (key.equals("areaId") && !paramValue.equals("")) {
	// hql.append(" (select a.pathCode from Area a where a.id = tm.areaId ) like :areaPathCode and ");
	// param.put("areaPathCode", paramValue + "%");
	// } else if (key.equals("orgId") && !paramValue.equals("")) {
	// String pathCode = orgDao.getPathCodeById(paramValue);
	// hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :orgPathCode and ");
	// param.put("orgPathCode", pathCode + "%");
	// } else if (key.equals("areaPathCode") && !paramValue.equals("")) {
	// hql.append(" (select a.pathCode from Area a where a.id = tm.areaId ) like :areaPathCode and ");
	// param.put("areaPathCode", paramValue + "%");
	// } else if (key.equals("serviceType")) {
	// hql.append(" tm.serviceType =:serviceType and ");
	// param.put("serviceType", paramValue);
	// } else if (key.equals("isInterATM")) {
	// hql.append(" tm.isInterATM =:isInterATM and ");
	// param.put("isInterATM", paramValue);
	// } else if (key.equals("layType")) {
	// hql.append(" tm.layType =:layType and ");
	// param.put("layType", paramValue);
	// } else if (key.equals("instType")) {
	// hql.append(" tm.instType =:instType and ");
	// param.put("instType", paramValue);
	// } else if (key.equals("today")) {
	// hql.append(" tm.activeDate <= :today and ");
	// param.put("today", new Date());
	// }
	// /*
	// * else if (key.equals("orgCode")) {
	// * hql.append(" tm.orgId =:orgCode and "); param.put("orgCode",
	// * paramValue); } else if (key.equals("areaId")) {
	// * hql.append(" tm.areaId =:areaId and "); param.put("areaId",
	// * paramValue); }
	// */
	// }
	//
	// hql.append(" tm.machineType = :machineType and ");
	// param.put("machineType", TermInfoConsts.MACHINE_TYPE_NODER);
	//
	//
	// if (hql.toString().endsWith(WHERE)) {
	// hql.delete(hql.length() - WHERE.length(), hql.length());
	// } else {
	// hql.delete(hql.length() - 4, hql.length());
	// }
	//
	// // hql.append(" order by tm.termCode asc ");
	// return super.findPage(hql.toString(), param);
	// }

	/**
	 * 根据终端ID查找终端数据<br>
	 * 
	 * @param page
	 *            页对象
	 * @param params
	 *            条件参数
	 * @return Page<NoderInfo>
	 */
	public Page<NoderInfo> getNoderInfoByTermid(Page<NoderInfo> page,
			Map<String, String> params) {
		String termCode = (String) params.get("termCode");
		String model = (String) params.get("model");
		String brand = (String) params.get("brand");
		String pathCode = (String) params.get("pathCode");
		String areaid = (String) params.get("areaid");

		Map<String, Object> param = new HashMap<String, Object>();

		StringBuffer hql = new StringBuffer(
				" from NoderInfo tm where tm.activeDate <= :today");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 1);
		Date date = c.getTime();
		param.put("today", new Date());

		// termCode
		if (StringUtil.isNotBlank(termCode)) {
			String[] termCodeArr = termCode.split(",");
			if (termCodeArr.length > 0) {
				hql.append(" and (");
				for (int i = 0; i < termCodeArr.length; i++) {
					if (i == termCodeArr.length - 1)
						hql.append(" tm.termCode like :termCode" + i);
					else
						hql.append(" tm.termCode like :termCode" + i + " or");

					param.put("termCode" + i, "%" + termCodeArr[i] + "%");
				}
				hql.append(")");
			}
		}
		// model
		if (StringUtil.isNotBlank(model)) {
			hql.append(" and tm.model =:model ");
			param.put("model", model);
		}
		// brand
		if (StringUtil.isNotBlank(brand)) {
			hql.append(" and tm.brand =:brand ");
			param.put("brand", brand);
		}
		// pathCode
		if (StringUtil.isNotBlank(pathCode)) {
			hql.append(" and (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :pathCode ");
			param.put("pathCode", pathCode + "%");
		}
		// areaid
		if (StringUtil.isNotBlank(areaid)) {
			hql.append(" and (select a.id from Area a where a.id = tm.areaId ) like :areaid ");
			param.put("areaid", areaid + "%");
		}

		hql.append(" order by tm.termCode asc ");
		return super.findPage(page, hql.toString(), param);
	}

	/**
	 * 根据终端ID查找终端数据
	 * 
	 * @param termCodes
	 *            : 多个termCode以','分隔
	 */
	public List<NoderInfo> getNoderInfoListByTermCodes(String termCodes) {
		String[] termCodeArr = StringUtil.splitTrim(termCodes, ",");
		if (termCodeArr.length == 0) {
			return new ArrayList<NoderInfo>();
		}

		List<Object> sqlParams = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer(" from NoderInfo tm"
				+ " where tm.termCode in ("
				+ StringUtil.generateMultiPartString("?", termCodeArr.length,
						", ") + ")");

		CollectionsUtil.addAll(sqlParams, termCodeArr);

		hql.append(" order by tm.termCode asc ");

		return this.find(hql.toString(), sqlParams.toArray());
	}

	/**
	 * 根据节点机device判断设备是否被其他节点机选了
	 * 
	 * @param termCodes
	 */
	public String checkTermIsSelectInOtherNoder(String noderId, String deviceStr) {
		if (deviceStr == null || deviceStr == "")
			return "";
		String[] devices = deviceStr.split(",");
		for (String device : devices) {
			TermInfo termInfo = termInfoDao.getByTermCode(device);
			if (termInfo == null)
				return device;
			List<Object> sqlParams = new ArrayList<Object>();
			StringBuffer hql = new StringBuffer(" from NoderInfo tm"
					+ " where tm.device like ?");
			sqlParams.add("%" + device + "%");
			if (noderId != null && noderId != "") {
				hql.append(" and tm.id!=?");
				sqlParams.add(noderId);
			}
			List<NoderInfo> noderInfos = this.find(hql.toString(),
					sqlParams.toArray());
			for (NoderInfo noderInfo : noderInfos) {
				String devicesStr2 = noderInfo.getDevice();
				String[] devices2 = devicesStr2.split(",");
				for (String device2 : devices2) {
					if (device.equals(device2)) {
						return device;
					}
				}
			}
		}
		return "";
	}

	/**
	 * 判断是否下载过节点机程序
	 * 
	 * @param orgCode
	 * @return
	 */
	public boolean isExistingByOrgCode(String orgCode) {
		String hql = "select 1 from NoderInfo tm where tm.orgCode = ?";
		Integer n = this.findFirst(hql, orgCode);
		if (n != null && n >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据参数查找终端数据<br>
	 * 
	 * @param page
	 *            page对象
	 * @param params
	 *            条件参数
	 * @return Page<NoderInfo>
	 */
	public Page<NoderInfo> getNoderInfoByParams(Page<NoderInfo> page,
			Map<String, String> params) {
		Map<String, Object> param = new HashMap<String, Object>();

		StringBuffer hql = new StringBuffer(" from NoderInfo tm ");
		hql.append(WHERE);

		hql.append(" tm.activeDate <= :today and ");
		param.put("today", new Date());

		for (String key : params.keySet()) {
			if (params.get(key) == null) {
				continue;
			}
			String paramValue = params.get(key);
			if (key.equals("model") && !paramValue.equals("")) {
				hql.append(" tm.model =:model and ");
				param.put("model", paramValue);
			} else if (key.equals("brand") && !paramValue.equals("")) {
				hql.append(" tm.brand =:brand and ");
				param.put("brand", paramValue);
			} else if (key.equals("orgid")) {
				String pathCode = orgDao.getPathCodeById(paramValue);
				hql.append(" (select o.pathCode from OrgInfo o where o.id = tm.orgId ) like :pathCode and ");
				param.put("pathCode", pathCode + "%");
			} else if (key.equals("areaid")) {
				hql.append(" (select a.id from Area a where a.id = tm.areaId ) like :areaid and ");
				param.put("areaid", paramValue + "%");
			}
		}
		if (hql.toString().endsWith(WHERE)) {
			hql.delete(hql.length() - WHERE.length(), hql.length());
		} else {
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
		StringBuffer hql = new StringBuffer(" from NoderInfo t ");
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
			if (hql.toString().endsWith(WHERE)) {
				hql.delete(hql.length() - WHERE.length(), hql.length());
			} else {
				hql.delete(hql.length() - 4, hql.length());
			}
		}
		List<NoderInfo> list = super.find(hql.toString(), param);
		return list.size();
	}

	// /**
	// * 联动查找终端类型
	// *
	// * @param params
	// * 参数
	// * @return 终端数
	// */
	// public List<NoderInfo> getNoderInfoListByParams(Map<String, String>
	// params) {
	// Map<String, Object> param = new HashMap<String, Object>();
	// StringBuffer hql = new StringBuffer(" from NoderInfo t ");
	// if (params != null) {
	// hql.append(WHERE);
	// for (String key : params.keySet()) {
	// if (params.get(key) == null) {
	// continue;
	// }
	// String paramValue = params.get(key);
	// if (key.equals("brand") && !paramValue.equals("")) {
	// hql.append(" t.brand =:brand and ");
	// param.put("brand", paramValue);
	// }
	// if (key.equals("termType") && !paramValue.equals("")) {
	// hql.append(" t.termType =:termType and ");
	// param.put("termType", paramValue);
	// }
	// if (key.equals("model") && !paramValue.equals("")) {
	// hql.append(" t.model =:model and ");
	// param.put("model", paramValue);
	// }
	// if (key.equals("orgid")) {
	// String pathCode = orgDao.getPathCodeById(paramValue);
	// hql.append(" (select o.pathCode from OrgInfo o where o.id = t.orgId ) like :pathCode and ");
	// param.put("pathCode", pathCode + "%");
	// }
	// if (key.equals("areaid")) {
	// hql.append(" (select a.id from Area a where a.id = t.areaId ) like :areaid and ");
	// param.put("areaid", paramValue + "%");
	// }
	//
	// }
	// if (hql.toString().endsWith(WHERE)) {
	// hql.delete(hql.length() - WHERE.length(), hql.length());
	// } else {
	// hql.delete(hql.length() - 4, hql.length());
	// }
	// }
	// List<NoderInfo> list = super.find(hql.toString(), param);
	// return list;
	// }
	//
	//
	// public void updateBrandIdAndTypeIdByModelId(String modelId, String
	// brandId, String typeId)
	// {
	// String hql =
	// "update NoderInfo t set t.brand=?, t.termType=? where t.model=?";
	// Object[] parameters = new Object[]{brandId, typeId, modelId};
	// this.executeUpdate(hql, parameters);
	// }

	/**
	 * 
	 */
	// public String getTermTypeNameByTermCode(String termCode)
	// {
	// NoderInfo termInfo = this.getByTermCode(termCode);
	// if(termInfo == null || termInfo.getTermType()==null ||
	// "".equals(termInfo.getTermType()))
	// {
	// return "";
	// }
	// TermType termType = termTypeDao.get(termInfo.getTermType());
	// if( termType==null )
	// {
	// return "";
	// }
	// return termType.getTypeName();
	// }

	public int updateRunningStatus() {

		int noderOffLineTime = 600;

		try {
			noderOffLineTime = Integer
					.parseInt(paramDao
							.getValueByPath(com.grgbanking.sent.common.Constants.AppConstants.NODER_OFF_LINE_TIME) == null ? "600"
							: paramDao
									.getValueByPath(com.grgbanking.sent.common.Constants.AppConstants.NODER_OFF_LINE_TIME));
		} catch (Exception e) {
			noderOffLineTime = 600;
		}

		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		int result = 0;
		try {
			String sql = "";
			String sql2 = "";
			if (DBDialectHelper.isMySql()) {
				sql = "update noder_info t set t.c_running_status='2' where (t.c_status_time is null or (now()-t.c_status_time)>"
						+ noderOffLineTime + ")";
				sql2 = "update noder_info t set t.c_running_status='0' where (t.c_status_time is not null and (now()-t.c_status_time)<="
						+ noderOffLineTime + ")";
			} else {
				sql = "update noder_info t set t.c_running_status='2' where (t.c_status_time is null or (sysdate-t.c_status_time)*24*60*60>"
						+ noderOffLineTime + ")";
				sql2 = "update noder_info t set t.c_running_status='0' where (t.c_status_time is not null and (sysdate-t.c_status_time)*24*60*60<="
						+ noderOffLineTime + ")";
			}
			Statement stmt = cnn.createStatement();
			result = stmt.executeUpdate(sql);
			result = stmt.executeUpdate(sql2);

			if (!cnn.getAutoCommit()) {
				cnn.commit();
			}
			session.close();
		} catch (SQLException e) {
			logger.error("", e);
			try {
				cnn.rollback();
				cnn.close();
				session.close();
			} catch (SQLException ee) {
				logger.error("", ee);
			}

		}
		return result;
	}

}
